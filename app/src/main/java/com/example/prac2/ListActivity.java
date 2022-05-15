package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.jar.Attributes;


public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutManager;

    AlertDialog.Builder builder;
    ArrayList<User> Userlist = new ArrayList<>();
    public void CreateList (ArrayList<User> Userlist)
    {
        int nums = 20;
        Random rand = new Random(); //instance of random class
        int upperbound = 10000000;

        // for each loop, create a new user and add to list
        for (int i = 0; i < nums; i++)
        {
            //generate random values from 0-24
            int int_random = rand.nextInt(upperbound);
            String descrips = Integer.toString(int_random);

            User usernew = new User("Name"+int_random,""+descrips,i,true );
            Userlist.add(usernew);

        }

    }

    //Creating name list
    ArrayList<String> Namelist = new ArrayList<>();
    public void CreateNameList (ArrayList<String> namelist, ArrayList<User> Userlist)
    {
        int nums = 20;

        // for each loop, create a new user and add to list
        for (int i = 0; i < nums; i++)
        {

            namelist.add(Userlist.get(i).name);
        }

    }

    //Creating description list
    ArrayList<String> Descriplist = new ArrayList<>();
    public void CreateDescripList (ArrayList<String> descriplist, ArrayList<User> Userlist)
    {
        int nums = 20;

        // for each loop, create a new user and add to list
        for (int i = 0; i < nums; i++)
        {

            descriplist.add(Userlist.get(i).description);
        }

    }




    public class BrandViewHolder extends RecyclerView.ViewHolder {
        TextView txt;
        public BrandViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(android.R.id.text1);
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.rvProgram);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Actually creating the lists
        CreateList(Userlist);
        CreateNameList(Namelist,Userlist);
        CreateDescripList(Descriplist,Userlist);

        //converting to string array
        String Names[] = Namelist.toArray(new String[Namelist.size()]);
        String Descrips[] = Descriplist.toArray(new String[Descriplist.size()]);

        int[] images= {R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};




        //setting the lists here
        programAdapter = new ProgramAdapter(this,Names,Descrips,images);
        recyclerView.setAdapter(programAdapter);

        RecyclerView rlayout = findViewById(R.id.rvProgram);

        rlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                //Setting message manually and performing action on button click
                builder.setMessage("MADness")
                        .setCancelable(false)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Insert random integer generation + transfer to main activity here!
                                int randomNum = ThreadLocalRandom.current().nextInt(0, 100000 + 1);
                                String value= String.valueOf(randomNum);
                                Intent i = new Intent(ListActivity.this, MainActivity.class);
                                i.putExtra("key",value);
                                startActivity(i); //code changes activity to mainactivity!

                                Toast.makeText(getApplicationContext(), value,
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Toast.makeText(getApplicationContext(), "you choose no action for alertbox",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();


            }
        });







    }
}