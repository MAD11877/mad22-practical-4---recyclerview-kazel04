package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.os.Handler;
import android.widget.Button;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ListActivity extends AppCompatActivity {
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        createList();

    }
    public void createList(){
        ArrayList<User> UserList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            User Usersample = new User("Name" + randomnum(), "Description " + randomnum(), i, (Math.random() < 0.5));
            UserList.add(Usersample);
        }
        RecyclerView rv = findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter(UserList/*, this::onNoteClick*/);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        rv.setLayoutManager(layout);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }
    public Integer randomnum(){
        int num = (int) Math.round(Math.random() * 1000000);
        return num;
    }
}

//worked on this practical with RayZin