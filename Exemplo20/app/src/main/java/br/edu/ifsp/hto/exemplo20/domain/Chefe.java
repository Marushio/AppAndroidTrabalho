package br.edu.ifsp.hto.exemplo20.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by gustavohome on 08/05/2016.
 */
public class Chefe {
    @SerializedName("n_emp")
    private long id;

    @SerializedName("nome_emp")
    private String nome;

    @SerializedName("cargo")
    private String cargo;

    @SerializedName("data_adm")
    private Date dataAdmisssao;

    @SerializedName("sal")
    private double sal;

    @SerializedName("com")
    private double com;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getCom() {
        return com;
    }

    public void setCom(double com) {
        this.com = com;
    }

    public Date getDataAdmisssao() {
        return dataAdmisssao;
    }

    public void setDataAdmisssao(Date dataAdmisssao) {
        this.dataAdmisssao = dataAdmisssao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

}
