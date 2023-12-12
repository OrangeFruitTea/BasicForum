package com.example.basicfourm.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.basicfourm.R;
import com.google.android.material.navigation.NavigationView;

import org.litepal.LitePal;

import java.util.List;

public class PostDetailActivity extends AppCompatActivity  {
    private static final String TAG = "PostDetailActivity";
    private Toolbar toolbar;
    private int postId;
    private ReplyAdapter adapter;
    //获得的本帖子界面的数据信息selfInfo
    private PostList selfInfo;
    //该帖子下的所有评论
    private List<ReplyList> allReply;

    //布局控件相关
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView layoutAllComment;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关联布局
        setContentView(R.layout.layout_post_detail);

        toolbar = (Toolbar) findViewById(R.id.header_post_detail);
        setSupportActionBar(toolbar);

        //点击跳转时将对应帖子信息赋值到此布局
        Intent intent = getIntent();
        postId = intent.getIntExtra("postId", -1);
        selfInfo = LitePal.find(PostList.class, postId);

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

        layoutAllComment = findViewById(R.id.view_all_comment);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        allReply = LoginActivity.thePostManager.getAllCommentForCertainPostWithObject(selfInfo);
        adapter = new ReplyAdapter(allReply);
        if (layoutAllComment != null) {
            layoutAllComment.setAdapter(adapter);
            layoutAllComment.setLayoutManager(layoutManager);
        }
    }

    //帖子内的数据更新
    private void refreshData() {
        if (adapter != null) {
            //获取对应所有评论的数据源
            allReply = LoginActivity.thePostManager.getAllCommentForCertainPostWithObject(selfInfo);
            adapter.setData(allReply);
        }
        adapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_post_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_detail_new_comment) {
            openActivityNewPost();
        }
        return true;
    }

    private void openActivityNewPost() {
        Intent intent = new Intent(this, NewPostActivity.class);
        intent.putExtra("Type", false);
        intent.putExtra("currentPostId", selfInfo.getObjectID());
        startActivity(intent);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

}
