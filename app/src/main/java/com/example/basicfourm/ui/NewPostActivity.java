package com.example.basicfourm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

public class NewPostActivity extends AppCompatActivity {
    private Button btnSendPost;
    private Button btnReturn;
    private EditText PostInputTitle;
    private EditText PostInputSubTitle;
    private EditText PostInputContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);
        btnReturn = findViewById(R.id.btn_return);
        btnSendPost= findViewById(R.id.btn_sendPost);
        PostInputContent = findViewById(R.id.newpost_input_content);
        PostInputTitle = findViewById(R.id.newpost_input_title);
        PostInputSubTitle = findViewById(R.id.newpost_input_subTitle);

        //设置按钮监听事件
        btnSendPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(NewPostActivity.this, "1", Toast.LENGTH_SHORT).show();
                if(isPostValid())
                {
                    Toast.makeText(NewPostActivity.this, "帖子已发布", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NewPostActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean isPostValid() {
        String title = PostInputTitle.getText().toString().trim();
        if(title.equals(""))
        {
            Toast.makeText(NewPostActivity.this, "帖子标题不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
