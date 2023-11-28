package com.example.basicfourm.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicfourm.R;

import org.litepal.LitePal;
import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter {
    private List<PostList> postArray;

    public PostAdapter(List<PostList> array) {
        postArray = array;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PostList post = postArray.get(position);
//        postArray = LitePal.findAll(PostList.class);
        if (holder instanceof PostViewHolder) {
            PostViewHolder postViewHolder = (PostViewHolder) holder;
            postViewHolder.PostTitle.setText(post.getTitle());
            postViewHolder.PostSubTitle.setText(post.getSubTitle());
            postViewHolder.PostTime.setText(post.getTime());
            postViewHolder.PostAuthor.setText(post.getPublisher().getUserName());
            postViewHolder.PostInfo.setText(post.getContent());
            postViewHolder.PostCommentCount.setText(String.valueOf(post.getFloor()-1));
        }
    }

    @Override
    public int getItemCount() {
        return postArray.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView PostTitle;
        TextView PostSubTitle;
        TextView PostTime;
        TextView PostAuthor;
        TextView PostInfo;
        TextView PostCommentCount;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            PostTime = itemView.findViewById(R.id.textView_post_time);
            PostSubTitle= itemView.findViewById(R.id.textView_post_sub_title);
            PostTitle = itemView.findViewById(R.id.textView_post_title);
            PostAuthor = itemView.findViewById(R.id.textView_post_username);
            PostInfo = itemView.findViewById(R.id.TextView_post_main_text);
            PostCommentCount = itemView.findViewById(R.id.textView_post_comment_count);
        }
    }
}
