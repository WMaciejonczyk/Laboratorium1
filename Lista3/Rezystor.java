/**
 * Klasa implementująca interfejs Produkt, tworząca i operująca na obiektach reprezentujących rezystory. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Rezystor extends AbstractProdukt { {
    private String[] kodPaskowy;

    /**
     * Konstruktor składający się z czterech parametrów.
     * @param ilosc liczba danych rezystorów
     * @param nazwa nazwa danego rezystora
     * @param cena cena danego rezystora
     * @param kodPaskowy kod paskowy zawierający informacje o właściwościach rezystora
     * @throws IllegalArgumentException gdy ilosc < 0 lub cena <= 0 lub kodPaskowy nie jest 4-elementowy
     */
    public Rezystor(int ilosc, String nazwa, double cena, String[] kodPaskowy) {
       super(nazwa, cena, ilosc);
       if (kodPaskowy.length != 4) {
           throw new IllegalArgumentException("Podano błędny kod paskowy");
       }
       this.kodPaskowy = kodPaskowy;
   }

    /**
     * Metoda pobierająca nazwę rezystora (implementacja interfejsu Produkt)
     * @return nazwa rezystora
     */
    @Override
    public String pobierzNazwe() {
        return nazwa;
    }

    /**
     * Metoda ustawiająca nową nazwę rezystora
     * @param nazwa nowa nazwa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * Metoda pobierająca cenę rezystora (implementacja interfejsu Produkt)
     * @return cena rezystora
     */
    @Override
    public double pobierzCene() {
        return cena;
    }

    /**
     * Metoda ustawiająca nową cenę rezystora
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
     * Metoda zwracająca liczbę rezystorów (implementacja interfejsu Produkt)
     * @return liczba rezystorów
     */
    @Override
    public int pobierzIlosc() {
        return ilosc;
    }

    /**
     * Metoda ustawiająca nową liczbę rezystorów
     * @param ilosc nowa liczba
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
     * Metoda zwracająca kod paskowy rezystora
     * @return kod paskowy
     */
    public String[] getKodPaskowy() {
        return kodPaskowy;
    }

    /**
     * Metoda ustawiająca nowy kod paskowy rezystora
     * @param kodPaskowy nowy kod paskowy
     */
    public void setKodPaskowy(String[] kodPaskowy) {
        this.kodPaskowy = kodPaskowy;
    }

    /**
     * Metoda obliczająca pierwszą połowę kodu paskowego rezystora, która odpowiada pewnej wartości jego rezystancji
     * @return wartość rezystancji
     * @throws IllegalArgumentException gdy podano błędny kolor
     */
    public double paski() {
        double[] paski = new double[2];
        for (int i = 0; i < 2; i++) {
            switch (kodPaskowy[i]) {
                case "czarny" -> paski[i] = 0;
                case "brązowy" -> paski[i] = 1;
                case "czerwony" -> paski[i] = 2;
                case "pomarańczowy" -> paski[i] = 3;
                case "żółty" -> paski[i] = 4;
                case "zielony" -> paski[i] = 5;
                case "niebieski" -> paski[i] = 6;
                case "fioletowy" -> paski[i] = 7;
                case "szary" -> paski[i] = 8;
                case "biały" -> paski[i] = 9;
                default -> throw new IllegalArgumentException("Podano niepoprawny kolor");
            }
        }
        return 10 * paski[0] + paski[1];
    }

    /**
     * Metoda zwracająca część kodu paskowego, która odpowiedzialna jest za rząd rezystancji
     * @return mnożnik rezystora
     * @throws IllegalArgumentException gdy podano błędny kolor
     */
    public double mnoznik() {
        double mnoznik = switch (kodPaskowy[2]) {
            case "czarny" -> 1.0;
            case "brązowy" -> 10.0;
            case "czerwony" -> 100.0;
            case "pomarańczowy" -> 1000.0;
            case "żółty" -> 10000.0;
            case "zielony" -> 100000.0;
            case "niebieski" -> 1000000.0;
            case "fioletowy" -> 10000000.0;
            case "złoty" -> 0.1;
            case "srebrny" -> 0.01;
            default -> throw new IllegalArgumentException("Podano niepoprawny kolor");
        };
        return mnoznik;
    }

    /**
     * Metoda zwracająca część kodu paskowego, która odpowiedzialna jest za tolerancję rezystora
     * @return tolerancja rezystora
     * @throws IllegalArgumentException gdy podano blędny kolor
     */
    public double tolerancja() {
        double tolerancja = switch (kodPaskowy[3]) {
            case "brązowy" -> 1;
            case "czerwony" -> 2;
            case "zielony" -> 0.5;
            case "niebieski" -> 0.25;
            case "fioletowy" -> 0.1;
            case "szary" -> 0.05;
            case "złoty" -> 5;
            case "srebrny" -> 10;
            default -> throw new IllegalArgumentException("Podano niepoprawny kolor");
        };
        return tolerancja;
    }

    /**
     * Metoda reprezentująca właściwości danego rezystora
     * @return ciąg znaków zawierający informacje o rezystorze
     */
    public String wlasciwosci() {
        double rezystancja;
        String jednostka;
        if (mnoznik() >= 1000 && mnoznik() <= 100000) {
            rezystancja = paski() * mnoznik() / 1000.0;
            jednostka = "k";
        }
        else if (mnoznik() > 100000) {
            rezystancja = paski() * mnoznik() / 1000000.0;
            jednostka = "M";
        }
        else {
            rezystancja = paski() * mnoznik();
            jednostka = "";
        }
        return "Rezystancja: " + rezystancja + " " +  jednostka + "Ω;" + " Tolerancja: " + "±" + tolerancja() + "%";
    }
}
