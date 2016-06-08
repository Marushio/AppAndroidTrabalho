package br.edu.ifsp.hto.exemplo20.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.ifsp.hto.exemplo20.R;
import br.edu.ifsp.hto.exemplo20.domain.Funcionario;

/**
 * Created by Marcio on 02/06/2016.
 */
public class FuncionarioAdapter extends BaseAdapter {
    private final Context context;
    private final List<Funcionario> funcionarios;

    public FuncionarioAdapter(Context context, List<Funcionario> funcionarios) {
        this.context = context;
        this.funcionarios = funcionarios;
    }

    @Override
    public int getCount() {
        return funcionarios != null ? funcionarios.size() :0;
    }

    @Override
    public Object getItem(int position) {
        return funcionarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return funcionarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_funcionario, parent, false);
        TextView tvNomeEmp = (TextView) view.findViewById(R.id.tvNomeEmp);
        TextView tvCargo = (TextView) view.findViewById(R.id.tvCargo);
        TextView tvDataAdm = (TextView) view.findViewById(R.id.tvDataAdm);
        TextView tvSal = (TextView) view.findViewById(R.id.tvSal);
        TextView tvCom = (TextView) view.findViewById(R.id.tvCom);
        TextView tvChefe = (TextView) view.findViewById(R.id.tvChefe);
        TextView tvDep = (TextView) view.findViewById(R.id.tvDep);


        Funcionario funcionario = funcionarios.get(position);
        Converte converte = new Converte();

        tvNomeEmp.setText(funcionario.getNome());
        tvCargo.setText(funcionario.getCargo());
        String data = converte.converteData(funcionario.getDataAdmisssao());
        tvDataAdm.setText(data);
        tvSal.setText(String.valueOf(funcionario.getSal()));
        tvCom.setText(String.valueOf(funcionario.getCom()));
        tvChefe.setText(funcionario.getChefe().getNome());
        tvDep.setText(funcionario.getDepartamento().getNome());

        return view;
    }
}
