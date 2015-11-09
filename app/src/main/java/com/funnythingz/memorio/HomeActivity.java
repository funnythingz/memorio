package com.funnythingz.memorio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.funnythingz.memorio.Domain.Memo;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setToolbar();
        floatingActionButton();

        GridView memoListView = (GridView)findViewById(R.id.memoListView);
        ArrayList<Memo> memoList = new ArrayList<Memo>();
        memoList.add(new Memo("めも"));
        memoListView.setAdapter(new MemoAdapter(this, memoList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void startCreateMemoActivity() {
        Intent intent = new Intent(this, CreateMemoActivity.class);
        startActivity(intent);
    }

    private void setToolbar() {
        final int color = getIntent().getExtras().getInt("color");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(color);
        setSupportActionBar(toolbar);
    }

    private void floatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCreateMemoActivity();
            }
        });
    }
}
