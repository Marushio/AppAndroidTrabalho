package com.example.a1320726.appaula10_05.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.a1320726.appaula10_05.R;
import com.example.a1320726.appaula10_05.domain.Departamento;

import java.util.List;

/**
 * Created by a1320726 on 31/05/2016.
 */
public class DepartamentoAdapter extends BaseAdapter {
    private final Context context;
    private final List<Departamento> departamentos;

    public DepartamentoAdapter (Context context, List departamentos){
        this.context = context;
        this.departamentos = departamentos;
    }
    @Override
    public int getCount() {
        return departamentos != null ? departamentos.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return departamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return departamentos.get(position).getN_dep();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_departamentos, parent, false);

        TextView tNumero = (TextView) view.findViewById(R.id.n_dep);
        TextView tNome = (TextView) view.findViewById(R.id.nome_dep);
        TextView Tlocal = (TextView) view.findViewById(R.id.local_dep);

        Departamento departamento = departamentos.get(position);
        tNome.setText(departamento.getNome_dep());
        tNumero.setText(departamento.getN_dep());
        Tlocal.setText(departamento.getLocal_dep());


        return view;
    }
}
