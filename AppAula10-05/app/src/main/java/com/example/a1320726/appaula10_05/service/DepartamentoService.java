package com.example.a1320726.appaula10_05.service;

import com.example.a1320726.appaula10_05.domain.Departamento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by a1320726 on 31/05/2016.
 */
public interface DepartamentoService {
    @GET("departamento/list")
    Call<List<Departamento>> listarDepartamento();

    @POST("departamento/new")
    Call<Departamento> criarDepartamento(@Body Departamento departamento);
}
