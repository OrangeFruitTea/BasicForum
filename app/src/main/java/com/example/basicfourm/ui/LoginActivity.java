package com.example.basicfourm.ui;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Button btnSelectLogin;
    private Button btnSelectSignUp;
    private Button btnLogin;
    private Button btnSignUp;
    private LinearLayout LayoutLogin;
    private LinearLayout LayoutSignUp;
    private EditText SignInputUserName;
    private EditText SignInputUserPassword;
    private EditText LoginInputUserName;
    private EditText LoginInputUserPassword;
    private boolean isLogin;
    public static Users LoginUser=new Users("test","",0);
    public static PostManager thePostManager = LitePal.findFirst(PostManager.class);
    //public static PostManager thePostManager = new PostManager(1); 第一次使用先创建一个

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
        SignInputUserName=findViewById(R.id.sign_input_username);
        SignInputUserPassword=findViewById(R.id.sign_input_password);
        LoginInputUserName=findViewById(R.id.login_input_username);
        LoginInputUserPassword=findViewById(R.id.login_input_password);
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
        //Toast.makeText(LoginActivity.this, "Login Clicked!", Toast.LENGTH_SHORT).show();
        if(isLoginUserNameAndPwdValid())
        {
            String UserName=LoginInputUserName.getText().toString().trim();
            String UserPwd=LoginInputUserPassword.getText().toString().trim();
            List<Users> list= LitePal.where(" userName = ? and userPwd = ?",UserName,UserPwd).find(Users.class);
            if(list.size()>0)
            {
                LoginUser = list.get(0);
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                backToView();
            }
            else
            {
                Toast.makeText(LoginActivity.this, "登录失败,用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean isLoginUserNameAndPwdValid() {
        String userName= LoginInputUserName.getText().toString().trim();    //获取当前输入的用户名和密码信息
        String userPwd= LoginInputUserPassword.getText().toString().trim();
        if (userName.equals("")) { //用户名为空
            Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (userPwd.equals("")) {
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void btnClick_sign_up(View view) {
        //Toast.makeText(LoginActivity.this, "Sign up Clicked!", Toast.LENGTH_SHORT).show();
        if(isSignUserNameAndPwdValid())
        {
            String UserName;
            String UserPwd;
            long id=System.currentTimeMillis();

            UserName=SignInputUserName.getText().toString().trim();
            UserPwd=SignInputUserPassword.getText().toString().trim();

            boolean isExist =LitePal.isExist(Users.class, "userName = ?", UserName);
            if(isExist)
            {
                Toast.makeText(LoginActivity.this, "注册失败，用户名已被占用", Toast.LENGTH_SHORT).show();
                return;
            }
            Users user = new Users(UserName,UserPwd,id);
            boolean flag = user.save();
            if(flag)
            {
                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                showLoginLayout();
            }
            else
            {
                Toast.makeText(LoginActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean isSignUserNameAndPwdValid() {
        String userName= SignInputUserName.getText().toString().trim();    //获取当前输入的用户名和密码信息
        String userPwd= SignInputUserPassword.getText().toString().trim();
        if (userName.equals("")) { //用户名为空
            Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (userPwd.equals("")) {
            Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
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

    private void backToView() {
// 创建启动目标 Activity 的 Intent
        Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}
