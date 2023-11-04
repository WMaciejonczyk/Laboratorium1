/**
 * Klasa implementująca klasę abstrakcyjną AbstractProdukt, tworząca i operująca na obiektach reprezentujących obuwie marki Adidas. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class AbstractButy extends AbstractProdukt {
    private String plec;
    private double rozmiarUK;

    /**
     * Konstruktor składający się z pięciu parametrów.
     * @param ilosc liczba par danych butów
     * @param nazwa nazwa danych butów
     * @param cena cena danych butów
     * @param plec męskie lub damskie obuwie
     * @param rozmiarUK rozmiar buta w standardzie UK
     * @throws IllegalArgumentException gdy rozmiarUK > 14 lub < 3.5 lub nie jest podzielny przez 0.5 lub podano złą płeć
     */
    public AbstractButy(int ilosc, String nazwa, double cena, String plec, double rozmiarUK) {
        super(nazwa, cena, ilosc);
        if (rozmiarUK < 3.5 || rozmiarUK > 14 && rozmiarUK % 0.5 != 0) {
            throw new IllegalArgumentException("Podano niepoprawny rozmiar");
        }
        if (!plec.equalsIgnoreCase("M") && !plec.equalsIgnoreCase("K")) {
            throw new IllegalArgumentException("Podano niepoprawną płeć");
        }
        this.plec = plec;
        this.rozmiarUK = rozmiarUK;
    }

    /**
     * Metoda pobierająca nazwę butów (implementacja klasy AbstractProdukt)
     * @return nazwa butów
     */
    @Override
    public String pobierzNazwe() {
        return nazwa;
    }

    /**
     * Metoda ustawiająca nową nazwę butów
     * @param nazwa nowa nazwa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Metoda pobierająca cenę butów (implementacja klasy AbstractProduktt)
     * @return cena butów
     */
    @Override
    public double pobierzCene() {
        return cena;
    }

    /**
     * Metoda ustawiająca nową cenę butów
     * @param cena nowa cena
     * @throws IllegalArgumentException gdy cena <= 0
     */
    public void setCena(double cena) {
        if (cena <= 0) {
            throw new IllegalArgumentException("Niepoprawna cena produktu");
        }
        else {
            this.cena = cena;
        }
    }

    /**
     * Metoda pobierająca liczbę par butów (implementacja klasy AbstractProdukt)
     * @return liczba par
     */
    @Override
    public int pobierzIlosc() {
        return ilosc;
    }

    /**
     * Metoda ustawiająca nową liczbę par butów
     * @param ilosc nowa liczba par
     * @throws IllegalArgumentException gdy ilosc < 0
     */
    public void setIlosc(int ilosc) {
        if (ilosc < 0) {
            throw new IllegalArgumentException("Niepoprawna ilość produktu");
        }
        else {
            this.ilosc = ilosc;
        }
    }

    /**
     * Metoda zwracająca informację o tym, dla której płci przeznaczony jest produkt
     * @return dedykowana płeć
     */
    public String getPlec() {
        return plec;
    }

    /**
     * Metoda ustawiająca nową dedykowaną płeć dla danego produktu
     * @param plec nowa dedykowana płeć
     * @throws IllegalArgumentException gdy wybrana płeć to ani M, ani K
     */
    public void setPlec(String plec) {
        if (plec.equalsIgnoreCase("M") || plec.equalsIgnoreCase("K")) {
            this.plec = plec;
        }
        else {
            throw new IllegalArgumentException("Podano niepoprawną płeć");
        }
    }

    /**
     * Metoda zwracająca rozmiar buta w standarzie UK
     * @return rozmiar buta
     */
    public double getRozmiarUK() {
        return rozmiarUK;
    }

    /**
     * Metoda ustawiająca nowy rozmiar buta w standardzie UK
     * @param rozmiarUK nowy rozmiar buta
     * @throws IllegalArgumentException gdy rozmiarUK > 14 lub < 3.5 lub nie jest podzielny przez 0.5
     */
    public void setRozmiarUK(double rozmiarUK) {
        if (rozmiarUK < 3.5 || rozmiarUK > 14 && rozmiarUK % 0.5 != 0) {
            throw new IllegalArgumentException("Podano niepoprawny rozmiar");
        }
        this.rozmiarUK = rozmiarUK;
    }

    /**
     * Metoda dokonująca konwersji rozmiaru ze standardu UK na standard US
     * @return rozmiar buta w standardzie US (w zależności od dedykowanej płci)
     */
    public double konwersjaUS() {
        if (plec.equals("M")) {
            return rozmiarUK + 0.5;
        }
        else {
            return rozmiarUK + 1.0;
        }
    }

    /**
     * Metoda dokonująca konwersji rozmiaru ze standardu UK na standard EU
     * @return rozmiar buta w standardzie EU
     */
    public double konwersjaEU() {
        double licznik = rozmiarUK / 0.5 - 7.0;
        return Math.round((36.0 + (2.0 / 3.0 * licznik)) * 100.0) / 100.0;
    }
}
