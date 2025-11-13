class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    // Конструктор
    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    // Метод для обчислення рейтингу
    public double getRating() {
        if (reviews == 0) {
            return 0.0;
        }
        return total / reviews;
    }

    // Реалізація методу compareTo - ВИПРАВЛЕНА ВЕРСІЯ
    @Override
    public int compareTo(BookData other) {
        // Спочатку порівнюємо за рейтингом (вищий рейтинг -> менший об'єкт)
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        if (thisRating > otherRating) {
            return -1;
        } else if (thisRating < otherRating) {
            return 1;
        } else {
            // При рівності рейтингів - порівнюємо за назвою
            // Але нормалізуємо результат до -1, 0, 1
            int titleCompare = this.title.compareTo(other.title);
            if (titleCompare < 0) return -1;
            if (titleCompare > 0) return 1;
            return 0;
        }
    }

    // Геттери
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getReviews() {
        return reviews;
    }

    public double getTotal() {
        return total;
    }

    // toString для зручного виводу
    @Override
    public String toString() {
        return String.format("BookData{title='%s', author='%s', rating=%.2f}",
                title, author, getRating());
    }

    // Приклад тестування
    public static void main(String[] args) {
        BookData book1 = new BookData("Java Basics", "Author A", 10, 45.0); // рейтинг 4.5
        BookData book2 = new BookData("Advanced Java", "Author B", 5, 20.0); // рейтинг 4.0
        BookData book3 = new BookData("Java Patterns", "Author C", 8, 36.0); // рейтинг 4.5
        BookData book4 = new BookData("Java Basics", "Author D", 4, 18.0);   // рейтинг 4.5 (така ж назва)

        System.out.println("book1: " + book1);
        System.out.println("book2: " + book2);
        System.out.println("book3: " + book3);
        System.out.println("book4: " + book4);

        // Тестування порівняння
        System.out.println("\nРезультати порівняння:");
        System.out.println("book1.compareTo(book2): " + book1.compareTo(book2));
        System.out.println("book2.compareTo(book1): " + book2.compareTo(book1));
        System.out.println("book1.compareTo(book3): " + book1.compareTo(book3));
        System.out.println("book3.compareTo(book1): " + book3.compareTo(book1));
        System.out.println("book1.compareTo(book4): " + book1.compareTo(book4));
        System.out.println("book1.compareTo(book1): " + book1.compareTo(book1));

        // Тестування сортування
        System.out.println("\nСортування масиву книг:");
        BookData[] books = {book2, book3, book1, book4};
        java.util.Arrays.sort(books);

        for (BookData book : books) {
            System.out.println(book);
        }
    }
}
