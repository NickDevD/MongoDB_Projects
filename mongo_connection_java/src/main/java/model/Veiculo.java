package model;

import org.bson.Document;

public class Veiculo {
    private String modelo;
    private String placa;
    private int anoFabricacao;


    public Veiculo(String modelo, String placa, int anoFabricacao) {
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
        return new Document("modelo", modelo)
                .append("placa", placa)
                .append("anoFabricacao", anoFabricacao);
    }

    public static Veiculo fromDocument(Document document) {

        return new Veiculo(
                document.getString("modelo"),
                document.getString("placa"),
                document.getInteger("anoFabricacao")
        );
    }

    @Override
    public String toString() {
        return "Automovel{"
                + "modelo=" + modelo
                + ", placa=" + placa
                + ", anoFabricacao=" + anoFabricacao +
                '}';
    }
}
