import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "dropDb", author = "mega", runAlways = true)
    public void dropDb(MongoDatabase db) {
        //db.drop();
    }

    @ChangeSet(order = "002", id = "insertBook1", author = "mega")
    public void insertBook1(MongoDatabase db) {
        MongoCollection<Document> books = db.getCollection("book");

        var book = new Document()
                .append("id", "")
                .append("name","Book1")
                .append("lastUpdate", "");

        books.insertOne(book);

        var comment = new Document()
                .append("id", "")
                .append("description","Comment1")
                .append("lastUpdate", "");

    }

}
