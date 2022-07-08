package com.example.prac2;

import static android.util.Log.d;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Viewholder>{
    ArrayList<User> data;
    //private OnNoteListener monNoteListener;
    public Adapter(ArrayList<User> data){
        this.data = data;
    }
    @Override
    public int getItemViewType(int position) {
        //int pos = g
        return position;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View c = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems,null,false);
        return new Viewholder(c);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        User name = data.get(position);
        String n = name.name;
        holder.nameText.setText(n);
        User users = data.get(position);
        String d = users.description;

        holder.descText.setText(d);
        User follow = data.get(position);
        Boolean f = follow.followed;
        if(!n.substring(n.length() - 1).equals("7")){
            d("name", n);
            holder.bigimage.setVisibility(View.GONE);
        }
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Profile");
                builder.setMessage(n);
                builder.setCancelable(true);
                builder.setPositiveButton(
                        "VIEW", new
                                DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int id){
                                        Intent activityName = new Intent(view.getContext(),MainActivity.class);
                                        activityName.putExtra("name", n);
                                        activityName.putExtra("des", d);
                                        activityName.putExtra("follow", f);
                                        view.getContext().startActivity(activityName);

                                    }
                                });
                builder.setNegativeButton("CLOSE", new
                        DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                dialog.cancel();

                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
//worked on this practical with RayZin




