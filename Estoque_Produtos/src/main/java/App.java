import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.DeleteResult;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static final String CONNECTION_URI = "mongodb://localhost:27017/";
    private static final String DATABASE_NAME = "estoque";
    private static final String COLLECTION_NAME = "produtos";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        MongoClient mongoClient = null;


        try{
            mongoClient = MongoClients.create(CONNECTION_URI);
            System.out.println("Conectado com sucesso!");

            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

            MongoCollection<Document> produtos = database.getCollection(COLLECTION_NAME);

            boolean conection = true;
            while (conection) {

                String opcao = in.next();
                switch (opcao) {
                    case "1":
                        System.out.println("\nDigite os dados do produto\n");
                        System.out.print("ID: ");
                        String id = in.next();
                        System.out.print("Nome: ");
                        String nome = in.next();

                        double valor = 0.0; // Variável que determina que o double aceita apenas números
                        boolean valorValido = false;

                        // Loop para garantir que o valor seja um número válido
                        while (!valorValido) {
                            System.out.print("Valor: ");
                            try {
                                valor = in.nextDouble();
                                valorValido = true; // Se chegou aqui, o valor é válido
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida! Por favor, digite um número para o valor.");
                                in.next(); // Limpa o buffer do scanner, consumindo a entrada inválida
                            }
                        }

                        Produto produto = new Produto(id, nome, valor);
                        InsertOneResult pro01 = produtos.insertOne(produto.toDocument());
                        System.out.println("\nProduto adicionado\n");
                        break;

                    case "2":
                        String idFilter = in.next();
                        DeleteResult deleteResult1 = produtos.deleteOne(Filters.eq("_id",idFilter));


                    case "3":
                        conection = false;
                        System.out.println("conexão encerrada");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        }finally {
            if (mongoClient != null){
                mongoClient.close();
            }
        }



    }
}
