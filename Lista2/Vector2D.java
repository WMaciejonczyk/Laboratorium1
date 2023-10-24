/**
 * Klasa bazowa tworząca i operująca na obiektach reprezentujących wektory na płaszczyźnie. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Vector2D {

    protected double x;

    protected double y;

    /**
     * Konstruktor pobierająca dwa parametry
     * @param x pierwsza współrzędna wektora
     * @param y druga współrzędna wektora
     */
    public Vector2D (double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda dodająca wektor do danej instancji wektora.
     * @param v obiekt klasy Vector2D
     * @return nowy wektor będący sumą dwóch wektorów
     */
    public Vector2D dodawanie (Vector2D v) {
        return new Vector2D (this.x + v.getX(), this.y + v.getY());
    }

    /**
     * Metoda dodająca do siebie dwa zadane wektory.
     * @param v1 pierwszy obiekt klasy Vector2D
     * @param v2 drugi obiekt klasy Vector2D
     * @return nowy wektor będący sumą dwóch wektorów
     */
    public static Vector2D dodawanieStat (Vector2D v1, Vector2D v2) {
        return new Vector2D(v1.getX() + v2.getX(), v1.getY() + v2.getY());
    }

    /**
     * Metoda odejmująca wektor od danej instancji wektora.
     * @param v obiekt klasy Vector2D (odjemnik)
     * @return nowy wektor będący różnicą dwóch wektorów
     */
    public Vector2D odejmowanie (Vector2D v) {
        return new Vector2D (this.x - v.getX(), this.y - v.getY());
    }

    /**
     * Metoda odejmująca od siebie dwa zadane wektory.
     * @param v1 pierwszy obiekt klasy Vector2D (odjemna)
     * @param v2 drugi obiekt klasy Vector2D (odjemnik)
     * @return nowy wektor będący różnicą dwóch wektorów
     */
    public static Vector2D odejmowanieStat (Vector2D v1, Vector2D v2) {
        return new Vector2D (v1.getX() - v2.getX(), v1.getY() - v2.getY());
    }

    /**
     * Metoda obliczająca iloczyn skalarny wektora i danej instancji wektora.
     * @param v obiekt klasy Vector2D
     * @return skalar będący wynikiem mnożenia dwóch wektorów
     */
    public double mnozenie (Vector2D v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    /**
     * Metoda obliczająca iloczyn skalarny dwóch zadanych wektorów.
     * @param v1 pierwszy obiekt klasy Vector2D
     * @param v2 drugi obiekt klasy Vector2D
     * @return skalar będący wynikiem mnożenia dwóch wektorów
     */
    public static double mnozenieStat (Vector2D v1, Vector2D v2) {
        return v1.getX() * v2.getX() + v1.getY() * v2.getY();
    }

    /**
     * Metoda dzieląca daną instancję wektora przez skalar.
     * @param k skalar
     * @return nowy wektor będący wynkiem podzielenia wektora przez skalar
     * @throws IllegalArgumentException gdy dzielnik (skalar) jest zerem
     */
    public Vector2D dzielenie (double k) {
        if (k == 0) {
            throw new IllegalArgumentException("Nie można dzielić przez zero.");
        }
        return new Vector2D (this.x / k, this.y / k);
    }

    /**
     * Metoda dzieląca zadany wektor przez skalar
     * @param v obiekt klasy Vector2D
     * @param k skalar
     * @return nowy wektor będący wynikiem dzielenia
     * @throws IllegalArgumentException gdy dzielnik (skalar) jest zerem
     */
    public static Vector2D dzielenieStat (Vector2D v, double k) {
        if (k == 0) {
            throw new IllegalArgumentException("Nie można dzielić przez zero.");
        }
        return new Vector2D (v.getX() / k, v.getY() / k);
    }

    /**
     * Metoda zwracająca pierwszą współrzędną wektora.
     * @return współrzędna x wektora
     */
    public double getX() {
        return x;
    }

    /**
     * Metoda ustawiająca nową pierwszą współrzędną wektora.
     * @param x nowa współrzędna x wektora
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Metoda zwracająca drugą współrzędną wektora.
     * @return współrzędna y wektora
     */
    public double getY() {
        return y;
    }

    /**
     * Metoda ustawiająca nową drugą współrzędną wektora.
     * @param y nowa współrzędna y wektora
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Metoda porównujaca instancję wektora z zadanym obiektem.
     * @param o zadany obiekt
     * @return true/false w zależności od zgodności tych dwóch obiektów
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2D vector2D = (Vector2D) o;
        return Double.compare(vector2D.getX(), getX()) == 0 && Double.compare(vector2D.getY(), getY()) == 0;
    }

    /**
     * Metoda zwracająca reprezentację wektora jako ciąg znaków.
     * @return reprezentacja wektora
     */
    @Override
    public String toString() {
        return "v = [" + getX() + ", " + getY() + "]";
    }
}