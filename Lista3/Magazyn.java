import java.util.TreeMap;

/**
 * Klasa tworząca i operująca na mapie obiektów, które implementują interfejs Produkt. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Magazyn {
    private TreeMap<Integer, Produkt> produkty = new TreeMap<>();

    /**
     * Konstruktor domyślny klasy Magazyn
     */
    public Magazyn() {}

    /**
     * Metoda ustawiająca nową mapę produktów
     * @param produkty nowa mapa produktów
     */
    public void setProdukty(TreeMap<Integer, Produkt> produkty) {
        this.produkty = produkty;
    }

    public TreeMap<Integer, Produkt> getProdukty() {
        return produkty;
    }

    /**
     * Metoda dodająca do mapy nowy produkt
     * @param p produkt
     */
    public void dodajProdukt(Produkt p) {
        if (produkty.isEmpty()) {
            produkty.put(1, p);
        } else {
            int key = produkty.lastKey();
            produkty.put(key + 1, p);
        }
    }

    /**
     * Metoda usuwająca z mapy produkt o podanym kluczu
     * @param key klucz produktu
     */
    public void usunProdukt(int key) {
        produkty.remove(key);
    }

    /**
     * Metoda pozwalająca wyświetlić mapę produktów
     * @throws IllegalArgumentException gdy mapa jest pusta
     */
    public void wyswietlZawartosc() {
        if (produkty.isEmpty()) {
            throw new IllegalArgumentException("Magazyn jest pusty");
        }
        else {
            TreeMap<Integer, String> magazyn = new TreeMap<>();
            produkty.forEach((key, value1) -> {
                String value = value1.pobierzNazwe();
                magazyn.put(key, value);
            });
            System.out.println(magazyn);
        }
    }
}
