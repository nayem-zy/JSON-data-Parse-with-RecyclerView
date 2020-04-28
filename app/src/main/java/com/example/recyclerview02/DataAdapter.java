package com.example.recyclerview02;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    ArrayList<DataModel> myData;
    Context c;

    public DataAdapter(){

        myData = new ArrayList<>();
    }


    public void setData(ArrayList<DataModel> myData){
        this.myData = myData;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        this.c = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View dataView = inflater.inflate(R.layout.recycler_row, parent, false);
        return new DataViewHolder(dataView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, final int position) {

        DataModel dataModel = myData.get(position);
        holder.name.setText(dataModel.name);
        holder.id.setText(dataModel.id);
        holder.status.setText(dataModel.status);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                String gName = myData.get(position).getName();
                String gId = myData.get(position).getId();
                String gStatus = myData.get(position).getStatus();

                Intent intent = new Intent(c, SingleItemView.class);
                intent.putExtra("iName",gName);
                intent.putExtra("iId",gId);
                intent.putExtra("iStatus",gStatus);

                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return myData.size();
    }

}