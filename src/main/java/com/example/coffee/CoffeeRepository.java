package com.example.coffee;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// @Repository - ПОМЕЧАЕТ КЛАСС КАК "РЕПОЗИТОРИЙ"
// Spring создает этот класс автоматически и добавляет в него ВСЕ методы для работы с базой
// JpaRepository<Coffee, Long> означает:
// - Работаем с сущностью Coffee
// - ID имеет тип Long
@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    // ВАЖНО: SPRING DATA JPA АВТОМАТИЧЕСКИ СОЗДАЕТ МЕТОДЫ!
    // Мы просто объявляем метод, а Spring сам генерирует SQL запрос
    Optional<Coffee> findByName(Coffee name);
    // Spring видит "findByName" и понимает:
    // "Нужно сделать: SELECT * FROM coffees WHERE name = ?"
}
