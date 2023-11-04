import java.time.LocalDate;

/**
 * Klasa implementująca klasę abstrakcyjną AbstractProdukt, tworząca i operująca na obiektach reprezentujących produkty spożywcze. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Jedzenie extends AbstractProdukt {
    private LocalDate dataWaznosci;

    /**
     * Konstruktor składający się z czterech parametrów.
     * @param ilosc ilość danego jedzenia
     * @param nazwa nazwa danego jedzenia
     * @param cena cena danego jedzenia
     * @param dataWaznosci data ważności danego produktu
     */
    public Jedzenie(int ilosc, String nazwa, double cena, LocalDate dataWaznosci) {
        super(nazwa, cena, ilosc);
        this.dataWaznosci = dataWaznosci;
    }

    /**
     * Metoda pobierająca nazwę jedzenia (implementacja klasy AbstractProdukt)
     * @return nazwa jedzenia
     */
    @Override
    public String pobierzNazwe() {
        return nazwa;
    }

    /**
     * Metoda ustawiająca nową nazwę jedzenia
     * @param nazwa nowa nazwa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Metoda pobierająca cenę jedzenia (implementacja klasy AbstractProdukt)
     * @return cena jedzenia
     */
    @Override
    public double pobierzCene() {
        return cena;
    }

    /**
     * Metoda ustawiająca nową cenę danego jedzenia
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
     * Metoda pobierająca ilość danego jedzenia (implementacja klasy AbstractProdukt)
     * @return ilość jedzenia
     */
    @Override
    public int pobierzIlosc() {
        return ilosc;
    }

    /**
     * Metoda ustawiająca nową ilość danego jedzenia
     * @param ilosc nowa ilość
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
     * Metoda zwracająca datę ważności produktu
     * @return data ważności produktu
     */
    public LocalDate getDataWaznosci() {
        return dataWaznosci;
    }

    /**
     * Metoda ustawiająca nową datę ważności produktu
     * @param dataWaznosci nowa data ważności
     */
    public void setDataWaznosci(LocalDate dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    /**
     * Metoda sprawdzająca, czy dany produkt jest przeterminowany
     * @return true/false w zależności od tego,czy produkt ma przekroczoną datę ważności
     */
    public boolean czyPrzeterminowane() {
        return !getDataWaznosci().isAfter(LocalDate.now());
    }
}
