package main.java;

import org.bson.Document;

public class Produto {
    String id;
    String nome;
    double valor;

    public Produto(String id, String nome, double valor){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Document toDocument(){
        return new Document("_id", this.id).append("nome", this.nome).append("valor", this.valor);
    }
}
