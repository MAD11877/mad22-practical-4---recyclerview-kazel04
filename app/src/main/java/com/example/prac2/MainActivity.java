package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textview changes (if some part of the layout is not there, must force refresh the layout!)
        TextView tv1 = (TextView)findViewById(R.id.textView5);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("key");
            tv1.setText(value);
        }

        Button button = (Button) findViewById(R.id.button3);
        String buttonText = (String) button.getText();
        System.out.println(buttonText);
        User user1 = new User("Satsuma","template",1,true );

        if(user1.followed = true){
            button.setText("Unfollow");
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    button.setText("Follow");
                    Toast.makeText(getBaseContext(), "Unfollowed" , Toast.LENGTH_SHORT ).show();
                    user1.followed = false;
                }
            });
        }
        else{
            button.setText("Follow");
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    button.setText("Unfollow");
                    Toast.makeText(getBaseContext(), "Followed" , Toast.LENGTH_SHORT ).show();
                    user1.followed = true;
                }
            });
        }

    }
// abc

}