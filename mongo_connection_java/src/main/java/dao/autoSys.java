package dao;

import com.mongodb.client.MongoCollection;
import model.Veiculo;

import org.bson.Document;

public class autoSys {

    private MongoCollection<Document> docsAuto;


    public autoSys(mongoConnection conexao) {

        this.docsAuto = conexao.getDatabase().getCollection("auto");
    }


    public void creatAuto(Veiculo auto) {

        docsAuto.insertOne(auto.toDocument());

    }

    public void listarAuto() {
        for (Document doc : docsAuto.find()) {
            System.out.println(Veiculo.fromDocument(doc));
        }

    }


}