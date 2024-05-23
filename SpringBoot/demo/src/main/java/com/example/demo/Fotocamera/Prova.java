package com.example.demo.Fotocamera;

public class Prova {
    Integer id;

    public Prova(Integer id) {
        this.id = id;
    }

    public Prova() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prova{" +
                "id=" + id +
                '}';
    }
}
