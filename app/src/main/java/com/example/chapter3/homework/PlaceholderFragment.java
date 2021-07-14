package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private RecyclerView recyclerView;
    private LottieAnimationView animationView;
    private AnimatorSet animatorSet;

    private List<FriendData> friendList = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView = view.findViewById(R.id.anv1);
        recyclerView = view.findViewById(R.id.rv1);
        recyclerView.setAlpha(0f);
        //初始化好友数据
        initFriends();
        //更改数据时不会变更宽高
        recyclerView.setHasFixedSize(true);
        //创建线性布局管理器
        layoutManager = new LinearLayoutManager(getActivity());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //为RecyclerView设置Adapter
        FriendAdapter adapter=new FriendAdapter(friendList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    void initFriends(){
        for(int i =0;i < 20;i ++){
            FriendData a = new FriendData("这是一个名字","你好鸭~·14:30",R.drawable.p01);
            friendList.add(a);
        }
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
                animator1.setDuration(800);
                animator1.setInterpolator(new LinearInterpolator());
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(recyclerView,"alpha",0f,1f);
                animator2.setDuration(800);
                animator2.setInterpolator(new LinearInterpolator());
                animatorSet = new AnimatorSet();
                animatorSet.playSequentially(animator1,animator2);
                animatorSet.setDuration(600);
                animatorSet.start();
            }
        }, 5000);

    }

}
