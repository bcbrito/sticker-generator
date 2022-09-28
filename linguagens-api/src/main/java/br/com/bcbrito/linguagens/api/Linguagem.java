package br.com.bcbrito.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("principaisLinguagens")
public class Linguagem {

    @Id
    private String id;
    
    private String title;
    private String image;
    private Integer ranking;

    public Linguagem(String id, String title, String image, int ranking) {
    	this.id = id;
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public String getImage() {
        return image;
    }
    public int getRanking() {
        return ranking;
    }
}
