package com.newtcdemo.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.newtcdemo.ClipImage.ClipImageResultActivity;
import com.newtcdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment1 extends Fragment {

    Button btnAdd;

    public TestFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_test_fragment1, container, false);
        btnAdd=(Button)view.findViewById(R.id.btnAdd);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                EventBus.getDefault().post(new MessageEvent("使用事件总线添加数据"));
            startActivity(new Intent(getActivity(), ClipImageResultActivity.class));
            }
        });
    }

}
