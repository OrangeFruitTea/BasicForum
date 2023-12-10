package com.example.basicfourm.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.basicfourm.R;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewPostActivity extends AppCompatActivity {

    private Toolbar header;
//    private Button btnSendPost;
//    private Button btnReturn;
    private EditText PostInputTitle;
    private EditText PostInputSubTitle;
    private EditText PostInputContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpost);
//        btnReturn = findViewById(R.id.btn_return);
//        btnSendPost= findViewById(R.id.btn_sendPost);
        PostInputContent = findViewById(R.id.newpost_input_content);
        PostInputTitle = findViewById(R.id.newpost_input_title);
        PostInputSubTitle = findViewById(R.id.newpost_input_subTitle);
        header = findViewById(R.id.header_newpost);
        setSupportActionBar(header);


        //设置按钮监听事件
        //对导航栏的返回按钮点击事件进行监听
        header.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                   PostList thePost = LoginActivity.thePostManager.getPostById(2);
                }
                catch (ClassNotFoundException e)
                {
                    Toast.makeText(NewPostActivity.this,"提供的ID不合法", Toast.LENGTH_SHORT).show();
                }
                //PostList thePost = LoginActivity.thePostManager.getPostById(2);
                //Toast.makeText(NewPostActivity.this,thePost.getTitle(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(NewPostActivity.this,LitePal.where("postlist_id=?",String.valueOf(10)).findFirst(ReplyList.class).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
//        btnSendPost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Toast.makeText(NewPostActivity.this, "1", Toast.LENGTH_SHORT).show();
//                if(isPostValid())
//                {
//                    String title = PostInputTitle.getText().toString().trim();
//                    String content = PostInputContent.getText().toString().trim();
//                    String subtitle = PostInputSubTitle.getText().toString().trim();
//                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
//                    Date date = new Date(System.currentTimeMillis());
//
//                    PostList thePost = new PostList(title,subtitle,content,LoginActivity.LoginUser,simpleDateFormat.format(date).toString(),ObjectId);
//                    boolean flag = thePost.save();
//                    if(!flag)
//                    {
//                        Toast.makeText(NewPostActivity.this, "发帖失败", Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//
//                    Toast.makeText(NewPostActivity.this,"发帖成功", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        btnReturn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PostList thePost =LitePal.where("objectID=?",String.valueOf(1)).find(PostList.class).get(1);
//                Toast.makeText(NewPostActivity.this,thePost.getTitle(), Toast.LENGTH_SHORT).show();
//                //Toast.makeText(NewPostActivity.this, "2", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    //将顶部导航栏右侧的菜单加载至activity内部
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_newpost, menu);
        return true;
    }

    //对导航栏的发送帖子按钮点击事件进行重写
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btn_send_post) {
            if(isPostValid())
            {
                String title = PostInputTitle.getText().toString().trim();
                String content = PostInputContent.getText().toString().trim();
                String subtitle = PostInputSubTitle.getText().toString().trim();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());

                PostList thePost = new PostList(title,subtitle,content,LoginActivity.LoginUser,simpleDateFormat.format(date).toString(),LoginActivity.thePostManager.getObjectId());
                ReplyList comment = new ReplyList(content,LoginActivity.LoginUser,simpleDateFormat.format(date).toString(),thePost.getFloorForComment(),title,thePost);
                thePost.getCommentList().add(comment);
                comment.save();
                boolean flag = thePost.save();
                if(!flag)
                {
                    Toast.makeText(NewPostActivity.this, "发帖失败", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(NewPostActivity.this,"发帖成功", Toast.LENGTH_SHORT).show();
                finish();
            }
            LoginActivity.thePostManager.save();
        }
        return super.onOptionsItemSelected(item);
    }



    public boolean isPostValid() {
        String title = PostInputTitle.getText().toString().trim();
        if(title.equals(""))
        {
            Toast.makeText(NewPostActivity.this, "帖子标题不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
