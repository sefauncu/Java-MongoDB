package com.mongo.select;


import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class MongoDBSelect {
    public static void main(String[] args) {
        MongoClient mongoClient=null;
        
        try {
            mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase database = mongoClient.getDatabase("Customer");
            
            FindIterable<Document> iterable = database.getCollection("Customer").find();
            //FindIterable<Document> iterable = database.getCollection("Customer").find(eq("adres.il", "istanbul"));
            //FindIterable<Document> iterable = database.getCollection("Customer").find(new Document("zaman.puan", new Document("$gt", 8)));
            //FindIterable<Document> iterable = database.getCollection("Customer").find(new Document("zaman.puan", new Document("$lt", 6)));

            
          

            iterable.forEach(new Block<Document>(){

            	public void apply(Document t) {

					System.out.println(t);
				}
             
            });
        } catch (Exception e) {
            System.out.println("Hata meydana geldi. Hata: "+e);
        }
        finally{
            mongoClient.close();
        }
    }
}