import java.util.ArrayList;
/**
 * Klasa tworząca i operująca na liście obiektów, które implementują interfejs Produkt. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Magazyn {
    private ArrayList<Produkt> produkty = new ArrayList<>();

    /**
     * Konstruktor domyślny klasy Magazyn
     */
    public Magazyn() {}

    /**
     * Metoda ustawiająca nową listę produktów
     * @param produkty nowa lista produktów
     */
    public void setProdukty(ArrayList<Produkt> produkty) {
        this.produkty = produkty;
    }

    /**
     * Metoda dodająca do listy dany produkt
     * @param p produkt
     */
    public void dodajProdukt(Produkt p) {
        produkty.add(p);
    }

    /**
     * Metoda usuwająca z listy dany produkt
     * @param p produkt
     */
    public void usunProdukt(Produkt p) {
        produkty.remove(p);
    }

    /**
     * Metoda pozwalająca wyświetlić zawartość listy produktów
     * @throws IllegalArgumentException gdy lista jest pusta
     */
    public void wyswietlZawartosc() {
        if (produkty.size() == 0) {
            throw new IllegalArgumentException("Lista produktów jest pusta");
        }
        else {
            System.out.print("[");
            for (int i = 0; i < produkty.size(); i++) {
                if (i != produkty.size() - 1) {
                    System.out.print(produkty.get(i).pobierzNazwe() + ", ");
                }
                else {
                    System.out.print(produkty.get(i).pobierzNazwe());
                }
            }
            System.out.println("]");
        }
    }
}
