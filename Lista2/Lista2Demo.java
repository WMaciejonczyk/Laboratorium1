/**
 * Program sprawdzający działanie klasy nadrzędnej Vector2D i jej klasy podrzędnej ComplexNumber <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Lista2Demo {
    /**
     * Klasa Lista2.Demo
     * @param args badane obiekty i metody klas Vector2D i ComplexNumber
     */
    public static void main(String[] args) {
        // Klasa Vector2D
        Vector2D v1 = new Vector2D(4, 2);
        Vector2D v2 = new Vector2D(1, -3);
        System.out.println("Dodawanie wektorów 2D odpowiednio niestatycznie i statycznie:");
        System.out.println(v1.dodawanie(v2) + "; " + Vector2D.dodawanieStat(v1, v2));
        System.out.println("Odejmowanie wektorów 2D odpowiednio niestatycznie i statycznie:");
        System.out.println(v1.odejmowanie(v2) + "; " + Vector2D.odejmowanieStat(v1, v2));
        System.out.println("Mnożenie wektorów 2D odpowiednio niestatycznie i statycznie:");
        System.out.println(v1.mnozenie(v2) + "; " + Vector2D.mnozenieStat(v1, v2));
        System.out.println("Dzielenie wektorów 2D odpowiednio niestatycznie i statycznie:");
        System.out.println(v1.dzielenie(2) + "; " + Vector2D.dzielenieStat(v1, 2));
        try {
            System.out.println(v1.dzielenie(0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(Vector2D.dzielenieStat(v1, 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        v2.setX(4); v2.setY(2);
        System.out.println("Czy obiekty v1 i v2 są identyczne?: " + v1.equals(v2));
        v2.setX(1); v2.setY(-3);
        System.out.println("Czy obiekty v1 i v2 są identyczne?: " + v1.equals(v2));
        // Klasa ComplexNumber
        ComplexNumber n1 = new ComplexNumber(3, -5);
        ComplexNumber n2 = new ComplexNumber(-2, 2);
        System.out.println("Moduł i argument liczby zespolonej:");
        System.out.println("|z| = " + Math.round(n1.modul() * 100.0) / 100.0 + "; φ = " + Math.round(n1.argument() * 100.0) / 100.0);
        System.out.println("Dodawanie liczb zespolonych odpowiednio niestatycznie i statycznie:");
        System.out.println(n1.dodawanie(n2) + "; \n" + ComplexNumber.dodawanieStat(n1, n2));
        System.out.println("Odejmowanie liczb zespolonych odpowiednio niestatycznie i statycznie:");
        System.out.println(n1.odejmowanie(n2) + "; \n" + ComplexNumber.odejmowanieStat(n1, n2));
        System.out.println("Mnożenie liczb zespolonych odpowiednio niestatycznie i statycznie:");
        System.out.println(n1.mnozenie(n2) + "; \n" + ComplexNumber.mnozenieStat(n1, n2));
        System.out.println("Potęgowanie liczb zespolonych odpowiednio niestatycznie i statycznie:");
        System.out.println(n1.potegowanie(3.5)+ "; \n" + ComplexNumber.potegowanieStat(n1, 3.5));
        System.out.println("Dzielenie liczb zespolonych odpowiednio niestatycznie i statycznie:");
        System.out.println(n1.dzielenie(n2) + "; \n" + ComplexNumber.dzielenieStat(n1, n2));
        try {
            System.out.println(n1.dzielenie(new ComplexNumber(0, 0)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(ComplexNumber.dzielenieStat(n1, new ComplexNumber(0, 0)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reprezentacja biegunowa:");
        System.out.println(n1.repBieg());
    }
}
