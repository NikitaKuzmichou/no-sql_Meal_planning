package com.knv;

import com.knv.config.ServiceConfiguration;
import com.knv.db.migrations.DbFiller;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class Application {

    public static void main(String[] args) {
//        fillDatabase();
        SpringApplication.run(Application.class, args);
    }

    public static void fillDatabase() {
        final CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(
                PojoCodecProvider.builder()
                        .automatic(true)
                        .build());

        final CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        final MongoClient client = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString("mongodb://localhost:27017"))
                        .codecRegistry(codecRegistry)
                        .build());

        DbFiller.fill(client.getDatabase(ServiceConfiguration.DATABASE_NAME));
    }
}
