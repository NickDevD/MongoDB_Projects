package dao;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import model.Automovel;
import org.bson.Document;

public class autoSys {

    private MongoCollection<Document> docsAuto;

    public autoSys(ConexaoMongo conexao) {
        this.docsAuto = conexao.getDatabase().getCollection("auto");
    }

    public void creatAuto(Automovel auto) {
        docsAuto.insertOne(auto.toDocument());

    }

    public void listarAuto() {
        for (Document doc : docsAuto.find()) {
            System.out.println(Automovel.fromDocument(doc));
        }
    }

}
