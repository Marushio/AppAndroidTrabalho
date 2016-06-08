package br.edu.ifsp.hto.exemplo20.domain;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by gustavohome on 08/05/2016.
 */
public interface DepartamentoService {
    @GET("departamento/list")
    Call<List<Departamento>> listDepartamento();

    @POST("departamento/new")
    Call<Departamento> newDepartamento(@Body Departamento departamento);

}
