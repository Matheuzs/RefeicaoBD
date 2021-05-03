package Modelo;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String nome;
    private Integer CPF;
    private Integer RG;

    public Cliente() {
    }

    public Cliente(String nome, Integer CPF, Integer RG) {
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }
    
    public Integer getRG() {
        return RG;
    }

    public void setRG(Integer RG) {
        this.RG = RG;
    }

    @Override
    public String toString() {
        return "CLIENTE{" + "nome=" + nome + ", CPF=" + CPF + ", RG=" + RG + '}';
    }

}
