package dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import model.Clientes;
import model.Veiculo;
import org.bson.Document;

public class AutoSys {

    // Variável de instância privada para a coleção MongoDB de documentos de automóveis.
    // Esta coleção será usada para realizar operações CRUD (Criar, Ler, Atualizar, Deletar) de automóveis.
    private MongoCollection<Document> docsCar;

    private MongoCollection<Document> docsCliente;

    public AutoSys(MongoConnection connection) {

        // Obtém a instância do banco de dados a partir do objeto ConexaoMongo fornecido,
        // e em seguida, obtém uma referência à coleção chamada "auto" dentro desse banco de dados.
        // Essa coleção será usada para todas as operações de banco de dados subsequentes relacionadas a veiculos.
        this.docsCar = connection.getDatabase().getCollection("auto");
        this.docsCliente = connection.getDatabase().getCollection("clientes");
    }

                        // --- Mátodos MongoDB ---

                        // --- Veiculos
    // Chama o método 'insertOne' da coleção MongoDB para inserir o documento.
    // O método 'auto.toDocument()' é responsável por transformar o objeto Java 'Automovel'
    // em um 'Document' BSON que o MongoDB pode entender e armazenar.
    public void creatCar(Veiculo veiculo) {
        docsCar.insertOne(veiculo.toDocument());
    }

    //Chama o método para deletar um automóvel.
    public void deleteAuto(String placa) {
        docsCar.deleteOne(Filters.eq("placa", placa));
       }

                        // --- Clientes

    public void creatCliente(Clientes cliente) {

        if (docsCliente != null){
            docsCliente.insertOne(cliente.toDocument());
            System.out.println("Cliente " + cliente.getName() + " cadastrado com sucesso");
        }
    }

    public void deleteCliente(String cpf) {
        docsCliente.deleteOne(Filters.eq("cpf", cpf));
        System.out.println("Cliente " + cpf + " removido com sucesso");
    }

}
