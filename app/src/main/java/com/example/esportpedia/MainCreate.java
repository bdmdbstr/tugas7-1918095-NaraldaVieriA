package com.example.esportpedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Etempatlahir, Eumur, Etim;
    private String Snama, Stempatlahir, Sumur, Stim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_namaplayer);
        Etempatlahir = (EditText) findViewById(R.id.create_tempatlahir);
        Eumur = (EditText) findViewById(R.id.create_umur);
        Etim = (EditText) findViewById(R.id.create_tim);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Stempatlahir = String.valueOf(Etempatlahir.getText());
                Sumur = String.valueOf(Eumur.getText());
                Stim = String.valueOf(Etim.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stempatlahir.equals("")) {
                    Etempatlahir.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi data tempat lahir",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sumur.equals("")) {
                    Eumur.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi umur anda",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stim.equals("")) {
                    Etim.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi data tim",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Etempatlahir.setText("");
                    Eumur.setText("");
                    Etim.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePlayer(new Player(null, Snama, Stempatlahir, Sumur, Stim));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}