package com.example.esportpedia;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Player> Player;
    public CustomListAdapter(Activity activity, List<Player> Player)
    {
        this.activity = activity;
        this.Player = Player;
    }
    @Override
    public int getCount() {
        return Player.size();
    }
    @Override
    public Object getItem(int location) {
        return Player.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView tempatlahir = (TextView)
                convertView.findViewById(R.id.text_tempatlahir);
        TextView umur = (TextView)
                convertView.findViewById(R.id.text_umur);
        TextView tim = (TextView)
                convertView.findViewById(R.id.text_tim);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Player p = Player.get(position);
        nama.setText("Nama : "+ p.get_nama());
        tempatlahir.setText("Tempat lahir : "+ p.get_tempatlahir());
        umur.setText("Umur : "+ p.get_umur());
        tim.setText("Tim : "+ p.get_tim());
        return convertView;
    }
}