package com.mongo.update;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBUpdate {
	
    public static void main(String[] args){
        MongoClient mongoClient=null;
        try {
            mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase database = mongoClient.getDatabase("Customer");
            
            database.getCollection("Customer").updateOne(new Document("adres.il","istanbul"), 
                    new Document("$set",new Document("adres.cadde","taksim")));
        
        } catch (Exception e) {
            System.out.println("Hata meydana geldi. Hata: "+e);
        }
        finally{
            mongoClient.close();
        }
    }
}