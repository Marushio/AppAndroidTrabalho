package com.example.a1320726.appaula10_05.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.a1320726.appaula10_05.R;
import com.example.a1320726.appaula10_05.task.ListarDepartamentosTask;

/**
 * Created by a1320726 on 31/05/2016.
 */
public class ListarDepartamentosFragment extends Fragment {
    private ListView mList;

    public ListarDepartamentosFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listar_departamentos, container, false);

        mList = (ListView) view.findViewById(R.id.listView);
        ListarDepartamentosTask listarProfessoresPresenter = new ListarDepartamentosTask();

        listarProfessoresPresenter.listarDerpatamentos(getContext(), mList);

        return view;
    }
}
