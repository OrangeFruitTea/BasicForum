package com.example.basicfourm.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.basicfourm.R;

import org.litepal.LitePal;

public class ModuleActivity extends AppCompatActivity {
    private Toolbar header;
//    private DrawerLayout drawer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //关联布局
        setContentView(R.layout.activity_module);
//        drawer = findViewById(R.id.layout_drawer);
        header = findViewById(R.id.header_module);
        setSupportActionBar(header);


        header.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDrawer();
            }
        });
    }

    private void showDrawer() {
//        if (!drawer.isDrawerOpen(Gravity.LEFT)) {
//            drawer.openDrawer(Gravity.LEFT);
//        } else {
//            drawer.closeDrawer(Gravity.LEFT);
//        }
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
    }

    //将顶部导航栏右侧的菜单加载
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_newpost, menu);
        return true;
    }
}
