package com.example.portay_m.monappliihm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName;
    private Button buttonNext;
    public final static String KEY_USERNAME = "USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textViewName = findViewById(R.id.activity_main_textview_name);

       buttonNext = findViewById(R.id.activity_main_button_next);

       final Context context = this;
       buttonNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context,FormActivity.class);

               startActivityForResult(intent,1); //ne pas mettre 1 codé en dur comme ça
           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1)
        {
            if(resultCode==RESULT_OK && data.getExtras()!= null)
            {
                Log.d("","");
                String name = data.getStringExtra(KEY_USERNAME);
                textViewName.setText(name);
            } else
            {
                //handle errors
            }
        }
    }
}
