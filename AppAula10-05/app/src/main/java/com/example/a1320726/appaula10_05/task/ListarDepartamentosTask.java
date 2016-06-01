package com.example.a1320726.appaula10_05.task;

import android.content.Context;
import android.widget.ListView;

import com.example.a1320726.appaula10_05.adapter.DepartamentoAdapter;
import com.example.a1320726.appaula10_05.domain.Departamento;
import com.example.a1320726.appaula10_05.service.DepartamentoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by a1320726 on 31/05/2016.
 */
public class ListarDepartamentosTask {
    public static String baseURL = "http://192.168.120.4:8090/";

    public void listarDerpatamentos(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DepartamentoService service = retrofit.create(DepartamentoService.class);
        Call<List<Departamento>> call = service.listarDepartamento();

        call.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                List<Departamento> list = response.body();

                listView.setAdapter(new DepartamentoAdapter(context, list));
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {

            }
        });
    }
}
