package com.example.prac2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;
    String[] programNameList;
    String[] programDescriptionList;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.textView1);
            rowDescription = itemView.findViewById(R.id.textView2);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }

    public ProgramAdapter(Context context, String[] programNameList, String[] programDescriptionList, int[] images){ //removed images id
        this.context = context;
        this.programNameList = programNameList;
        this.programDescriptionList = programDescriptionList;
        this.images = images;

    }

    @NonNull
    @Override
    public ProgramAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem,parent, false);
        // can use  if else here aft getItemViewtype shows binary
        ViewHolder viewHolder = new ViewHolder(view);
        // will be attached to row fr listener
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        // can also return binary val to oncreate
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter.ViewHolder holder, int position) {
        holder.rowName.setText(programNameList[position]);
        holder.rowDescription.setText(programDescriptionList[position]);
        //can have access to data in the list (enter event)
        // can also use onbind to update the view's data (onbind allows access to data)
        // just add another imageview on the same view id

    }

    @Override
    public int getItemCount() {
        return programNameList.length;
    }
}


