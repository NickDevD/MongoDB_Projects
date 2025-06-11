package model;

import org.bson.Document;

public class Automovel {
    private String modelo;
    private String fabricante;
    private String placa;
    private int anoFabricacao;

    public Automovel() {}

    public Automovel(String modelo, String fabricante, String placa, int anoFabricacao) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Document toDocument() {
        return  new Document("modelo", modelo)
                .append("fabricante", fabricante)
                .append("placa", placa)
                .append("anoFabricacao", anoFabricacao);
    }

    public static Automovel fromDocument(Document document) {
        return new Automovel(
                document.getString("modelo"),
                document.getString("fabricante"),
                document.getString("placa"),
                document.getInteger("anoFabricacao")
        );
    }

    @Override
    public String toString(){
        return "Automovel{"
        + "modelo= " + modelo
        + ", fabricante= " + fabricante
        + ", placa= " + placa
        + ", anoFabricacao= " + anoFabricacao +
        '}';
    }
}
