package com.example.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.List;

import java.util.List;

// ВАЖНО: @Service - ПОМЕЧАЕТ КЛАСС КАК "СЕРВИС"
// Содержит бизнес-логику приложения
// Spring создает один экземпляр этого класса (singleton)
@Service
public class CoffeeService {
    // ВАЖНО: @Autowired - "ВНЕДРЕНИЕ ЗАВИСИМОСТИ"
    // Spring автоматически находит CoffeeRepository и "вставляет" его сюда
    // Это называется Dependency Injection (DI)
    @Autowired
    private CoffeeRepository coffeeRepository;

    @PostConstruct
    public void init() {
        if (coffeeRepository.count() == 0) {
            createDefaultCoffees();
        }
    }
    // Создаем назные виды кофе
    private void createDefaultCoffees() {
        Coffee espresso = new Coffee("espresso", 20, 0, 30, 0);
        Coffee cappuccino = new Coffee("cappuccino", 18, 150, 30, 0);
        Coffee latte = new Coffee("latte", 15, 200, 30, 0);
        Coffee americano = new Coffee("americano", 20, 0, 120, 0);

        // Сохраняем в базу данных
        coffeeRepository.save(espresso);
        coffeeRepository.save(cappuccino);
        coffeeRepository.save(latte);
        coffeeRepository.save(americano);

        System.out.println("Созданы виды кофе по умолчанию!");
    }

    // Получить все виды кофе
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();// SELECT * FROM coffee
    }

    // Найти кофе по названию
    public Coffee findCoffeeByName(String name) {
        return coffeeRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Кофе не найден: " + name));
    }

    // ПОЛУЧИТЬ ИНГРЕДИЕНТЫ ДЛЯ КОФЕ
    public String getCoffeeIngredients(String coffeeName) {
        Coffee coffee = findCoffeeByName(coffeeName);
        return """
            Ингредиенты для %s:
            ☕ Кофейные зерна: %d г
            🥛 Молоко: %d мл
            💧 Вода: %d мл
            🍯 Сахар: %d г
            """.formatted(
                coffee.getName(),
                coffee.getCoffeeBeans(),
                coffee.getMilk(),
                coffee.getWater(),
                coffee.getSugar()
        );
    }
}
