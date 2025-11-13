public class MyOptional<T> {
    private final T value;
    private final boolean present;

    // Конструктор без параметрів (порожній)
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    // Конструктор з параметром
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    // Метод перевірки наявності значення
    public boolean isPresent() {
        return present;
    }

    // Метод перевірки відсутності значення
    public boolean isEmpty() {
        return !present;
    }

    // Метод отримання значення
    public T get() {
        if (!present) {
            throw new IllegalStateException("Cannot get value from empty MyOptional");
        }
        return value;
    }

    // Метод отримання значення або значення за замовчуванням
    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    // Метод toString
    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }

    // Тестування в методі main
    public static void main(String[] args) {
        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }
    }
}
