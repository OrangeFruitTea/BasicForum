package com.example.basicfourm.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicfourm.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "DrawerActivity";
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView layoutAllPost;
    private PostAdapter adapter;
    private List<PostList> allPost;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    private TextView ShowUserName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关联布局
        setContentView(R.layout.layout_drawer);

        drawerLayout = findViewById(R.id.layout_drawer);
        toolbar = (Toolbar) findViewById(R.id.header_module);
        setSupportActionBar(toolbar);

        //将帖子信息从数据库中添加至界面
        layoutAllPost = findViewById(R.id.view_all_post);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new PostAdapter(allPost);

        //操作栏抽屉切换
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //使用ActionBarDrawerToggle 都是DrawerLayout用来控制ToolBar的显示
        drawerLayout.addDrawerListener(toggle);

        //同步状态
        toggle.syncState();

        navigationView = findViewById(R.id.drawer_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View TheNavi = navigationView.getHeaderView(0);

        ShowUserName = (TextView) TheNavi.findViewById(R.id.textView_drawer_username);
        if(ShowUserName==null)
        {
            Toast.makeText(DrawerActivity.this, "空指针错误!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            ShowUserName.setText(LoginActivity.LoginUser.getUserName());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_module, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_newpost_send) {
            openActivityNewPost();
        }
        return true;
    }

    private void openActivityNewPost() {
        Intent intent = new Intent(this, NewPostActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Class fragmentClass = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (item.getItemId() == R.id.FirstAge) {
            //处理一级菜单的点击事件
            FirstAge();
        } else if (item.getItemId() == R.id.Module1) {
            //点击二级菜单栏时，关闭侧边栏，跳转到对应功能页面
            drawerLayout.closeDrawers();
        } else if (item.getItemId() == R.id.Module2) {

        } else if (item.getItemId() == R.id.Module3) {

        } else if (item.getItemId() == R.id.SecondAge) {
            SecondAge();

        } else if (item.getItemId() == R.id.Module4) {

        } else if (item.getItemId() == R.id.Module5) {

        } else if (item.getItemId() == R.id.Module6) {

        }
//        try {
//            //newInstance()是Java中的方法，用于动态创建类的新实例
//            Fragment fragment = (Fragment) fragmentClass.newInstance();
//            //beginTransaction方法是SQLite数据库中用于开启事务的方法
//            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
//            //setChecked() 在 APP 应用里被用来设置指定 id 唯一标识的 checkbox 多选框 或 radioButton 单选按钮 选中状态
//            item.setChecked(true);
//            //setTitle(title);
//            //Log.e(TAG, title);
//            drawerLayout.closeDrawers();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void FirstAge() {
        Menu menu = navigationView.getMenu();

        MenuItem subMenu1 = menu.findItem(R.id.Module1);
        MenuItem subMenu2 = menu.findItem(R.id.Module2);
        MenuItem subMenu3 = menu.findItem(R.id.Module3);

        if (subMenu1.isVisible()) {
            subMenu1.setVisible(false);
            subMenu2.setVisible(false);
            subMenu3.setVisible(false);
        } else {
            subMenu1.setVisible(true);
            subMenu2.setVisible(true);
            subMenu3.setVisible(true);
        }
    }

    private void SecondAge() {
        Menu menu = navigationView.getMenu();
        MenuItem subMenu1 = menu.findItem(R.id.Module4);
        MenuItem subMenu2 = menu.findItem(R.id.Module5);
        MenuItem subMenu3 = menu.findItem(R.id.Module6);

        if (subMenu1.isVisible()) {
            subMenu1.setVisible(false);
            subMenu2.setVisible(false);
            subMenu3.setVisible(false);
        } else {
            subMenu1.setVisible(true);
            subMenu2.setVisible(true);
            subMenu3.setVisible(true);
        }
    }

}