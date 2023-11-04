/**
 * Klasa abstrakcyjna reprezentująca podstawowe własności produktów konsumenckich. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
abstract class AbstractProdukt {
    protected String nazwa;
    protected double cena;
    protected int ilosc;

    /**
     * Konstruktor składający się z trzech parametrów.
     * @param nazwa nazwa danego produktu
     * @param cena cena danego produkt
     * @param ilosc ilość danego produktu
     * @throws IllegalArgumentException gdy ilosc < 0 lub cena <= 0
     */
    public AbstractProdukt(String nazwa, double cena, int ilosc) {
        if (ilosc < 0) {
            throw new IllegalArgumentException("Podano niepoprawną ilość");
        }
        if (cena <= 0) {
            throw new IllegalArgumentException("Podano niepoprawną cenę");
        }
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    /**
     * Metoda pobierająca nazwę produktu
     * @return nazwa produktu
     */
    public abstract String pobierzNazwe();

    /**
     * Metoda pobierająca cenę produktu
     * @return cena produktu
     */
    public abstract double pobierzCene();

    /**
     * Metoda pobierająca liczbę produktów
     * @return ilość produktu
     */
    public abstract int pobierzIlosc();
}
