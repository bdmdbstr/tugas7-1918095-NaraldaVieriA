package com.example.esportpedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_esportpedia";
    private static final String tb_player = "tb_player";
    private static final String tb_player_id = "id";
    private static final String tb_player_nama = "nama";
    private static final String tb_tempatlahir = "tempatlahir";
    private static final String tb_umur_player = "umur";
    private static final String tb_tim_player = "tim";
    private static final String CREATE_TABLE_PROPLAYER = "CREATE TABLE " +
            tb_player +"("
            + tb_player_id + " INTEGER PRIMARY KEY ,"
            + tb_player_nama + " TEXT ,"
            + tb_tempatlahir + " TEXT ,"
            + tb_umur_player + " TEXT ,"
            + tb_tim_player + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PROPLAYER);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreatePlayer(Player data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_player_id, data.get_id());
        values.put(tb_player_nama, data.get_nama());
        values.put(tb_tempatlahir, data.get_tempatlahir());
        values.put(tb_umur_player, data.get_umur());
        values.put(tb_tim_player, data.get_tim());
        db.insert(tb_player, null, values);
        db.close();
    }
    public List<Player> ReadPlayer() {
        List<Player> listPly = new ArrayList<Player>();
        String selectQuery = "SELECT * FROM " + tb_player;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Player data = new Player();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_tempatlahir(cursor.getString(2));
                data.set_umur(cursor.getString(3));
                data.set_tim(cursor.getString(4));
                listPly.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listPly;
    }
    public int UpdatePlayer (Player data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_player_nama, data.get_nama());
        values.put(tb_tempatlahir, data.get_tempatlahir());
        values.put(tb_umur_player, data.get_umur());
        values.put(tb_tim_player, data.get_tim());
        return db.update(tb_player, values, tb_player_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeletePlayer(Player data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_player,tb_player_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
