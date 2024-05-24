package com.example.demo.Fotocamera;

public class PostBody {
    Long id;

    public PostBody(Long id) {
        this.id = id;
    }

    public PostBody() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prova{" +
                "id=" + id +
                '}';
    }
}
