package com.example.cedricdevries.webservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class UserFilterActivity extends AppCompatActivity {

    private Spinner typeSelectionSpinner;
    private Spinner parkSelectionSpinner;
    private Filter userFilter;
    private Button applyFilterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_filter);

        typeSelectionSpinner = findViewById(R.id.element_type_selection);
        parkSelectionSpinner = findViewById(R.id.park_selection);
        applyFilterButton = findViewById(R.id.apply_filter_button);

        userFilter = new Filter();

        ArrayAdapter<CharSequence> adapter_type = ArrayAdapter.createFromResource(this, R.array.filter_type_array, android.R.layout.simple_spinner_item);
        adapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSelectionSpinner.setAdapter(adapter_type);

        typeSelectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString().equals("Laja")){
                    userFilter.setType("laja");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Escultura")){
                    userFilter.setType("escultura");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Sarcófago")){
                    userFilter.setType("Sarcófago");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Columna")){
                    userFilter.setType("columna");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Estela")){
                    userFilter.setType("estela");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Tapa de Sarcófago")){
                    userFilter.setType("Tapa de sarcófago");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Fragmentos")){
                    userFilter.setType("fragmento de pies de escultura");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Todos tipos")){
                    userFilter.setType("All types");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapter_park = ArrayAdapter.createFromResource(this, R.array.filter_park_array, android.R.layout.simple_spinner_item);
        adapter_park.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        parkSelectionSpinner.setAdapter(adapter_park);

        parkSelectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString().equals("San Agustín")){
                    userFilter.setPark("San Agustín");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Cerro de la Pelota")){
                    userFilter.setPark("Cerro de La Pelota");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Alto de los Idolos")){
                    userFilter.setPark("Alto de los Idolos");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Alto de Purutal")){
                    userFilter.setPark("Alto de Purutal");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Alto las Piedras")){
                    userFilter.setPark("Alto de las Piedras");
                }
                else if(parent.getItemAtPosition(position).toString().equals("Todos parques")){
                    userFilter.setPark("All parks");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        applyFilterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toViewElementsActivity = new Intent(UserFilterActivity.this, ViewElementsActivity.class);

                if(userFilter != null){
                    toViewElementsActivity.putExtra("filter", userFilter);
                }
                startActivity(toViewElementsActivity);
            }
        });

    }

}
