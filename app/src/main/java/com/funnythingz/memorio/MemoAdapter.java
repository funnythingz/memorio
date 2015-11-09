package com.funnythingz.memorio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.funnythingz.memorio.Domain.Memo;

import java.util.ArrayList;

/**
 * Created by funnythingz on 15/11/10.
 */
public class MemoAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Memo> mMemoList;

    public MemoAdapter(HomeActivity homeActivity, ArrayList<Memo> memoList) {
        mContext = homeActivity;
        mLayoutInflater = LayoutInflater.from(mContext);
        mMemoList = memoList;
    }

    @Override
    public int getCount() {
        return mMemoList.size();
    }

    @Override
    public Memo getItem(int position) {
        return mMemoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView;
    }
}
