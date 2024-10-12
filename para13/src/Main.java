import java.sql.Date;
import java.util.Scanner;

public class Main {//это все использовать как пример для свей БД

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean bool=true;
        while (bool){
        System.out.println();
        System.out.println("""
                Выберите что добавить
                1.Счет
                2.Потребитель
                3.Устройство
                4.Показания
                5.Ресурсы
                6.Ничего не добавлять и завершить работу
                """);
        int swtch = scanner.nextInt();
        switch (swtch) {
            case 1: {
                addAccount();
            }
            break;
            case 2: {
                addConsumer();
            }
            break;
            case 3: {
                addDevice();
            }
            break;
            case 4: {
                addIndication();
            }
            break;
            case 5: {
                addResource();
            }
            break;
            default: {
                System.out.println("Значение выходит за предусмотренные границы");
            }
            break;
        }
    }
}
    public static void addAccount() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите показания счетов");
        int account_number = scanner.nextInt();
        System.out.println("Введите улицу и дом");
        String consumer_name = scanner.next();
        int consumer_id = bd.findIntByName("id_consumer", "consumers", "consumer_name", consumer_name);
        if (consumer_id != -1) {
            bd.addAccount(account_number, consumer_id);
        } else {
            System.out.println("Такой адрес не найден");
        }
    }

    public static void addResource() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сколько надо всего");
        int resource_amount = scanner.nextInt();
        System.out.println("Введите улицу и дом");
        String consumer_name = scanner.next();
        int consumer_id = bd.findIntByName("id_consumer", "consumers", "consumer_name", consumer_name);
        if (consumer_id != -1) {
            bd.addResource(resource_amount, consumer_id);
        } else {
            System.out.println("Такой адрес не найден");
        }
    }

    public static void addIndication() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите показания");
        int indication_number = scanner.nextInt();
        System.out.println("Введите улицу и дом");
        String consumer_name = scanner.next();
        int account_id = bd.findIntByName("id_consumer", "consumers", "consumer_name", consumer_name);
        if (account_id != -1) {
            bd.addIndication(indication_number, account_id);
        } else {
            System.out.println("Такой адрес не найден");
        }
    }

    public static void addConsumer() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите улицу и дом");
        String consumer_name = scanner.nextLine();
        System.out.println("Введите сколько надо для дома");
        int consumer_need = scanner.nextInt();
        System.out.println("Введите срок, когда энергия перестанет поступать (ХХХХ-ХХ-ХХ)");
        Date consumer_date_expire = Date.valueOf(scanner.next());
        bd.addConsumer(consumer_name, consumer_need, consumer_date_expire);
    }

    public static void addDevice() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название устройства");
        String device_name = scanner.nextLine();
        System.out.println("Введите улицу и дом");
        String consumer_name = scanner.next();
        int consumer_id = bd.findIntByName("id_consumer", "consumers", "consumer_name", consumer_name);
        if (consumer_id != -1) {
            bd.addDevice(device_name, consumer_id);
        } else {
            System.out.println("Такой адрес не найден");
        }
    }

    public static void addBook() {
        BD bd = new BD();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги");
        String book_title = scanner.next();
        System.out.println("Введите жанр книги");
        String genre_name = scanner.next();
        int genre_id = bd.findIntByName("genre_id", "Genre", "genre_name", genre_name);
        System.out.println("Введите фамилию автора книги");
        String author_surname = scanner.next();
        int author_id = bd.findIntByName("author_id", "Author", "author_surname", author_surname);
        if (author_id != -1 && genre_id != -1) {
            bd.addBook(book_title, genre_id, author_id);
        } else {
            System.out.println("Автор и/или жанр не найден");
        }
    }
}