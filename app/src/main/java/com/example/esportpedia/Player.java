package com.example.esportpedia;

public class Player {
    private String _id, _nama, _tempatlahir, _umur, _tim;
    public Player (String id, String nama, String tempatlahir, String umur, String tim) {
        this._id = id;
        this._nama = nama;
        this._tempatlahir = tempatlahir;
        this._tim = tim;
        this._umur = umur;
    }
    public Player() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_tempatlahir() {
        return _tempatlahir;
    }
    public void set_tempatlahir(String _tempatlahir) {
        this._tempatlahir = _tempatlahir;
    }
    public String get_umur() {
        return _umur;
    }
    public void set_umur(String _umur) {
        this._umur = _umur;
    }
    public String get_tim() {
        return _tim;
    }
    public void set_tim(String _tim) {
        this._tim = _tim;
    }
}
