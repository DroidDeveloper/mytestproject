package com.example.test.testproject.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.testproject.R;
import com.example.test.testproject.pojo.MyPojo;

import java.util.ArrayList;

/**
 * Created by Lenovo on 13-04-2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<MyPojo> mDataset;



    public static class DataObjectHolder extends RecyclerView.ViewHolder
            {
        TextView label,age,grade;


        public DataObjectHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.textView);
            age = (TextView) itemView.findViewById(R.id.txt_age);
            grade = (TextView) itemView.findViewById(R.id.txt_grade);


        }


    }



    public MyRecyclerViewAdapter(ArrayList<MyPojo> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }



    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.label.setText(mDataset.get(position).getmName());
        holder.age.setText(mDataset.get(position).getmAge());
        holder.grade.setText(mDataset.get(position).getmGrade());
        Log.e("result",mDataset.toString());

    }

    public void addItem(MyPojo dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        Log.e("result",mDataset.size()+"");
        return mDataset.size();
    }



}
