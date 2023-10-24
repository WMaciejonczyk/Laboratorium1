/**
 * Klasa podrzędna tworząca i operująca na obiektach reprezentujących wektory zespolone na płaszczyźnie. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class ComplexNumber extends Vector2D {
    /**
     * Konstruktor przyjmujący dwa parametry
     * @param a część rzeczywista wektora
     * @param b część urojona wektora
     */
    public ComplexNumber (double a, double b) {
        super(a, b);
    }

    /**
     * Metoda obliczająca moduł liczby zespolonej.
     * @return moduł liczby zespolonej
     */
    public double modul () {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    /**
     * Metoda obliczająca argument liczby zespolonej.
     * @return argument liczby zespolonej
     * @throws IllegalArgumentException gdy liczba zespolona jest wektorem zerowym
     */
    public double argument () {
        if (x == 0 && y == 0) {
            throw new IllegalArgumentException("Argument liczby jest nieoznaczony.");
        }
        return Math.atan2(y, x);
    }

    /**
     * Metoda dodająca liczbę zespoloną do danej instancji liczby zespolonej.
     * @param v obiekt klasy Vector2D jako liczba zespolona
     * @return nowa liczba zespolona będąca suma dwóch innych
     */
    @Override
    public Vector2D dodawanie (Vector2D v) {
        return new ComplexNumber(x + v.getX(), y + v.getY());
    }

    /**
     * Metoda obliczająca sumę dwóch zadanych liczb zespolonych.
     * @param n1 pierwsza liczba zespolona
     * @param n2 druga liczba zespolona
     * @return nowa liczba zespolona będąca sumą dwóch innych
     */
    public static ComplexNumber dodawanieStat (ComplexNumber n1, ComplexNumber n2) {
        return new ComplexNumber(n1.getX() + n2.getX(), n1.getY() + n2.getY());
    }

    /**
     * Metoda odejmująca liczbę zespoloną od danej instancji liczby zespolonej.
     * @param v obiekt klasy Vector2D jako liczba zespolona (odjemnik)
     * @return nowa liczba zespolona będąca różnicą dwóch innych
     */
    @Override
    public Vector2D odejmowanie (Vector2D v) {
        return new ComplexNumber(x - v.getX(), y - v.getY());
    }

    /**
     * Metoda obliczająca różnicę dwóch zadanych liczb zespolonych.
     * @param n1 pierwsza liczba zespolona
     * @param n2 druga liczba zespolona
     * @return nowa liczba zespolona będąca różnicą dwóch innych
     */
    public static ComplexNumber odejmowanieStat (ComplexNumber n1, ComplexNumber n2) {
        return new ComplexNumber(n1.getX() - n2.getX(), n1.getY() - n2.getY());
    }

    /**
     * Metoda obliczająca iloczyn liczby zespolonej i danej instancji liczby zespolonej.
     * @param n obiekt klasy Vector2D jako liczba zespolona
     * @return nowa liczba zespolona będąca iloczynem dwóch innych
     */

    public ComplexNumber mnozenie (ComplexNumber n) {
        return new ComplexNumber(x * n.getX() - y * n.getY(),y * n.getX() + x * n.getY());
    }

    /**
     * Metoda obliczająca iloczyn dwóch zadanych liczb zespolonych.
     * @param n1 pierwsza liczba zespolona
     * @param n2 druga liczba zespolona
     * @return nowa liczba zespolona będąca iloczynem dwóch innych
     */
    public static ComplexNumber mnozenieStat (ComplexNumber n1, ComplexNumber n2) {
        return new ComplexNumber(n1.getX() * n2.getX() - n1.getY() * n2.getY(), n1.getY() * n2.getX() + n1.getX() * n2.getY());
    }

    /**
     * Metoda dzieląca daną instancję liczby zespolonej przez inną liczbę zespoloną.
     * @param n liczba zespolona (dzielnik)
     * @return nowa liczba zespolona będąca ilorazem dwóch innych
     * @throws IllegalArgumentException gdy dzielnik jest zerem
     */
    public ComplexNumber dzielenie (ComplexNumber n) {
        if (n.getX() == 0 && n.getY() == 0) {
            throw new IllegalArgumentException("Mianownik nie może być zerowy.");
        }
        double mianownik = Math.pow(n.getX(), 2) + Math.pow(n.getY(), 2);
        return new ComplexNumber ((x * n.getX() + y * n.getY()) / mianownik, (y * n.getX() - x * n.getY()) / mianownik);
    }

    /**
     * Metoda obliczająca iloraz dwóch liczb zespolonych.
     * @param n1 pierwsza liczba zespolona (dzielna)
     * @param n2 druga liczba zespolona (dzielnik)
     * @return nowa liczba zespolona będąca ilorazem dwóch innych
     * @throws IllegalArgumentException gdy dzielnik jest zerem
     */
    public static ComplexNumber dzielenieStat (ComplexNumber n1, ComplexNumber n2) {
        if (n2.getX() == 0 && n2.getY() == 0) {
            throw new IllegalArgumentException("Mianownik nie może być zerowy.");
        }
        double mianownik = Math.pow(n2.getX(), 2) + Math.pow(n2.getY(), 2);
        return new ComplexNumber ((n1.getX() * n2.getX() + n1.getY() * n2.getY()) / mianownik,
                                  (n1.getY() * n2.getX() - n1.getX() * n2.getY()) / mianownik);
    }

    /**
     * Metoda obliczająca daną potęgę danej instancji liczby zespolonej.
     * @param p wykładnik
     * @return nowa liczba zespolona będąca wynikiem potęgowania innej
     */
    public ComplexNumber potegowanie (double p) {
        double modul = Math.pow(modul(), p);
        double rzecz = modul * Math.cos(p * argument());
        double uroj = modul * Math.sin(p * argument());
        return new ComplexNumber(rzecz, uroj);
    }

    /**
     * Metoda obliczająca daną potęgę zadanej liczby zespolonej.
     * @param n liczba zespolona
     * @param p wykładnik
     * @return nowa liczba zespolona będąca wynikiem potęgowania innej
     */
    public static ComplexNumber potegowanieStat (ComplexNumber n, double p) {
        double modul = Math.pow(n.modul(), p);
        double rzecz = modul * Math.cos(p * n.argument());
        double uroj = modul * Math.sin(p * n.argument());
        return new ComplexNumber(rzecz, uroj);
    }

    /**
     * Metoda zwracająca reprezentację biegunową liczby zespolonej.
     * @return reprezentacja biegunowa po zaokrągleniu do dwóch miejsc po przecinku
     */
    public String repBieg () {
        return "z = (" + Math.round(modul() * 100.0) / 100.0 + ", " + Math.round(argument() * 100.0) / 100.0 + ")";
    }

    /**
     * Metoda porównujaca instancję liczby zespolonej z zadanym obiektem.
     * @param o zadany obiekt
     * @return true/false w zależności od zgodności tych dwóch obiektów
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber number = (ComplexNumber) o;
        return Double.compare(number.getX(), getX()) == 0 && Double.compare(number.getY(), getY()) == 0;
    }

    /**
     * Metoda zwracająca reprezentację liczby zespolonej jako ciąg znaków.
     * @return postać wykładnicza i kanoniczna liczby zespolonej
     */
    @Override
    public String toString () {
        String exp;
        String kan;
        if (y < 0) {
            exp = Math.round(modul() * 100.0) / 100.0 + "exp(-i" + (-Math.round(argument() * 100.0) / 100.0) + ")";
            kan = "z = " + Math.round(x * 100.0) / 100.0 + " - i" + Math.round(-y * 100.0) / 100.0;
        }
        else {
            exp = Math.round(modul() * 100.0) / 100.0 + "exp(i" + Math.round(argument() * 100.0) / 100.0 + ")";
            kan = "z = " + Math.round(x * 100.0) / 100.0 + " + i" + Math.round(y * 100.0) / 100.0;
        }
        return exp + "\n" + kan;
    }
}
