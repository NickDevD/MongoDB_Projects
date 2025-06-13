package dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class mongoConnection {

    private static final String CONNECTION_URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "store";

    private MongoClient mongoClient;
    private MongoDatabase database;

    public mongoConnection(){
        try {
            String connectionString = String.format(CONNECTION_URI);

            ConnectionString connection = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connection).build();

            mongoClient = MongoClients.create(settings);

            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Conectado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public MongoDatabase getDatabase(){
        return database;
    }
}
