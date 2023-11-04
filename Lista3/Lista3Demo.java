import java.time.LocalDate;

/**
 * Program sprawdzający działanie klas implementujących interfejs Produkt <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Lista3Demo {
    /**
     * Klasa Lista3.Demo
     * @param args badane obiekty i metody klas Jedzenie, Buty, Rezystor i Magazyn
     */
    public static void main(String[] args) {
        try {
            // Klasa Jedzenie
            Jedzenie jedzenie = new Jedzenie(5, "jabłko", 0.56, LocalDate.of(2023, 11, 5));
            System.out.println("Nazwa produktu: " + jedzenie.pobierzNazwe() + "\n" + "Cena [zł]: " + jedzenie.pobierzCene()
                    + "\n" + "Ilość: " + jedzenie.pobierzIlosc());
            System.out.println("Czy produkt jest przeterminowany?: " + jedzenie.czyPrzeterminowane());
            // Klasa Buty
            Buty but = new Buty(2, "Superstar", 355.59, "k", 5);
            System.out.println("Nazwa produktu: " + but.pobierzNazwe() + "\n" + "Cena [zł]: " + but.pobierzCene()
                    + "\n" + "Liczba par: " + but.pobierzIlosc());
            System.out.println("Rozmiar buta w standardzie US: " + but.konwersjaUS());
            System.out.println("Rozmiar buta w standardzie EU: " + but.konwersjaEU());
            // Klasa Rezystor
            Rezystor rezystor = new Rezystor(2, "1/2W-100K", 32.22, new String[] {"czarny", "czerwony", "niebieski", "zielony"});
            System.out.println("Nazwa produktu: " + rezystor.pobierzNazwe() + "\n" + "Cena [zł]: " + rezystor.pobierzCene()
                    + "\n" + "Liczba sztuk: " + rezystor.pobierzIlosc());
            System.out.println("Właściwości rezystora: " + rezystor.wlasciwosci());
            // Klasa Magazyn
            Magazyn magazyn = new Magazyn();
            magazyn.dodajProdukt(but);
            magazyn.dodajProdukt(rezystor);
            magazyn.dodajProdukt(jedzenie);
            magazyn.wyswietlZawartosc();
            magazyn.usunProdukt(rezystor);
            magazyn.wyswietlZawartosc();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}