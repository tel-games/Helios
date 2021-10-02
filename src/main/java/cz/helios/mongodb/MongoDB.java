package cz.helios.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import cz.helios.config.Config;
import net.dv8tion.jda.api.entities.Member;
import org.bson.Document;

public class MongoDB {

    static final String url = Config.secretConfig.get(Config.secretConfig.SecredSavedData.MONGO);
    static MongoClientURI clientURI = new MongoClientURI(url);
    static MongoClient mongoClient = new MongoClient(clientURI);
    static MongoDatabase mongoDatabase = mongoClient.getDatabase("Tutorial");
    static MongoCollection collection = mongoDatabase.getCollection("users");

    public static void logMember(Member member) {
        Document document = new Document("Name", member.getEffectiveName())
                .append("Nickname", member.getNickname())
                .append("Online status", member.getOnlineStatus().toString())
                .append("Joined", new StringBuilder().append(member.getTimeJoined().getDayOfMonth())
                        .append(member.getTimeJoined().getMonth().getValue())
                        .append(member.getTimeJoined().getYear()).toString());

        collection.insertOne(document);
    }
}
