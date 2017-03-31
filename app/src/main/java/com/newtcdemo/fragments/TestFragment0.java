package com.newtcdemo.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.newtcdemo.R;
import com.newtcdemo.data0.BaseRequest;
import com.newtcdemo.data0.PostRoute;
import com.newtcdemo.data0.ResCommodity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment0 extends Fragment {

    private static final String URL = "http://192.168.1.226:8080/";

    Button btnSelect;
    TextView textResult;

    public TestFragment0() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_fragment0, container, false);
        btnSelect = (Button) view.findViewById(R.id.btnSelect);
        textResult = (TextView) view.findViewById(R.id.textResult);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        btnSelect.setOnClickListener(view -> Snackbar.make(view, "123", Snackbar.LENGTH_SHORT).setAction("Action", null).show());
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postNet();
            }
        });

    }

    private void postNet() {
        textResult.setText("这是测试的数据哦");
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setId(1);
        Gson gson = new Gson();
        String route = gson.toJson(baseRequest);
        Log.e("post", "//");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostRoute postRoute = retrofit.create(PostRoute.class);
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), route);
        Call<ResCommodity> call = postRoute.postCommoditys(body, 6);
        call.enqueue(new Callback<ResCommodity>() {
            @Override
            public void onResponse(Call<ResCommodity> call, Response<ResCommodity> response) {

                try {
                    Log.e("sssss", "-----------------------" + response.body());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResCommodity> call, Throwable t) {
                Log.e("sssss", t.getMessage());
            }
        });


        Log.e("postjson", route);
    }

//    @Subscribe()
//    public void onMessageEvent(MessageEvent event) {
//        textResult.setText(event.message);
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }

}
