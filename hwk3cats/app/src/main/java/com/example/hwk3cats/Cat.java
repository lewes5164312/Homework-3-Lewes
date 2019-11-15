package com.example.hwk3cats;

public class Cat {

    private String id;
    private String name;
    private String description;
    private CatWeight weight;
    private String temperament;
    private String origin;
    private String life_span;
    private String wikipedia_url;
    private int dog_friendly;

    public Cat(String id, String name, String description, String CatWeight, String temperament, String origin, String life_span, String wikipedia_url, int dog_friendly) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.temperament = temperament;
        this.origin = origin;
        this.life_span = life_span;
        this.wikipedia_url = wikipedia_url;
        this.dog_friendly = dog_friendly;
    }

    public Cat() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CatWeight getWeight() {
        return weight;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLife_span() {
        return life_span;
    }

    public String getWikipedia_Url() {
        return wikipedia_url;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(CatWeight weight) {
        this.weight = weight;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public void setWikipediaUrl(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }


}
