# Консольное приложение для фильтрации аэропортов

## Как работает приложение

В настройках приложения (в свойствах) задается номер колонки из файла с данными, поиск по которой будет происходить. Программа в консоли ждет ввода строки. Пользователь вводит строку и получает список отфильтрованных значений аэропортов по выбранной колонке.

## Программа выводит в консоль:
1. список строк аэропортов, отфильтрованных и отсортированных по нужной колонке в лексикографическом порядке;
2. количество найденных строк;
3. время в миллисекундах, потраченное на поиск.

## Запуск

```sh
java -jar <имя файла сборки> <необязательный номер колонки>.
Введите строку: <введенная строка>
Количество найденных строк: n. Время, затраченное на поиск: n мс.
```
