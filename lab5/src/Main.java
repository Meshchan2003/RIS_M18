import java.util.HashSet; // импорт класса HashSet
import java.util.Scanner; // импорт класса Scanner
import java.util.Set; // импорт интерфейса Set

public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(); // создание объекта HashSet
        Scanner scanner = new Scanner(System.in); // создание объекта Scanner для чтения ввода с консоли
        System.out.println("Меню:\n1. Добавить\n2. Удалить\n0. Выйти\nМожно ввести слово или цифру пункта меню!\n");
        while (true) { // бесконечный цикл
            System.out.println("Выберите пункт меню:");
            String command = scanner.nextLine(); // чтение строки ввода

            switch (command) {
                case "добавить":
                case "1":
                    System.out.println("Введите строку:");
                    String str = scanner.nextLine(); // чтение строки ввода
                    set.add(str); // добавление элемента в set
                    System.out.println("Текущий список: " + set); // вывод set
                    break;
                case "удалить":
                case "2":
                    System.out.println("Введите строку:");
                    String strRemove = scanner.nextLine(); // чтение строки ввода
                    set.remove(strRemove); // удаление элемента из set
                    System.out.println("Текущий список: " + set); // вывод set
                    break;
                case "выйти":
                case "0":
                    System.out.println("Программа остановлена!");
                    return;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова");
            }
        }
    }
}
я