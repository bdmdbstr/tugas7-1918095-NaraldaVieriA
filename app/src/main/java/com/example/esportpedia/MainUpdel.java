package com.example.esportpedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Stempatlahir, Sumur, Stim;
    private EditText Enama, Etempatlahir, Eumur, Etim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Stempatlahir = i.getStringExtra("Itempatlahir");
        Sumur = i.getStringExtra("Iumur");
        Stim = i.getStringExtra("Itim");
        Enama = (EditText) findViewById(R.id.updel_namaplayer);
        Etempatlahir = (EditText) findViewById(R.id.updel_tempatlahir);
        Eumur = (EditText) findViewById(R.id.updel_umur);
        Etim = (EditText) findViewById(R.id.updel_tim);
        Enama.setText(Snama);
        Etempatlahir.setText(Stempatlahir);
        Eumur.setText(Sumur);
        Etim.setText(Stim);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Stempatlahir = String.valueOf(Etempatlahir.getText());
                Sumur = String.valueOf(Eumur.getText());
                Stim = String.valueOf(Etim.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stempatlahir.equals("")){
                    Etempatlahir.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi data tempat lahir",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sumur.equals("")){
                    Eumur.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi umur anda",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stim.equals("")){
                    Etim.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi data tim",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdatePlayer(new Player(Sid, Snama, Stempatlahir, Sumur, Stim));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePlayer(new Player(Sid, Snama, Stempatlahir, Sumur, Stim));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
