package com.example.basicfourm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

public class debugActivity extends AppCompatActivity {
    private Button btnToLogin;
    private Button btnToNewPost;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //关联布局
        setContentView(com.example.basicfourm.R.layout.activity_debug);
        btnToLogin = findViewById(R.id.btn_to_login);
        btnToNewPost = findViewById(R.id.btn_to_newpost);
    }

    public void OnClick(View view) {
        int id = view.getId();
        if (id == btnToLogin.getId()) {

        } else if (id == btnToNewPost.getId()) {

        } else {
            Toast.makeText(debugActivity.this, "Btn Clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    private void ToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void ToNewPost(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
