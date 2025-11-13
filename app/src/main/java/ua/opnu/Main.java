package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // === Завдання 3 ===
        System.out.println("=== Завдання 3 ===");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // === Завдання 4 ===
        System.out.println("\n=== Завдання 4 ===");
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        Integer[] evenNumbers = filter(numbers, evenPredicate);
        System.out.println("Парні числа: " + Arrays.toString(evenNumbers));

        String[] words = {"apple", "banana", "cherry", "pear"};
        Predicate<String> longWordPredicate = s -> s.length() > 5;
        String[] longWords = filter(words, longWordPredicate);
        System.out.println("Довгі слова: " + Arrays.toString(longWords));

        // === Завдання 5 ===
        System.out.println("\n=== Завдання 5 ===");
        String[] strings = {"pear", "banana", "cherry"};
        System.out.println("Contains 'banana': " + contains(strings, "banana"));
        System.out.println("Contains 'orange': " + contains(strings, "orange"));

        Integer[] nums = {1, 2, 3, 4, 5};
        System.out.println("Contains 3: " + contains(nums, 3));
        System.out.println("Contains 10: " + contains(nums, 10));

        // === Завдання 6 ===
        System.out.println("\n=== Завдання 6 ===");

        // Демонстрація GenericTwoTuple
        System.out.println("--- GenericTwoTuple ---");
        GenericTwoTuple<String, Integer> studentRating = getStudentWithRating("Іванов Петр Петрович");
        System.out.println("Студент: " + studentRating.first + ", рейтинг: " + studentRating.second);

        GenericTwoTuple<String, Integer> productPrice = new GenericTwoTuple<>("Ноутбук", 25000);
        System.out.println("Товар: " + productPrice.first + ", ціна: " + productPrice.second);

        // Демонстрація GenericThreeTuple
        System.out.println("\n--- GenericThreeTuple ---");
        GenericThreeTuple<String, Integer, String> studentInfo = getStudentFullInfo("Петренко Олена");
        System.out.println("Студент: " + studentInfo.first +
                ", вік: " + studentInfo.second +
                ", спеціальність: " + studentInfo.third);

        GenericThreeTuple<String, Integer, Boolean> productFullInfo =
                new GenericThreeTuple<>("Смартфон", 15000, true);
        System.out.println("Товар: " + productFullInfo.first +
                ", ціна: " + productFullInfo.second +
                ", в наявності: " + productFullInfo.third);

        // Використання toString()
        System.out.println("\n--- Використання toString() ---");
        System.out.println("studentRating: " + studentRating);
        System.out.println("productPrice: " + productPrice);
        System.out.println("studentInfo: " + studentInfo);
        System.out.println("productFullInfo: " + productFullInfo);
    }

    // === Завдання 3: Клас Printer ===
    static class Printer {
        public <T> void printArray(T[] array) {
            for (T element : array) {
                System.out.println(element);
            }
        }
    }

    // === Завдання 4: Узагальнений метод filter ===
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        List<T> resultList = new ArrayList<>();

        for (T element : input) {
            if (p.test(element)) {
                resultList.add(element);
            }
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) Arrays.copyOf(input, resultList.size());
        return resultList.toArray(result);
    }

    // === Завдання 5: Узагальнений метод contains ===
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // === Завдання 6: Методи для кортежів ===
    public static GenericTwoTuple<String, Integer> getStudentWithRating(String fullName) {
        int rating = (int)(Math.random() * 100);
        return new GenericTwoTuple<>(fullName, rating);
    }

    public static GenericThreeTuple<String, Integer, String> getStudentFullInfo(String fullName) {
        int age = 20 + (int)(Math.random() * 5);
        String specialty = "Комп'ютерні науки";
        return new GenericThreeTuple<>(fullName, age, specialty);
    }
}

// === Завдання 6: Узагальнений клас для двох елементів ===
class GenericTwoTuple<T, V> {
    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}

// === Завдання 6: Узагальнений клас для трьох елементів ===
class GenericThreeTuple<T, V, S> {
    public final T first;
    public final V second;
    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + "," + third + ")";
    }
}
