package com.example.coffee;

import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController - говорит Spring: "Этот класс обрабатывает HTTP запросы"
@RestController
public class CoffeeMachineController {

    @GetMapping("/test")
    public String test() {
        return "Контроллер работает";
    }
    // Добавил метод гланой страницы или домашней
    @GetMapping("/coffee-machine")
    public String coffeeMachineHome() {
        return """
                <h1>Меню кофемашины</h1>
                <p>Добро пожаловать на главную страницу кофемашины</p>
                <p>Вам предложены следующие напитки :</p>
                <url>
                    <li>Эспрессо - <b>100 р</b></li>
                    <li>Капучино - <b>200 р</b></li>
                    <li>Латте - <b>250 р</b></li>
                    <li>Американо - <b>150 р</b></li>
                </url>
                """;
    }
    @GetMapping("/hello")
    public String helloCoffeeMachine() {
        return "Привет, кофемашина!";
    }
    // Добавил метод для заказа кофе
    @GetMapping("/order")
    public String orderCoffee(@RequestParam String coffee,
                              @RequestParam int sugar) {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Заказ готов</title>
                    <!-- конка для браузера-->
                    <link rel="icon" href="/images/coffee-icon.png" />
                    <style>
                        body { 
                               font-family: 'Times New Roman', serif;
                               font-size: 30px;
                               font-style: italic;
                               font-weight: bold;
                               font-align: center;
                               color: #07b007;
                               }
                    </style>
                </head>
                <body>
                    <div class="container">
                    <div class="coffee-icon">
                        <img src="/images/coffee-icon.png"/>
                        <h1>Заказ готов!</h1>
                        <!-- ДОБАВЬ ОСТАЛЬНЫЕ ЭЛЕМЕНТЫ -->
                    </div>
                </body>
                </html>
                """;
    }
}
