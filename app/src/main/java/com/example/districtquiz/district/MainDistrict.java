package com.example.districtquiz.district;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.districtquiz.R;
import com.example.districtquiz.district.District;
import com.example.districtquiz.district.DistrictAdapter;
import com.example.districtquiz.district.DistrictQuestion;
import com.example.districtquiz.utils.RequestTask;

import java.io.Serializable;
import java.util.ArrayList;

public class MainDistrict extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<District> districts;
    DistrictAdapter districtAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_adapter);

        this.setDistricts();
        this.setDistrictAdapter();
        this.setGridView();

    }

    private void setDistricts() {

        this.districts = new ArrayList<>();
        this.districts.add(new District(0,"Louvre","Description Louvre",50.0f,50.0f,R.drawable.img_district1));
        this.districts.add(new District(1,"Bourse","Description Bourse",50.0f,50.0f,R.drawable.img_district2));
        this.districts.add(new District(2,"Temple","Description Temple",50.0f,50.0f,R.drawable.img_district3));
        this.districts.add(new District(3,"Hôtel-de-ville","Description Hôtel-de-ville",50.0f,50.0f,R.drawable.img_district4));

    }

    private void setGridView() {

        this.gridView = findViewById(R.id.gridview);
        this.gridView.setAdapter(this.districtAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DistrictQuestion.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("district", districts.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void setDistrictAdapter() {
        this.districtAdapter= new DistrictAdapter(this, districts);
    }

}