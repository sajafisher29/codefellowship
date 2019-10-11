package com.fishersarah.codefellowship.codefellowship.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    ApplicationUser owner;

    private String body;
    private String createdAt;

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public long getId() {
        return id;
    }

    public Post(){};

    public Post(String body, String createdAt, ApplicationUser owner){

        this.body = body;
        this.createdAt = createdAt;
        this.owner = owner;
    }

    public String toString(){
        return String.format("%s posted at %s: %s. ", this.owner, this.createdAt, this.body);
    }

}
