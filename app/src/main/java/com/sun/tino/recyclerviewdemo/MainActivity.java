package com.sun.tino.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doRecyclerView();
    }

    private void doRecyclerView(){
        final RecyclerView mRecyclerView = findViewById(R.id.recycler_mail);
        mRecyclerView.setHasFixedSize(false);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(mDividerItemDecoration);
        final ArrayList<EmailData> mEmailData = new ArrayList<>();
        mEmailData.add(new EmailData("Trần Văn Tý", "Thư tuyển dụng vào công ty phần mềm di động", "15m",true));
        mEmailData.add(new EmailData("Trần Văn Tèo", "Đây là nội dung tin nhắn khẩn cấp", "15m"));
        mEmailData.add(new EmailData("Lê Thị Ổi", "Thư tuyển dụng vào công ty phần mềm di động", "15m"));
        mEmailData.add(new EmailData("Đào Thị Mận", "Thư tuyển dụng vào công ty phần mềm di động", "15m"));
        Adapter adapter = new Adapter(mEmailData, this);
        mRecyclerView.setAdapter(adapter);
        //Set default animation for recycler view
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
