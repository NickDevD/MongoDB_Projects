package dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;

public class MongoConnection {

    // Carrega as variáveis do arquivo .env
    // .load() procura o arquivo .env na raiz do projeto (onde está o pom.xml).
    Dotenv dotenv = Dotenv.load();

    // 1. Crie variáveis de configuração de conexão com o Mongo
    private String connectionUserName = dotenv.get("DB_USERNAME");
    private String connectionPassword = dotenv.get("PASSWORD");
    private String clusterUrl = dotenv.get("CLUSTER_URL");
    private String databaseName = dotenv.get("DATABASE_NAME");

    // 2. Crie variáveis de instância para armazenar o cliente MongoDB e o Banco de Dados
      // Elas serão inicializadas no construtor
    private MongoClient mongoClient;
    private MongoDatabase database;

    /**
     * 3. Crie o construtor da classe ConexaoMongo.
     * Este construtor é responsável por estabelecer a conexão com o servidor MongoDB
     * usando as credenciais e o URL do cluster definidos.
     */
    public MongoConnection() {

        // 4. Use o try / catch para capturar erros
        try{
            //Construção da String de conexão
            String connectionString = String.format("mongodb+srv://%s:%s@%s/?retryWrites=true&w=majority&appName=%s",
                    connectionUserName, connectionPassword, clusterUrl, databaseName);

            // Cria um objeto a partir da string formatada
            ConnectionString connection = new ConnectionString(connectionString);
            MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connection).build();

            // Instância do MongoClient com as configurações definidas
            mongoClient = MongoClients.create(settings);

            // Instância do Banco de Dados que obtem o BD
            database = mongoClient.getDatabase(databaseName);

            System.out.println("\nConnected to the database successfully\n");

        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer
            System.out.println("Erro ao conectar ao MongoDB "+e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método público para obter a instância do banco de dados conectado.
     * Isso permite que outras classes acessem o banco de dados para realizar operações (inserir, buscar, etc.).
     * @return A instância de MongoDatabase conectada.
     */
    public MongoDatabase getDatabase() {
        return database;
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Connection closed successfully");
        }
    }
}
