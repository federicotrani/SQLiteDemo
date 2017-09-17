package com.example.ftrani.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactoSQLiteHelper extends SQLiteOpenHelper {

    //consulta para crear la tabla contacto
    String sqlCrear = "CREATE TABLE contactos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, telefono INT, nombre TEXT, email TEXT, domicilio TEXT)";

    public ContactoSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCrear);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //se elimina version anterior de tabla
        db.execSQL("DROP TABLE IF EXISTS contactos");
        //se crea nueva version de tabla
        db.execSQL(sqlCrear);
    }
}
