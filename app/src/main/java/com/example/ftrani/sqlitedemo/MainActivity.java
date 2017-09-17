package com.example.ftrani.sqlitedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAgregar;
    private Button btnBorrar;

    private ContactoSQLiteHelper contactoSQLiteHelper;
    private SQLiteDatabase db;

    private ListView listView;
    private ContactoAdapter adapter;

    private ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        contactos = new ArrayList<Contacto>();

        btnAgregar = (Button)findViewById(R.id.btnAgregar);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create();
                update();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAll();
                update();
            }
        });

        //abrimos db en modo escritura
        contactoSQLiteHelper = new ContactoSQLiteHelper(this, "DBtest1", null, 1);
        db = contactoSQLiteHelper.getWritableDatabase();

        //definimos adaptador del listview
        adapter = new ContactoAdapter(contactos);
        listView.setAdapter(adapter);

        update();

    }

    private List<Contacto> getAllContactos(){
        //seleccionamos todos los registros
        Cursor cursor = db.rawQuery("SELECT * FROM contactos",null);
        List<Contacto> lista = new ArrayList<>();

        if(cursor.moveToFirst()){
            //iteramos todos los registros del cursor
            //llenamos el array con registros
            while (cursor.isAfterLast()==false){
                //recorremos hasta llegar al ultimo registro
                int telefono = cursor.getInt(cursor.getColumnIndex("telefono"));
                String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String domicilio = cursor.getString(cursor.getColumnIndex("domicilio"));

                lista.add(new Contacto(telefono,nombre,email,domicilio));
                cursor.moveToNext();
            }
        }
        return lista;
    }

    private void create(){
        //verificamos si abrio la BD
        if(db!=null){
            //creamos el registro e insertamos con ContentValues
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("telefono",445566);
            nuevoRegistro.put("nombre","Luis Andres Fernandez");
            nuevoRegistro.put("email","lafernandez88@gmail.com");
            nuevoRegistro.put("domicilio","Avenida Las Heras 334");

            //insertamos registro
            db.insert("contactos", null, nuevoRegistro);
        }
    }

    private void removeAll(){
        db.delete("contactos","",null);
    }

    private void update(){
        //borramos todos los elementos
        contactos.clear();
        //cargamos todos los registros
        contactos.addAll(getAllContactos());
        //notificamos al adaptador
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}
