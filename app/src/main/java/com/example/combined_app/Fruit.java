package com.example.combined_app;

public class Fruit {
    private String name;
    private int imageResource;

    public Fruit(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
