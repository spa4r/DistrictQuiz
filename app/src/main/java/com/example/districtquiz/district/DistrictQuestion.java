package com.example.districtquiz.district;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.districtquiz.R;
import com.example.districtquiz.utils.RequestTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;

public class DistrictQuestion extends Activity {

    private TextView textView;
    private Button bouton ;
    private District district;
    private ProgressDialog pDialog;
    private ArrayList<Question> questions;
    private TextView reponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_adapter_display_one);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.district = (District) bundle.getSerializable("district");

        try {
            this.getQuestion();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setTextView();
        this.setBouton();
        this.setTextViewQuestion();

    }

    public void setTextView() {
        this.textView = findViewById(R.id.textview_display_one_name);
        try {
            this.textView.setText(this.questions.get(this.district.getId()).getQuestion());
        }
        catch (Exception e) {
            Log.e("districtQuestion",e.toString());
        }
    }

    public void getQuestion() throws ExecutionException, InterruptedException {

        this.pDialog = new ProgressDialog(DistrictQuestion.this);
        this.pDialog.setMessage("Nous cherchons la question...");
        this.pDialog.setIndeterminate(false);
        this.pDialog.setCancelable(true);
        this.pDialog.show();
        Gson gson= new Gson();
        Type type= new TypeToken<ArrayList<Question>>(){}.getType();
        this.questions = new ArrayList<Question>();
        this.questions.addAll(gson.fromJson(new RequestTask().execute().get(), type));
        this.pDialog.dismiss();

    }

    public void setBouton() {
        this.bouton = findViewById(R.id.button_question_ok);
        this.bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(reponse.getText().toString().toLowerCase().equals(questions.get(district.getId()).getReponse().toLowerCase())) {
                    Toast toast = Toast.makeText(getApplicationContext(),"Bravo !",Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Malheureusement c'est faux !",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public void setTextViewQuestion() {
        this.reponse = findViewById(R.id.textview_question_district);
    }

}
