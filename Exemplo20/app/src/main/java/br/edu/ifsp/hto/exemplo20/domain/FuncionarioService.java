package br.edu.ifsp.hto.exemplo20.domain;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by gustavohome on 08/05/2016.
 */
public interface FuncionarioService {

    @GET("funcionario/list")
    Call<List<Funcionario>> listFuncionario();

    /*@POST("funcionario/new")
    Call<Funcionario> criaFuncionario(@Field("nome_emp")String nome_emp, @Field("cargo")String cargo, @Field("chefe")int chefe,
                                      @Field("data_adm")String data_adm, @Field("sal")double sal, @Field("com")double com, @Field("n_dep") int n_dep);
    */
    @FormUrlEncoded
    @POST("funcionario/new")
    Call<Funcionario> criaFuncionario(@Field("nome_emp")String nome_emp, @Field("cargo")String cargo,@Field("chefe")int chefe,
                                      @Field("data_adm")String data_adm, @Field("sal")double sal,@Field("com")double com,@Field("n_dep")int n_dep);


}
