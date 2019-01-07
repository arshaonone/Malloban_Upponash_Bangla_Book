package com.mallobanupponash;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder>{

    private Context mContext;
    private ArrayList<String> titleTextView;

    private MyCustomItemClickListener listener;

    public TitleAdapter(Context mContext, ArrayList<String> titleTextView, MyCustomItemClickListener listener) {
        this.mContext = mContext;
        this.titleTextView = titleTextView;
        this.listener = listener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_title,parent,false);

        final MyViewHolder VH = new MyViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onItemClick(view,VH.getPosition());
            }
        });


        return VH;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.titleText.setText(titleTextView.get(position).replace("_"," "));






    }

    @Override
    public int getItemCount() {
        return titleTextView.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleText;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titleText = (TextView) itemView.findViewById(R.id.title_layout_txt);

        }
    }
}