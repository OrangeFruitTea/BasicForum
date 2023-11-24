package com.example.basicfourm.ui;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

public class ModuleActivity extends AppCompatActivity {
    private Toolbar header;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //关联布局
        setContentView(R.layout.activity_module);
        header = findViewById(R.id.header_module);
        setSupportActionBar(header);


    }

    //将顶部导航栏右侧的菜单加载
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_newpost, menu);
        return true;
    }
}
