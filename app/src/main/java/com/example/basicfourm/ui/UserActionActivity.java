package com.example.basicfourm.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.basicfourm.R;

public class UserActionActivity extends AppCompatActivity {
    //此时用户选中的行动
    //1.History 2.PastComments 3.Favorites
    private int selectType = 0;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_user_action);

        Intent intent = getIntent();
        selectType = intent.getIntExtra("currentType", 0);
        super.onCreate(savedInstanceState);


        //设置刷新操作和回调函数
        refreshLayout = findViewById(R.id.layout_comment_refresh);
        //设置下拉刷新图标颜色
        refreshLayout.setColorSchemeColors(Color.parseColor("#2E9DFD"));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
    }

    private void refreshData() {
        if (adapter != null) {
            //获取对应所有评论的数据源
            updateAdapterData(selectType);
        }
        adapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    private void initAdapter(int selectType) {
        switch (selectType) {
            case 1: //History
                //还没写
                //adapter = new PostAdapter(LoginActivity.LoginUser.getHistory());
                break;
            case 2: //PastComments
                //本来应该是get特定用户的所有历史评论
                adapter = new ReplyAdapter(LoginActivity.thePostManager.getAllComment());
                break;
            case 3: //favorites
                break;
            default:
                break;
        }
    }

    private void updateAdapterData(int selectType) {
        switch (selectType) {
            case 1: //History
                break;
            case 2: //PastComments
                break;
            case 3: //favorites
                break;
            default:
                break;
        }
    }
}
