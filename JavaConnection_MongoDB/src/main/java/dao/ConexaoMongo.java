package dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexaoMongo {

    // Variáveis de Configuração
    private static final String USERNAME = "nickdevd";
    private static final String PASSWORD = "RPIdwowPzESzCj5c";
    private static final String CLUSTER_URL = "datacluster01.yt28ean.mongodb.net";
    private static final String DATABASE_NAME = "autostore";

    private MongoClient mongoClient;
    private MongoDatabase database;

    public ConexaoMongo() {
        try {
            //String de conexão com credenciais
            String connectionString = String.format("mongodb+srv://"+USERNAME+":"+PASSWORD+"@"+CLUSTER_URL+"/?retryWrites=true&w=majority&appName="+DATABASE_NAME);

            //Configuração do cliente Mongo
            ConnectionString connection = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connection).build();

            //Criando o cliente
            mongoClient = MongoClients.create(settings);

            database = mongoClient.getDatabase(DATABASE_NAME);

            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao MongoDB "+e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase() { return database; }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
