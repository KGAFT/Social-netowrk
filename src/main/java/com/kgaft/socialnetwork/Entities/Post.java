package com.kgaft.socialnetwork.Entities;



import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="postname")
    private String postname;
    @Column(name="postinfo")
    private String postinfo;
    @Column(name="owner")
    private String owner;

    public String getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    public String getPostinfo() {
        return postinfo;
    }

    public void setPostinfo(String postinfo) {
        this.postinfo = postinfo;
    }

    public Post(String postname, String postinfo, String owner) {
        this.postname = postname;
        this.postinfo = postinfo;
        this.owner = owner;
    }

    public Post() {
    }
}
