/**
 * Interfejs reprezentujący podstawowe własności produktów konsumenckich. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public interface Produkt {
    /**
     * Metoda pobierająca nazwę produktu
     * @return nazwa produktu
     */
    String pobierzNazwe();

    /**
     * Metoda pobierająca cenę produktu
     * @return cena produktu
     */
    double pobierzCene();

    /**
     * Metoda pobierająca liczbę produktów
     * @return ilość produktu
     */
    int pobierzIlosc();
}
