package model;

import org.bson.Document;

public class Veiculo {
    private String modelo; // Armazena o modelo do automóvel (ex: "Uno", "Onix").
    private String fabricante; // Armazena o fabricante do automóvel (ex: "Fiat", "Chevrolet").
    private String placa; // Armazena a placa do automóvel (ex: "ABC1234").
    private int anoFabricacao; // Armazena o ano de fabricação do automóvel.

    public Veiculo(String modelo, String fabricante, String placa, int anoFabricacao) {
        this.modelo = modelo; // Inicializa o atributo 'modelo' com o valor passado.
        this.fabricante = fabricante; // Inicializa o atributo 'fabricante' com o valor passado.
        this.placa = placa; // Inicializa o atributo 'placa' com o valor passado.
        this.anoFabricacao = anoFabricacao; // Inicializa o atributo 'anoFabricacao' com o valor passado.
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

    /**
     * Método que converte um objeto Automovel Java em um objeto org.bson.Document.
     * Este é um método essencial para persistir o objeto no MongoDB, pois o MongoDB
     * armazena dados no formato BSON (representado por Document no driver Java).
     *
     */
    public Document toDocument() {
        // Cria um novo Document BSON.
        // Cada atributo do Automovel é adicionado como um campo (chave-valor) no Document.
        // O campo '_id' não é explicitamente adicionado aqui, o que significa que
        // o MongoDB irá gerar um ObjectId automaticamente para o documento quando ele for inserido.
        return new Document("modelo", modelo)
                .append("fabricante", fabricante)
                .append("placa", placa)
                .append("anoFabricacao", anoFabricacao);
    }

    /**
     * Método estático que converte um objeto org.bson.Document em um objeto Automovel Java.
     * Este é um método de fábrica (factory method) que permite reconstruir um objeto Automovel
     * a partir de um documento recuperado do MongoDB.
     *
     */
    public static Veiculo fromDocument(Document document) {
        // Cria uma nova instância de Automovel usando o construtor,
        // extraindo os valores dos campos do Document.
        // document.getString() e document.getInteger() são métodos do Document
        // para obter valores por tipo e nome do campo.
        return new Veiculo(
                document.getString("modelo"), // Obtém o valor do campo "modelo" como String.
                document.getString("fabricante"), // Obtém o valor do campo "fabricante" como String.
                document.getString("placa"), // Obtém o valor do campo "placa" como String.
                document.getInteger("anoFabricacao")  // Obtém o valor do campo "anoFabricacao" como Integer.
        );
    }

    /**
     * Sobrescreve o método toString() da classe Object.
     * Este método fornece uma representação em String legível do objeto Automovel,
     * o que é útil para depuração e para imprimir informações do objeto.
     */
    @Override
    public String toString() {
        return "Automovel{"
                + "modelo=" + modelo // Inclui o valor do modelo.
                + ", fabricante=" + fabricante // Inclui o valor do fabricante.
                + ", placa=" + placa // Inclui o valor da placa.
                + ", anoFabricacao=" + anoFabricacao + // Inclui o valor do ano de fabricação.
                '}'; // Fecha a representação String do objeto.
    }


}
