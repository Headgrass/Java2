package Lesson3;


import java.util.*;

public class PhoneBook {
    // TreeSet - чтобы телефонные номера были отсортированы
    private Map<String, TreeSet<String>> records = new TreeMap<>(Comparator.naturalOrder());

    public void add(String surname, String phoneNumber) {
        TreeSet<String> numbers = records.get(surname);
        if (numbers == null) {
            numbers = new TreeSet<>();
            numbers.add(phoneNumber);
            records.put(surname, numbers);
        } else {
            numbers.add(phoneNumber);
        }
    }

    public String get(String surname) {
        String[] phoneNumbers = getPhoneNumbers(surname);

        if (phoneNumbers.length == 0)
            return "";

        StringBuilder sb = new StringBuilder(phoneNumbers[0]);

        for (int i = 1; i < phoneNumbers.length; i++) {
            sb.append(", ").append(phoneNumbers[i]);
        }

        return sb.toString();
    }

    public String[] getPhoneNumbers(String surname) {
        String[] result = new String[]{};
        Set<String> phoneNumbers = records.get(surname);

        if (phoneNumbers != null) {
            result = phoneNumbers.toArray(result);
        }

        return result;
    }

    public String[] getAllSurnames() {
        String[] result = new String[]{};
        result = records.keySet().toArray(result);
        return result;
    }
}
class PhoneBookTest {

    public static void main(String[] args) {
        // В условиях задачи не сказано, в каком формате нужно выводить список номеров для фамилии
        // По умолчанию я сделал метод, который выдает все номера одной строкой: String get(String surname)
        // String[] getPhoneNumbers(String surname) - вернет массив номеров

        PhoneBook phoneBook = new PhoneBook();
        populatePhoneBook(phoneBook);

        for (String surname :
                phoneBook.getAllSurnames()) {
            System.out.println(surname + ", тел.: " + phoneBook.get(surname));
        }

        System.out.println();
        System.out.println("Test for surname not in phonebook...");
        System.out.println("Aaaaa" + ", тел.: " + phoneBook.get("Aaaaa"));
    }

    private static void populatePhoneBook(PhoneBook phoneBook) {
        phoneBook.add("Иванов", "+7(963)885-21-47");
        phoneBook.add("Петров", "+7(963)885-21-88");
        phoneBook.add("Сидоров", "+7(963)885-21-99");
        phoneBook.add("Вассерман", "+7(963)885-21-77");
        phoneBook.add("Иванов", "+7(963)885-21-00");
        phoneBook.add("Иванов", "+7(963)885-21-47");
        phoneBook.add("Петров", "+7(963)885-21-47");
        phoneBook.add("Иванов", "+7(963)885-21-47");
    }


}