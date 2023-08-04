/*Реализуйте структуру телефонной книги с помощью HashMap, 
учитывая, что 1 человек может иметь несколько телефонов.
Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдёт и выведет повторяющиеся 
имена с количеством повторений. Отсортировать по убыванию популярности.*/
package task1;
import java.util.*;
public class task1 {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Иван Иванов", Arrays.asList("181-991", "262-225"));
        phoneBook.put("Светлана Петрова", Collections.singletonList("403-303"));
        phoneBook.put("Кристина Белова", Collections.singletonList("344-344"));
        phoneBook.put("Анна Мусина", Collections.singletonList("545-587"));
        phoneBook.put("Анна Крутова", Collections.singletonList("612-426"));
        phoneBook.put("Иван Юрин", Collections.singletonList("731-957"));
        phoneBook.put("Петр Лыков", Collections.singletonList("158-117"));
        phoneBook.put("Павел Чернов", Collections.singletonList("699-399"));
        phoneBook.put("Петр Чернышов", Arrays.asList("987-878", "113-552"));
        phoneBook.put("Мария Федорова", Collections.singletonList("811-722"));
        phoneBook.put("Марина Светлова", Collections.singletonList("538-444"));
        phoneBook.put("Мария Савина", Collections.singletonList("359-666"));
        phoneBook.put("Мария Рыкова", Collections.singletonList("737-811"));
        phoneBook.put("Марина Лугова", Arrays.asList("566-442", "753-275"));
        phoneBook.put("Анна Владимирова", Collections.singletonList("141-033"));
        phoneBook.put("Иван Мечников", Collections.singletonList("092-404"));
        phoneBook.put("Петр Петин", Collections.singletonList("330-550"));
        phoneBook.put("Иван Ежов", Collections.singletonList("454-466"));

        Map<String, Integer> nameCount = new HashMap<>();
        for (String name : phoneBook.keySet()) {
            String firstName = name.split(" ")[0];
            nameCount.put(firstName, nameCount.getOrDefault(firstName, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCount.entrySet());
        Collections.sort(sortedNames, Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> entry : sortedNames) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }    
}