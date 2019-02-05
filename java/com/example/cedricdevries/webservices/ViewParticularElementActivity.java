package com.example.cedricdevries.webservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ViewParticularElementActivity extends AppCompatActivity {

    private DBOperations dbOps;
    private TextView elementInfoView;
    private long elementID;
    private ArcheologicalElement element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_particular_element);

        elementInfoView = findViewById(R.id.info);

        elementID = getIntent().getLongExtra("elementID",0);

        dbOps = new DBOperations(this);
        dbOps.open();
        element = dbOps.getArcheologicalElement(elementID);
        dbOps.close();

        elementInfoView.setText(element.toString());

    }
}
