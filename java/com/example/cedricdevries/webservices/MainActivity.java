package com.example.cedricdevries.webservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button viewDataButton;
    private DBOperations dbOps;
    private Data dataPetition;
    private static final String URL_ID = "ar7h-5u86";
    private List <String> uniqueNameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        dbOps = new DBOperations(MainActivity.this);
        dataPetition = new Data();

        dbOps.open();

        if(dbOps.selectCount() <= 0) {

            dataPetition.get(URL_ID, new IActions() {
                @Override
                public void actionResponseData(List<ArcheologicalElement> data) {
                    for (ArcheologicalElement archElmnt : data) {
                        Log.d("archElmnt", archElmnt.toString());

                        dbOps.addArcheologicalElement(archElmnt);
                    }

                }

                @Override
                public void actionErrorResponse(Throwable t) throws Throwable {
                    throw t;
                }
            });

        }

        viewDataButton = findViewById(R.id.view_data_button);

        viewDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toViewDataActivity = new Intent(MainActivity.this, ViewElementsActivity.class);
                startActivity(toViewDataActivity);
            }
        });


    }

    @Override
    protected void onStop(){
        super.onStop();

        dbOps.close();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        dbOps.close();
    }
}
