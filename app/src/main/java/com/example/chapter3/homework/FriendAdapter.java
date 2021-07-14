package com.example.chapter3.homework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    private List<FriendData> mFriendList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView friendImage;
        TextView friendName;
        TextView Message;

        public ViewHolder(@NonNull View view) {
            super(view);
            friendImage=(ImageView)view.findViewById(R.id.iv_portrait);
            friendName=(TextView)view.findViewById(R.id.tv_name);
            Message = (TextView)view.findViewById(R.id.tv_message);
        }
    }

    public FriendAdapter(List<FriendData> friendList){
        mFriendList = friendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FriendData friend = mFriendList.get(position);
        holder.friendImage.setImageResource(friend.getPortraitID());
        holder.friendName.setText(friend.getName());
        holder.Message.setText(friend.getMessage());
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

}
