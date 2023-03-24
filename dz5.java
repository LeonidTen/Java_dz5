// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов. Пусть дан список сотрудников:
// Иван Иванов
//Светлана Петрова
//Кристина Белова
//Анна Мусина
//Анна Крутова
//Иван Юрин
//Петр Лыков
//Павел Чернов
//Петр Чернышов
//Мария Федорова
//Марина Светлова
//Мария Савина
//Мария Рыкова
//Марина Лугова
//Анна Владимирова
//Иван Мечников
//Петр Петин
//Иван Ежов

//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности имён.
//*Популярность не имён а номеров телефонов


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook {
    public static void main(String[] args) {
        // Создаем телефонную книгу
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();

        // Добавляем телефоны для каждого человека
        phoneBook.put("Иван Иванов", new ArrayList<>(List.of("111-11-11", "222-22-22")));
        phoneBook.put("Светлана Петрова", new ArrayList<>(List.of("333-33-33")));
        phoneBook.put("Кристина Белова", new ArrayList<>(List.of("444-44-44", "555-55-55")));
        phoneBook.put("Анна Мусина", new ArrayList<>(List.of("666-66-66")));
        phoneBook.put("Анна Крутова", new ArrayList<>(List.of("777-77-77")));
        phoneBook.put("Иван Юрин", new ArrayList<>(List.of("888-88-88")));
        phoneBook.put("Петр Лыков", new ArrayList<>(List.of("999-99-99")));
        phoneBook.put("Павел Чернов", new ArrayList<>(List.of("123-45-67")));
        phoneBook.put("Петр Чернышов", new ArrayList<>(List.of("234-56-78")));
        phoneBook.put("Мария Федорова", new ArrayList<>(List.of("345-67-89")));
        phoneBook.put("Марина Светлова", new ArrayList<>(List.of("456-78-90")));
        phoneBook.put("Мария Савина", new ArrayList<>(List.of("567-89-01")));
        phoneBook.put("Мария Рыкова", new ArrayList<>(List.of("678-90-12")));
        phoneBook.put("Марина Лугова", new ArrayList<>(List.of("789-01-23")));
        phoneBook.put("Анна Владимирова", new ArrayList<>(List.of("890-12-34")));
        phoneBook.put("Иван Мечников", new ArrayList<>(List.of("901-23-45")));
        phoneBook.put("Петр Петин", new ArrayList<>(List.of("012-34-56")));
        phoneBook.put("Иван Ежов", new ArrayList<>(List.of("123-45-67")));

        // Создаем HashMap для хранения количества телефонов каждого человека
        Map<String, Integer> phoneCount = new HashMap<>();

        // Перебираем каждого человека в телефонной книге и увеличиваем счетчик для каждого телефона
        for (String name : phoneBook.keySet()) {
            ArrayList<String> phones = phoneBook.get(name);
            for (String phone : phones) {
                phoneCount.put(phone, phoneCount.getOrDefault(phone, 0) + 1);
            }
        }

        // Создаем список пар (имя, количество телефонов) и сортируем его по убыванию количества телефонов
        ArrayList<Map.Entry<String, Integer>> popularPhones = new ArrayList<>(phoneCount.entrySet());
        Collections.sort(popularPhones,