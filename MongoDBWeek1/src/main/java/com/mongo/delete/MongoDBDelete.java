package com.mongo.delete;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBDelete {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        
        try {
            mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase database = mongoClient.getDatabase("Customer");
            
            database.getCollection("Customer").deleteOne(new Document("isim","Sefa"));
          //database.getCollection("Customer").deleteMany(new Document("adres.il","istanbul"));
          //database.getCollection("Customer").deleteMany(new Document());

        } catch (Exception e) {
            System.out.println("Hata meydana geldi. Hata: " + e);
        } finally {
            mongoClient.close();
        }
    }
}