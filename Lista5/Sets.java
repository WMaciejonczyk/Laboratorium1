import java.util.HashSet;

/**
 * Klasa tworząca i operująca na zbiorach zawierających liczby całkowite. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Sets {

    private HashSet<Integer> setA;

    private HashSet<Integer> setB;

    /**
     * Konstruktor przyjmujący dwa parametry.
     * @param setA pierwszy zbiór
     * @param setB drugi zbiór
     * @throws IllegalArgumentException gdy setA lub setB są puste
     */
    public Sets (HashSet<Integer> setA, HashSet<Integer> setB) {
        if (setA.isEmpty() || setB.isEmpty()) {
            throw new IllegalArgumentException("Zbiory nie mogą być puste.");
        }
        else {
            this.setA = new HashSet<>(setA);
            this.setB = new HashSet<>(setB);
        }
    }

    /**
     * Metoda wykonująca dodawanie na zbiorach
     * @return suma zbiorów
     */
    public HashSet<Integer> Addition () {
        HashSet<Integer> sum = getSetA();
        sum.addAll(getSetB());
        return sum;
    }

    /**
     * Metoda wykonująca odejmowanie zbiorów
     * @param direction kierunek odejmowania (A\B gdy true lub B\A gdy false)
     * @return różnica zbiorów
     */
    public HashSet<Integer> Substraction (boolean direction) {
        HashSet<Integer> sub;
        if (direction) {
            sub = getSetA();
            sub.removeAll(getSetB());
        }
        else {
            sub = getSetB();
            sub.removeAll(getSetA());
        }
        return sub;
    }

    /**
     * Metoda wykonująca iloczyn zbiorów
     * @return iloczyn zbiorów
     */
    public HashSet<Integer> Multiplication () {
        HashSet<Integer> multi = getSetA();
        multi.retainAll(getSetB());
        return multi;
    }

    /**
     * Metoda wykonujaca odejmowanie symetryczne zbiorów
     * @return różnica symetryczna zbiorów
     */
    public HashSet<Integer> SymmetricSubstration () {
        HashSet<Integer> ss1 = getSetA();
        HashSet<Integer> ss2 = getSetB();
        ss1.removeAll(getSetB());
        ss2.removeAll(getSetA());
        ss1.addAll(ss2);
        return ss1;
    }

    /**
     * Metoda sprawdzająca, czy podane zbiory są identyczne
     * @return true/false w zależności od zgodności zbiorów
     */
    public boolean areEqual () {
        return getSetA().equals(getSetB());
    }

    /**
     * Metoda zwracająca pierwszy zbiór
     * @return pierwszy zbiór
     */
    public HashSet<Integer> getSetA() {
        return new HashSet<>(setA);
    }

    /**
     * Metoda ustawiająca nowy pierwszy zbiór
     * @param setA nowy pierwszy zbiór
     * @throws IllegalArgumentException gdy setA jest pusty
     */
    public void setSetA(HashSet<Integer> setA) {
        if (setA.isEmpty()) {
            throw new IllegalArgumentException("Zbiór nie może być pusty.");
        }
        else {
            this.setA = new HashSet<>(setA);
        }
    }

    /**
     * Metoda zwracająca drugi zbiór
     * @return drugi zbiór
     */
    public HashSet<Integer> getSetB() {
        return new HashSet<>(setB);
    }

    /**
     * Metoda ustawiająca nowy drugi zbiór
     * @param setB nowy drugi zbiór
     * @throws IllegalArgumentException gdy setB jest pusty
     */
    public void setSetB(HashSet<Integer> setB) {
        if (setB.isEmpty()) {
            throw new IllegalArgumentException("Zbiór nie może być pusty.");
        }
        else {
            this.setB = new HashSet<>(setB);
        }
    }
}
