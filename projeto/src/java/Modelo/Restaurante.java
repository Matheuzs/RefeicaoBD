package Modelo;

import java.io.Serializable;

public class Restaurante implements Serializable {

    private String CNPJ;
    private String nomeOficial;
    private String nomeFantasia;
    private String endereco;
    private String telefone;
    private String email;

    public Restaurante() {
    }
    
    public Restaurante(String CNJ, String nomeOficial, String nomeFantasia, String endereco, String telefone, String email) {
        this.CNPJ = CNPJ;
        this.nomeOficial = nomeOficial;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNomeOficial() {
        return nomeOficial;
    }

    public void setNomeOficial(String nomeOficial) {
        this.nomeOficial = nomeOficial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
