package com.example.prac2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Viewholder extends RecyclerView.ViewHolder {

    TextView nameText;
    TextView descText;
    ImageView image;
    ImageView bigimage;

    public int getItemViewType(int position) {return position;}
    public Viewholder(View view){
        super(view);
        nameText = view.findViewById(R.id.textView3);
        descText = view.findViewById(R.id.textView4);
        image = (ImageView) view.findViewById(R.id.imageView2);
        bigimage = (ImageView) view.findViewById(R.id.imageView3);

    }

}
//worked on this practical with RayZin


