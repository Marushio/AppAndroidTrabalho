package br.edu.ifsp.hto.exemplo20.domain;

/**
 * Created by Marcio on 07/06/2016.
 */
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChefeService {
    @GET("chefe/list")
    Call<List<Chefe>> listaChefe();
}