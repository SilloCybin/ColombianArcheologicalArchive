package com.example.cedricdevries.webservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ViewElementsActivity extends AppCompatActivity {

    private Filter userFilter;
    private List<ShortArcheologicalElement> elementList = new ArrayList<>();
    private ListView elementListView;
    private DBOperations dbOps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_data);

        elementListView = findViewById(R.id.element_list);

        dbOps = new DBOperations(this);
        dbOps.open();

        if(!getIntent().hasExtra("filter")) {

            elementList = dbOps.getAllArcheologicalElementsShort();

            ArrayAdapter<ShortArcheologicalElement> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elementList);
            elementListView.setAdapter(adapter);

            elementListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    ShortArcheologicalElement selectedItem = (ShortArcheologicalElement) parent.getItemAtPosition(position);

                    long elementID = selectedItem.getID();

                    Intent toViewParticularElement = new Intent(ViewElementsActivity.this, ViewParticularElementActivity.class);
                    toViewParticularElement.putExtra("elementID", elementID);
                    startActivity(toViewParticularElement);
                }
            });
        } else {

            Log.d("hello", "went here");

            userFilter = (Filter) getIntent().getSerializableExtra("filter");

            if(userFilter.getPark().equals("All parks") && userFilter.getType().equals("All types")){
                elementList = dbOps.getAllArcheologicalElementsShort();
                Log.d("hello1", "went here");
            }
            else if(userFilter.getPark().equals("All parks")){
                elementList = dbOps.getArcheologicalElementsByType(userFilter.getType());
                Log.d("hello2", "went here");
            }
            else if(userFilter.getType().equals("All types")){
                elementList = dbOps.getArcheologicalElementsByPark(userFilter.getPark());
                Log.d("hello3", "went here");
            }
            else {
                elementList = dbOps.getArcheologicalElementsByTypeAndPark(userFilter.getType(), userFilter.getPark());
                Log.d("hello4", "went here");
            }

            ArrayAdapter<ShortArcheologicalElement> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, elementList);
            elementListView.setAdapter(adapter);

            elementListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    ShortArcheologicalElement selectedItem = (ShortArcheologicalElement) parent.getItemAtPosition(position);

                    long elementID = selectedItem.getID();

                    Intent toViewParticularElement = new Intent(ViewElementsActivity.this, ViewParticularElementActivity.class);
                    toViewParticularElement.putExtra("elementID", elementID);
                    startActivity(toViewParticularElement);
                }
            });

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.apply_filter) {
            Intent toUserFilterActivity = new Intent(ViewElementsActivity.this, UserFilterActivity.class);
            startActivity(toUserFilterActivity);
            return true;
        }
        return false;
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
