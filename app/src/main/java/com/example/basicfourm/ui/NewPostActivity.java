package com.example.basicfourm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

public class NewPostActivity extends AppCompatActivity {
    private Button btnSendPost;
    private Button btnReturn;
    private EditText postInputTitle;
    private EditText postInputSubTitle;
    private EditText postInputContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);
        btnReturn = findViewById(R.id.btn_return);
        btnSendPost= findViewById(R.id.btn_sendPost);
        postInputContent = findViewById(R.id.newpost_input_content);
        postInputTitle = findViewById(R.id.newpost_input_title);
        postInputSubTitle = findViewById(R.id.newpost_input_subTitle);

        //设置按钮监听事件
        btnSendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
