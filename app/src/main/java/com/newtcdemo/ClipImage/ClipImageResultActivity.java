package com.newtcdemo.ClipImage;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.newtcdemo.R;
import com.newtcdemo.utils.FileUtil;
import com.newtcdemo.utils.GetPathFromUri4kitkatUtil;
import com.newtcdemo.utils.ToastUtil;

import java.io.File;

public class ClipImageResultActivity extends Activity {

    private static final int PHOTO_PICKED_WITH_DATA = 3021;
    private static final int CAMERA_WITH_DATA = 3023;
    /* 拍照的照片存储位置 */
    private File PHOTO_DIR = null;
    // 照相机拍照得到的图片
    private File mCurrentPhotoFile;
    private String mFileName;

    Button button,button2;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clip_image_result);
        PHOTO_DIR = new File(FileUtil.getDiskCacheDir(ClipImageResultActivity.this));
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);
        image=(ImageView)findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 从相册中去获取
                try {
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
                    intent.setType("image/*");
                    startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
                } catch (ActivityNotFoundException e) {
                    ToastUtil.showShort(ClipImageResultActivity.this,"没有找到照片");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doTakePhoto();
            }
        });
    }

    /**
     * 拍照获取图片
     */
    protected void doTakePhoto() {
        try {
            mFileName = System.currentTimeMillis() + ".jpg";
            mCurrentPhotoFile = new File(PHOTO_DIR, mFileName);
            Uri uriForFile;
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {
                uriForFile = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", mCurrentPhotoFile);
            }else {
                uriForFile= Uri.fromFile(mCurrentPhotoFile);
            }
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uriForFile);
            startActivityForResult(intent, CAMERA_WITH_DATA);
        } catch (Exception e) {
            Log.d("ClipImageResultActivity", "doTakePhoto =" + e.toString());
            ToastUtil.showShort(this, "未找到系统相机程序");
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK
                && data != null
                && (requestCode == Const.REQUEST_CLIP_IMAGE || requestCode == Const.REQUEST_TAKE_PHOTO)) {
            String path = ClipImageActivity.ClipOptions.createFromBundle(data).getOutputPath();
            if (path != null) {
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                image.setImageBitmap(bitmap);
            }
            return;
        }

        if (requestCode== PHOTO_PICKED_WITH_DATA) {
            Uri uri = data.getData();
            String currentFilePath = GetPathFromUri4kitkatUtil.getPath(this, uri);
            Log.d("ClipImageResultActivity", "uri =" + uri.toString() + "存储卡中图片的路径是 = " + currentFilePath +"  保存的路径"+FileUtil.getDiskCacheDir(ClipImageResultActivity.this));
            if (!TextUtils.isEmpty(currentFilePath)) {
                ClipImageActivity.prepare()
                        .aspectX(1).aspectY(1)
                        .inputPath(currentFilePath).outputPath(FileUtil.getDiskCacheDir(ClipImageResultActivity.this)+"/"+System.currentTimeMillis()+".jpg")
                        .startForResult(this, Const.REQUEST_CLIP_IMAGE);
            }
        }
        if (requestCode== CAMERA_WITH_DATA) {
            String currentFilePath =  mCurrentPhotoFile.getPath();
            Log.d("ClipImageResultActivity", "存储卡中图片的路径是 = " + currentFilePath +"  保存的路径"+FileUtil.getDiskCacheDir(ClipImageResultActivity.this));
            if (!TextUtils.isEmpty(currentFilePath)) {
                ClipImageActivity.prepare()
                        .aspectX(1).aspectY(1)
                        .inputPath(currentFilePath).outputPath(FileUtil.getDiskCacheDir(ClipImageResultActivity.this)+"/"+System.currentTimeMillis()+".jpg")
                        .startForResult(this, Const.REQUEST_CLIP_IMAGE);
            }
        }


    }
}
