package com.newtcdemo.services;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * helper methods.
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"service starting",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
