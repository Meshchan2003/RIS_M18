interface Figure // интерфейс
{
    String get_Name();
    double get_S(); // метод интерфейса для расчета площади
    double get_P(); // метод интерфейса для расчета периметра
}
class Kryg implements Figure // дочерний класс Круг
{
    private double r; //уникальное свойства для круга: радиус
    public Kryg(){r = 0;}; //конструктор класса Круг без параметров
    public Kryg(double r) {this.r = r;}; //конструктор класса Круг

    //Переопределенные методы
    public double get_S() {
        return Math.PI * Math.pow(r, 2);
    }
    public double get_P() {
        return 2 * Math.PI * r;
    }

    public String get_Name(){
        return "Круг";
    }
}

class Pryamoygolnik implements Figure //дочерний Класс Прямоугольник
{
    public String name = "Прямоугольник";
    private double a, b; // уникальные свойства для прямоугольника: ширина и высота

    Pryamoygolnik(){a = 0; b = 0;}; // конструктор класса Прямоугольник без параметров
    Pryamoygolnik(double a, double b) //конструктор класса Прямоугольник
    {
        this.a = a; this.b = b;
    }

    //Переопределенные методы
    public double get_S() {
        return a * b;
    }

    public double get_P() {
        return 2 * (a + b);
    }
    public String get_Name(){
        return "Прямоугольник";
    }
}

class Treygolnik implements Figure //дочериний класс Треугольник
{
    public String name = "Треульник";
    private double a, b, y; // уникальные свойства для трекгольника: 2 стороны и угол между ними

    Treygolnik(){a = 0; b = 0; y = 0;}; //конструктор класса Треугольник без параметров
    Treygolnik(double a, double b, double y) //конструктор класса Треугольник
    {
        this.a = a; this.b = b;
        this.y = y * Math.PI / 180; // перевод значения угла в радианы.
        // пользователь вводит значение в грудсах, а функции Math принимают значение в радианах
    };

    //Переопределенные методы
    public double get_S() {
        return 0.5 * a * b * Math.sin(y);
    }

    public double get_P() {
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - 2 * a * b * Math.cos(y)); // находим третью сторону треугольника
        return a + b + c;
    }

    public String get_Name(){
        return "Треугольник";
    }
}
public class Main
{
    public static void main(String[] args)
    {
        //Использование интерфейса
        Figure[] figures = new Figure[3];
        figures[0] = new Kryg(5);     // Создание круга с радиусом 5
        figures[1] = new Pryamoygolnik(4, 6); // Создание прямоугольника со сторонами 4 и 6
        figures[2] = new Treygolnik(3, 4, 60); // Создание треугольника со сторонами 3, 4 и углом 60 градусов

// Итерация по массиву и вывод на экран площади и периметра каждой фигуры
        System.out.println("Площади и периметры фигур:\n");
        for (Figure figure : figures) {
            System.out.println(figure.get_Name()+ ": " + figure.get_S() + ", " + figure.get_P());
        }
    }
}