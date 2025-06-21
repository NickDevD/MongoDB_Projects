package model;

import org.bson.Document;

public class Clientes {
    String name;
    String cpf;
    String telefone;

    public Clientes(String name, String cpf, String telefone) {
        this.name = name;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Document toDocument() {
        return new Document("name", name)
                .append("cpf", cpf)
                .append("telefone", telefone);
    }

    public static Clientes fromDocument(Document document) {
        return new Clientes(
                document.getString("name"),
                document.getString("cpf"),
                document.getString("telefone"));
    }

    public String toString() {
        return "Clientes{"
                + "name=" + name
                + ", cpf=" + cpf
                + ", telefone=" + telefone +
                '}';
    }
}
