package com.example.basicfourm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText SignInputUserName;
    private EditText SignInputUserPassword;

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
        //起始显示登录界面
        showLoginLayout();
    }

    //视效；将参数对应的按钮设置为可点击，且文本内容高亮
    private void setBtnSelected(Button btn) {
        btn.setClickable(false);
        btn.setTextColor(getColor(R.color.app_btnText_selected));
    }

    //视效；将参数对应的按钮设置为不可点击，且文本内容灰暗
    private void setBtnUnSelected(Button btn) {
        btn.setClickable(true);
        btn.setTextColor(getColor(R.color.app_btnText_notSelected));
    }

    //通过改变Visibility实现Login Layout与SignUp Layout的切换
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

    //基本按钮OnClick函数，通过id分支调用真正实现效果的函数
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

    //debug用，检测按钮是否能被Click到
    public void btnClick(View view) {
        Toast.makeText(LoginActivity.this, "btn Clicked!", Toast.LENGTH_SHORT).show();
    }

    //登录按钮点击事件
    private void btnClick_login(View view) {
        Toast.makeText(LoginActivity.this, "Login Clicked!", Toast.LENGTH_SHORT).show();
    }

    //注册按钮点击事件
    private void btnClick_sign_up(View view) {

        String UserName;
        String UserPassword;

        Toast.makeText(LoginActivity.this, "Sign up Clicked!", Toast.LENGTH_SHORT).show();

        SignInputUserName=findViewById(R.id.sign_input_username);
        SignInputUserPassword=findViewById(R.id.sign_input_password);

        UserName=SignInputUserName.getText().toString().trim();
        UserPassword=SignInputUserPassword.getText().toString().trim();
    }

    //通过按钮切换两个Layout
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
