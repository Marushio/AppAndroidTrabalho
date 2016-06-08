package br.edu.ifsp.hto.exemplo20.task;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import br.edu.ifsp.hto.exemplo20.adapter.DepartamentoAdapter;
import br.edu.ifsp.hto.exemplo20.domain.Departamento;
import br.edu.ifsp.hto.exemplo20.domain.DepartamentoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marcio on 02/06/2016.
 */
public class DepartamentoTask {
    List<Departamento> departamentos;

    public void DepartamentoTask(final Context context, final ListView listView){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.69.103:8090/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DepartamentoService departamentoService = retrofit.create(DepartamentoService.class);
        Call<List<Departamento>> listCall = departamentoService.listDepartamento();
        listCall.enqueue(new Callback<List<Departamento>>() {
            @Override
            public void onResponse(Call<List<Departamento>> call, Response<List<Departamento>> response) {
                departamentos = response.body();
                listView.setAdapter(new DepartamentoAdapter(context, departamentos));
            }

            @Override
            public void onFailure(Call<List<Departamento>> call, Throwable t) {

            }
        });
    }
}
