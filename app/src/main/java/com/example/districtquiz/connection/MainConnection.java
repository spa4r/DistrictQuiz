package com.example.districtquiz.connection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.districtquiz.R;
import com.example.districtquiz.district.MainDistrict;
import com.example.districtquiz.utils.RequestTask;

import java.io.IOException;
import java.util.Locale;

public class MainConnection extends AppCompatActivity {

    private Button bouton ;
    private TextView password;
    private TextView utilisateur;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        this.setUtilisateur();
        this.setPassword();
        this.setImageView();
        this.setBouton();

    }

    public void setBouton() {
        this.bouton = findViewById(R.id.button_connection);
        this.bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(utilisateur.getText().toString().equals("abcd") && password.getText().toString().equals("EFGH")) {
                    Toast toast = Toast.makeText(getApplicationContext(),"Connection réussi",Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent= new Intent(getApplicationContext(), MainDistrict.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Connection ratée",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public void setUtilisateur() {
        this.utilisateur = findViewById(R.id.textview_connection_utilisateur);
    }

    public void setPassword() {
        this.password = findViewById(R.id.textview_connection_password);
    }

    public void setImageView() {
        this.imageView = findViewById(R.id.imageview_connection_image);
        this.imageView.setImageResource(R.drawable.user);
    }

}