package br.edu.ifsp.hto.exemplo20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.exemplo20.R;
import br.edu.ifsp.hto.exemplo20.domain.Departamento;

/**
 * Created by Marcio on 02/06/2016.
 */
public class DepartamentoAdapter extends BaseAdapter {
    private final Context context;
    private final List<Departamento> departamentos;

    public DepartamentoAdapter(Context context, List<Departamento> departamentos) {
        this.context = context;
        this.departamentos = departamentos;
    }

    @Override
    public int getCount() {
        return departamentos != null? departamentos.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return departamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return departamentos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_departamento, parent, false);
        TextView tvNomeDep = (TextView) view.findViewById(R.id.tvNomeDep);
        TextView tvLocalDep = (TextView) view.findViewById(R.id.tvLocalDep);

        Departamento departamento = departamentos.get(position);
        tvNomeDep.setText(departamento.getNome());
        tvLocalDep.setText(departamento.getLocal());
        return view;
    }
}
