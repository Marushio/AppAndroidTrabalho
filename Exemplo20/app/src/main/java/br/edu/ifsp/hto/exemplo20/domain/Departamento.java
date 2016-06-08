package br.edu.ifsp.hto.exemplo20.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gustavohome on 08/05/2016.
 */
public class Departamento {
    @SerializedName("n_dep")
    private int id;

    @SerializedName("nome_dep")
    private String nome;

    @SerializedName("local_dep")
    private String local;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
