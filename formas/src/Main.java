import java.util.Scanner;

// Definición de la interfaz Shape
interface Shape {
    double getArea();
    double getPerimeter();
}

// Definición de la clase del circulo
class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }
// calculo de area y perimetro
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Definición de la clase triangulo o triangle
class Triangle implements Shape {
    private double side1, side2, side3;

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

// Definición de la clase Square
class Square implements Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}

// Clase principal para el menú con opciones
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al programa de cálculo de áreas y perímetros de figuras geométricas.");

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Calcular área");
            System.out.println("2. Calcular perímetro");
            System.out.println("3. Salir");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    Shape shape1 = selectShape(scanner);
                    System.out.println("El área de la figura seleccionada es: " + shape1.getArea());
                    break;
                case "2":
                    Shape shape2 = selectShape(scanner);
                    System.out.println("El perímetro de la figura seleccionada es: " + shape2.getPerimeter());
                    break;
                case "3":
                    System.out.println("Adios");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    // Método que se usa para seleccionar la figura para hacer calculos
    private static Shape selectShape(Scanner scanner) {
        System.out.println("\nSeleccione una figura:");
        System.out.println("1. Círculo");
        System.out.println("2. Triángulo");
        System.out.println("3. Cuadrado");

        String option = scanner.nextLine();

        switch (option) {
            case "1":
                System.out.print("Ingrese el radio del círculo: ");
                double radius = Double.parseDouble(scanner.nextLine());
                return new Circle(radius);
            case "2":
                System.out.print("Ingrese la longitud del primer lado del triángulo: ");
                double side1 = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese la longitud del segundo lado del triángulo: ");
                double side2 = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese la longitud del tercer lado del triángulo: ");
                double side3 = Double.parseDouble(scanner.nextLine());
                return new Triangle(side1, side2, side3);
            case "3":
                System.out.print("Ingrese la longitud del lado del cuadrado: ");
                double side = Double.parseDouble(scanner.nextLine());
                return new Square(side);
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                return selectShape(scanner);
        }
    }
}
