package br.com.alura.screemmatch.modelos;

import br.com.alura.screemmatch.execao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    //ATRIBUTOS
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacao;
    private int duracaoEmMinutos;


    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não conseguir converter o Ano de Lançamento." +
                    " Porque tem mais de 4 caracteres");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0,2));
    }

    //METODOS
    //GETTERS
    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacao(){
        return totalDeAvaliacao;
    }

    public double getSomaDasAvaliacoes(){
        return somaDasAvaliacoes;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void exibiFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamendo do filme: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacao ++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "nome = '" + nome + '\'' +
                ", anoDeLancamento = " + anoDeLancamento + ", " +
                "Duração em minutos: " + duracaoEmMinutos;
    }
}
