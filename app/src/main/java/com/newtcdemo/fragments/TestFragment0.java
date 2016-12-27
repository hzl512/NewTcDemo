package com.newtcdemo.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.newtcdemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment0 extends Fragment {


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

    private void postNet(){
        textResult.setText("这是测试的数据哦");
    }

}
