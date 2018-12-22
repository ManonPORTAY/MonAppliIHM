package com.example.portay_m.monappliihm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NameItemListener {

    private RecyclerView recyclerView;
    private Button buttonNext;
    public final static String KEY_USERNAME = "USERNAME";
    ListNameAdapter listNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNameAdapter = new ListNameAdapter(this);


       recyclerView = findViewById(R.id.activity_main_recyclerview);
       buttonNext = findViewById(R.id.activity_main_button_next);

       final Context context = this;
       buttonNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context,FormActivity.class);

               startActivity(intent); 
           }
       });

       initList();
    }

    @Override
    protected void onResume(){
        super.onResume();
        List nameList = DataManager.getInstance().getNameList();
        listNameAdapter.updateData(nameList);

    }

    private void initList(){
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listNameAdapter);
    }

    @Override
    public void clickOnItem(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickOnCross(String name) {
        Toast.makeText(this, "clic sur l'étoile de "+name , Toast.LENGTH_SHORT).show();
    }
}
