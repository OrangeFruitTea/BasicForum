package com.example.basicfourm.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicfourm.R;

import org.w3c.dom.Text;

import java.util.List;

public class ReplyAdapter extends RecyclerView.Adapter {
    private List<ReplyList> replyArray;
    public ReplyAdapter(List<ReplyList> array) {
        setData(array);
    }

    public void setData(List<ReplyList> array) {
        replyArray = array;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_comment, parent, false);
        return new ReplyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ReplyList reply = replyArray.get(position);
        if (holder instanceof ReplyViewHolder) {
            ReplyViewHolder replyViewHolder = (ReplyAdapter.ReplyViewHolder) holder;
            if (reply.getTitle().equals("")) {
                replyViewHolder.CommentTitle.setVisibility(View.GONE);
            } else {
                replyViewHolder.CommentTitle.setText(reply.getTitle());
            }
            replyViewHolder.CommentSubTitle.setVisibility(View.GONE);
            replyViewHolder.CommentTime.setText(reply.getTimeInReply());
            replyViewHolder.CommentAuthor.setText(reply.getReplyer().getUserName());
            replyViewHolder.CommentInfo.setText(reply.getReply());
            replyViewHolder.CommentFloor.setText(String.valueOf(reply.getFloor()));

        }

    }

    @Override
    public int getItemCount() {
        return replyArray.size();
    }

    class ReplyViewHolder extends RecyclerView.ViewHolder {
        TextView CommentAuthor;
        TextView CommentTime;
        TextView CommentTitle;
        TextView CommentSubTitle;
        TextView CommentInfo;
        TextView CommentFloor;
        public ReplyViewHolder(@NonNull View itemView) {
            super(itemView);
            CommentAuthor = itemView.findViewById(R.id.textView_comment_username);
            CommentTime = itemView.findViewById(R.id.textView_comment_time);
            CommentTitle= itemView.findViewById(R.id.textView_comment_title);
            CommentSubTitle = itemView.findViewById(R.id.textView_comment_sub_title);
            CommentInfo= itemView.findViewById(R.id.TextView_comment_main_text);
            CommentFloor = itemView.findViewById(R.id.textView_comment_floor);
        }
    }
}
