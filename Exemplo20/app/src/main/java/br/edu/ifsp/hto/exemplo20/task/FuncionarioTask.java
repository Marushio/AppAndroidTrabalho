package br.edu.ifsp.hto.exemplo20.task;

import android.content.Context;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import br.edu.ifsp.hto.exemplo20.adapter.FuncionarioAdapter;
import br.edu.ifsp.hto.exemplo20.domain.Funcionario;
import br.edu.ifsp.hto.exemplo20.domain.FuncionarioService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marcio on 02/06/2016.
 */
public class FuncionarioTask {
    List<Funcionario> funcionarios;

    public void FuncionarioTask(final Context context, final ListView listView){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.69.103:8090/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        FuncionarioService service = retrofit.create(FuncionarioService.class);
        Call<List<Funcionario>> call = service.listFuncionario();
        call.enqueue(new Callback<List<Funcionario>>() {
            @Override
            public void onResponse(Call<List<Funcionario>> call, Response<List<Funcionario>> response) {
                funcionarios = response.body();
                listView.setAdapter(new FuncionarioAdapter(context, funcionarios));
            }

            @Override
            public void onFailure(Call<List<Funcionario>> call, Throwable t) {

            }
        });
    }
}
