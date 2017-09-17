package com.example.ftrani.sqlitedemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ContactoAdapter extends BaseAdapter {

    private ArrayList<Contacto> lista;


    public ContactoAdapter(ArrayList<Contacto> lista ) {
        this.lista = lista;

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView;

        if(view == null){
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contacto_adapter,viewGroup,false);
        }else{
            convertView=view;
        }

        Contacto item = (Contacto) getItem(i);

        TextView txtNombre = convertView.findViewById(R.id.txtContactoNombre);
        TextView txtEmail = convertView.findViewById(R.id.txtContactoEmail);
        TextView txtDomicilio = convertView.findViewById(R.id.txtContactoDomicilio);
        TextView txtTelefono = convertView.findViewById(R.id.txtContactoTelefono);

        txtNombre.setText(item.getNombre());
        txtEmail.setText(item.getEmail());
        txtDomicilio.setText(item.getDomicilio());
        txtTelefono.setText(String.valueOf(item.getTelefono()));

        return convertView;
    }
}
