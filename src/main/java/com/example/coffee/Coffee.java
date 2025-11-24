package com.example.coffee;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//Анатация указывает что данный класс нужно хранить как таблицу
@Entity
@Table(name = "coffees")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Храним название кофе
    @Column(unique = true, nullable = false)
    private String name;

    //Ингридиенты для приготовления кофе
    private int coffeeBeans;
    private int milk;
    private int water;
    private int sugar;

    private LocalDateTime createdAt;



    public Coffee(String name,int coffeeBeans, int milk, int water, int sugar) {
        this.coffeeBeans = coffeeBeans;
        this.name = name;
        this.milk = milk;
        this.water = water;
        this.sugar = sugar;
        this.createdAt = LocalDateTime.now(); //Автоматически устанавливает текущее время
    }
    //Объявляем геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



