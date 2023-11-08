# Тестовое задание
Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.


Пример входной строки: “aaaaabcccc”
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

## Примененные технологии

Java 17, Spring 3, Stream API, JUnit, Integration tests

## Начало работы
Чтобы запустить проект необходимо в директории проекта использовать команду:
```bash
./gradlew run
```

## Работа проекта
В приложении находится один endpoint, принимающей GET запрос с адресом


http://localhost:8080/task/count?str=параметр


В качестве параметра принимается строка с символами, например ```aaabccccc```
## Результат запроса
При отправки запроса приложение выводит соответсвующий список символов 

и их количество в порядке возрастания

Входные данные: ```http://localhost:8080/task/count?str=aaabccccc```

Результат:

```json
{
    "c": 5,
    "a": 3,
    "b": 1
}
```