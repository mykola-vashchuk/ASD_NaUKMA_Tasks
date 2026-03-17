package PW_9.Task1;

public class Library {
    private String name;

    public Library(String name) {
        this.name = name;
    }

    public class Book { // inner class, тісно зв'язаний з зовнішнім, має доступ до всіх полів зовнішнього
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String bookLabel() {
            return String.format("[%s] %s - %s", name, author, title);
        }
    }
}
