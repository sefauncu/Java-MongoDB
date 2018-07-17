package com.mongo.insert;


import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import static java.util.Arrays.asList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class MongoDBInsert {

    public static void main(String[] args) {
        MongoClient mongoClient;
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        try {
            mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase database = mongoClient.getDatabase("Customer");

            List<Document> documents = new ArrayList<Document>();

         
                documents.add(new Document("adres",
                            new Document()
                            .append("cadde", "kadýmehmet")
                            .append("postakodu", "34000")
                            .append("il", "istanbul")
                            .append("koordinat", asList(-73.9557413, 40.7720266)))
                
                    .append("zaman", asList(
                            new Document()
                            .append("tarih", format.format(new Date()))
                            .append("kan_grubu", "A")
                            .append("puan", 5),
                            new Document()
                            .append("tarih", format.format(new Date()))
                            .append("kan_grubu", "B")
                            .append("puan", 9)))
                    .append("isim", "Sefa")
                    .append("isyeri_id", "41704620"));
            

            database.getCollection("Customer").insertMany(documents);
          for(Document key : documents ) {
        	  System.out.println(key);
          }
          
        } catch (Exception e) {
            System.err.println("Bir Hata Meydana Geldi!");
            System.out.println("Hata" + e);
        }
    }
}