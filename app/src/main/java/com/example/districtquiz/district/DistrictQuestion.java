package com.example.districtquiz.district;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.districtquiz.R;

public class DistrictQuestion extends Activity {

    private TextView textView;
    private District district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_adapter_display_one);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.district = (District) bundle.getSerializable("district");

        this.setTextView();

    }

    public void setTextView() {
        this.textView = findViewById(R.id.textview_display_one_name);
        this.textView.setText(this.district.getName());
    }

}
