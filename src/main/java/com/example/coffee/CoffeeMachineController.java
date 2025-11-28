package com.example.coffee;

import org.hibernate.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
                
                <h3>Быстрый заказ:</h3>
                <form action="/process-order" method="POST">
                    <p>
                        <label>Кофе: </label>
                        <select name="coffeeType">
                            <option value="espresso">Эспрессо</option>
                            <option value="cappuccino">Капучино</option>
                            <option value="latte">Латте</option>
                            <option value="americano">Американо</option>
                        </select>
                    </p>
                    
                    <p>
                        <label>Сахар (0-5): </label>
                        <input type="number" name="sugar" value="1" min="0" max="5">"
                    </p>
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
                                 <link rel="icon" href="/images/coffee-cup.png" />
                                 <style>
                                     body { 
                                            font-family: 'Times New Roman', serif;
                                            font-size: 30px;
                                            font-style: italic;
                                            font-weight: bold;
                                            text-align: center;
                                            color: #07b007;
                                            background-color: pink;
                                            }
                                            .container {
                                            max-width: 800px
                                            margin: 0 auto;
                                            background-color: white;
                                            padding: 40px;
                                            border-radius: 20px;
                                            }
                                            .coffee-icon img {
                                            width: 150px;
                                            height: 150px;
                                            margin-bottom 20px;
                                            }
                                            h1 {
                                            color: #8B4513;
                                            margin-bottom: 30px;
                                            }
                                            .order-info {
                                            background: #f8f8f8;
                                            padding: 20px;
                                            border-radius: 10px;
                                            margin: 20px 0;
                                            border: 2px solid green;
                                            }
                                            .status {
                                            font-size: 20px;
                                            color: blue;
                                            margin: 20px 0;
                                            }
                                 </style>
                             </head>
                             <body>
                                 <div class="container">
                                 <div class="coffee-icon">
                                     <img src="/images/coffee-cup.png"/>
                                     </div>
                                     <!-- ДОБАВЬ ОСТАЛЬНЫЕ ЭЛЕМЕНТЫ -->
                                 <h1>Заказ готов!</h1>
                                 <div class="order-info">
                                     <p><strong>Тип кофе:</strong> %s</p>
                                     <p><strong>Сахар:</strong> %s кубика(ов)</p>
                                 </div>
                                 <div class="status">
                                     Статус: <strong>Готовится... </strong> 
                                 </div>
                             </div>     
                     </body>
                </html>
                """.formatted(coffee, sugar); // Постановка параметров
    }

    // Форма для заказа кофе
    @GetMapping("/simple-order")
    public String simpleOrderForm() {
        return """
                <h1> Простая форма заказа</h1>
                <p>Заполните форму:</p>
                
                <!-- ФОРМА - ОСНОВНОЙ ЭЛЕМЕНТ -->
                <form action="/process-simple-order" method="POST">
                
                <!-- ВЫБОР КОФЕ -->
                <p>Выберете кофе:</p>
                <select name="coffeeType">
                    <option value="espresso">Эспрессо</option>
                    <option value="cappuccino">Капучино</option>
                    <option value="latte">Латте</option>
                </select>
                
                 <!-- КОЛИЧЕСТВО САХАРА -->
                <p>Количество сахара?</p>
                <input type="number" name="sugar" value="1" min="0" max="5">
                
                <br><br>
                
                <!-- КНОПКА ОТПРАВКИ -->
                <button type="submit">Заказать</button>
                </form>
                """;
    }

    // Обратотка заказа
    @PostMapping("/process-simple-order")
    public String processSimpleOrder(
            @RequestParam String coffeeType,
            @RequestParam int sugar
    ) {
        return """
                <h1>Заказ принят</h1>
                <p>Ваш заказ:</p>
                <ul>
                    <li>Кофе: %s</li>
                    <li>Сахар: %d кубика</li>
                </ul>
                <p>Спасибо за заказ!</p>
                <a href="/simple-order">Сделать новый заказ</a>
                """.formatted(coffeeType,sugar);
    }
}
