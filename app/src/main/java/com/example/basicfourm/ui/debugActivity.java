package com.example.basicfourm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

public class debugActivity extends AppCompatActivity {
    private Button btnToLogin;
    private Button btnToNewPost;
    private Button btnToModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //关联布局
        setContentView(com.example.basicfourm.R.layout.activity_debug);
        btnToLogin = findViewById(R.id.btn_to_login);
        btnToNewPost = findViewById(R.id.btn_to_newpost);
        btnToModule = findViewById(R.id.btn_to_module);

        //监听按钮OnClick事件
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToLogin(view);
            }
        });
        btnToNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToNewPost(view);
            }
        });
        btnToModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToModule(view);
            }
        });
    }

    private void ToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void ToNewPost(View view) {
        Intent intent = new Intent(this, NewPostActivity.class);
        startActivity(intent);
    }

    private void ToModule(View view) {
        Intent intent = new Intent(this, ModuleActivity.class);
        startActivity(intent);
    }
}
