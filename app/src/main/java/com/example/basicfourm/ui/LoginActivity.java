package com.example.basicfourm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnSelectLogin;
    private Button btnSelectSignUp;
    private Button btnLogin;
    private Button btnSignUp;
    private LinearLayout LayoutLogin;
    private LinearLayout LayoutSignUp;
    private boolean isLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(R.layout.activity_login);
        btnSelectLogin = findViewById(R.id.btn_select_login);
        btnSelectSignUp = findViewById(R.id.btn_select_sign_up);
        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_sign_up);
        LayoutLogin = findViewById(R.id.layout_login);
        LayoutSignUp= findViewById(R.id.layout_sign_up);
        isLogin = true;
        showLoginLayout();
    }

    private void setBtnSelected(Button btn) {
        btn.setClickable(false);
        btn.setTextColor(getColor(R.color.app_btnText_selected));
    }

    private void setBtnUnSelected(Button btn) {
        btn.setClickable(true);
        btn.setTextColor(getColor(R.color.app_btnText_notSelected));
    }

    private void showLoginLayout() {
        setBtnSelected(btnSelectLogin);
        setBtnUnSelected(btnSelectSignUp);
        LayoutSignUp.setVisibility(View.GONE);
        LayoutLogin.setVisibility(View.VISIBLE);
    }

    private void showSignUpLayout() {
        setBtnSelected(btnSelectSignUp);
        setBtnUnSelected(btnSelectLogin);
        LayoutSignUp.setVisibility(View.VISIBLE);
        LayoutLogin.setVisibility(View.GONE);
    }

    public void OnClick(View view) {
        int id = view.getId();
        if (id == btnSelectLogin.getId() || id == btnSelectSignUp.getId()) {
            btnClick_select(view);
        } else if (id == btnLogin.getId()) {
            btnClick_login(view);
        } else if (id == btnSignUp.getId()){
            btnClick_sign_up(view);
        } else {
            btnClick(view);
        }
    }
    public void btnClick(View view) {
        //context: 上下文，当前activity运行的环境
        Toast.makeText(LoginActivity.this, "btn Clicked!", Toast.LENGTH_SHORT).show();
    }

    private void btnClick_login(View view) {
        Toast.makeText(LoginActivity.this, "Login Clicked!", Toast.LENGTH_SHORT).show();
    }

    private void btnClick_sign_up(View view) {
        Toast.makeText(LoginActivity.this, "Sign up Clicked!", Toast.LENGTH_SHORT).show();
    }

    public void btnClick_select(View view) {
        if (isLogin) {
            showSignUpLayout();
            isLogin = false;
        } else {
            showLoginLayout();
            isLogin = true;
        }
    }

}
