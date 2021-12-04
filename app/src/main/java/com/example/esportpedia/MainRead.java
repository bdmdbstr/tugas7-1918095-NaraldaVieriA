package com.example.esportpedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Player> ListPlayer = new ArrayList<Player>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPlayer);
        mListView = (ListView) findViewById(R.id.list_player);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPlayer.clear();
        List<Player> player = db.ReadPlayer();
        for (Player ply : player) {
            Player daftar = new Player();
            daftar.set_id(ply.get_id());
            daftar.set_nama(ply.get_nama());
            daftar.set_tempatlahir(ply.get_tempatlahir());
            daftar.set_umur(ply.get_umur());
            daftar.set_tim(ply.get_tim());
            ListPlayer.add(daftar);
            if ((ListPlayer.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Player detailPly = (Player)o;
        String Sid = detailPly.get_id();
        String Snama = detailPly.get_nama();
        String Stempatlahir = detailPly.get_tempatlahir();
        String Sumur = detailPly.get_umur();
        String Stim = detailPly.get_tim();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Itempatlahir", Stempatlahir);
        goUpdel.putExtra("Iumur", Sumur);
        goUpdel.putExtra("Itim", Stim);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPlayer.clear();
        mListView.setAdapter(adapter_off);
        List<Player> player = db.ReadPlayer();
        for (Player ply : player) {
            Player daftar = new Player();
            daftar.set_id(ply.get_id());
            daftar.set_nama(ply.get_nama());
            daftar.set_tempatlahir(ply.get_tempatlahir());
            daftar.set_umur(ply.get_umur());
            daftar.set_tim(ply.get_tim());
            ListPlayer.add(daftar);
            if ((ListPlayer.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
