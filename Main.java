import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Базовый класс для корабля
class Ship implements Serializable {
    private String name;
    private int yearBuilt;
    private List<Cabin> cabins; // Список кают

    public Ship(String name, int yearBuilt) {
        this.name = name;
        this.yearBuilt = yearBuilt;
        this.cabins = new ArrayList<>();
    }

    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
    }

    public List<Cabin> getCabins() {
        return cabins;
    }

    public String getName() {
        return name;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    @Override
    public String toString() {
        return "Корабль{Название='" + name + "', Год постройки=" + yearBuilt + '}';
    }
}

// Класс каюты
class Cabin implements Serializable {
    private String cabinName;
    private int capacity;

    public Cabin(String cabinName, int capacity) {
        this.cabinName = cabinName;
        this.capacity = capacity;
    }

    public String getCabinName() {
        return cabinName;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Каюта{Название='" + cabinName + "', Вместимость=" + capacity + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем объекты-каюты
        Cabin cabin1 = new Cabin("Стандарт", 2);
        Cabin cabin2 = new Cabin("Люкс", 4);

        // Создаем корабль и добавляем каюты
        Ship ship = new Ship("Титаник", 1912);
        ship.addCabin(cabin1);
        ship.addCabin(cabin2);

        // Сериализация корабля
        serializeShip(ship, "ship.ser");

        // Десериализация корабля
        Ship deserializedShip = deserializeShip("ship.ser");

        // Вывод информации о корабле и его каютах
        System.out.println("Информация о корабле:");
        System.out.println(deserializedShip);
        for (Cabin cabin : deserializedShip.getCabins()) {
            System.out.println("Информация о каюте:");
            System.out.println(cabin);
        }
    }

    // Метод для сериализации объекта корабля
    private static void serializeShip(Ship ship, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(ship);
            System.out.println("Корабль сериализован и сохранен в " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для десериализации объекта корабля
    private static Ship deserializeShip(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Ship ship = (Ship) inputStream.readObject();
            System.out.println("Корабль десериализован из " + fileName);
            return ship;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
