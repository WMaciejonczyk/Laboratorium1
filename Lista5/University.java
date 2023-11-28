import java.util.HashMap;

/**
 * Klasa tworząca i operująca na mapie zawierającej informacje o przedmiotach na uczelni. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class University {
    private HashMap<String, Subjects> subjectsHashMap = new HashMap<>();

    /**
     * Konstruktor domyślny
     */
    public University() {}

    /**
     * Metoda zwracająca mapę przedmiotów
     * @return mapa przedmiotów
     */
    public HashMap<String, Subjects> getSubjectsHashMap() {
        return subjectsHashMap;
    }

    /**
     * Metoda ustawiająca nową mapę przedmiotów
     * @param subjectsHashMap nowa mapa przedmiotów
     */
    public void setSubjectsHashMap(HashMap<String, Subjects> subjectsHashMap) {
        this.subjectsHashMap = subjectsHashMap;
    }

    /**
     * Metoda dodająca nowy przedmiot do mapy
     * @param s przedmiot
     */
    public void addSubject (Subjects s) {
        getSubjectsHashMap().put(s.getCourseCode(), s);
    }

    /**
     * Metoda usuwająca podany przedmiot
     * @param key klucz danego przedmiotu
     * @throws IllegalArgumentException gdy podany klucz nie istnieje
     */
    public void deleteSubject (String key) {
        if (getSubjectsHashMap().containsKey(key)) {
            getSubjectsHashMap().remove(key);
        }
        else {
            throw new IllegalArgumentException("Podany klucz nie istnieje w mapie.");
        }
    }

    /**
     * Metoda wyświetlająca informacje o wszystkich przedmiotach w mapie
     * @throws IllegalArgumentException gdy mapa jest pusta
     */
    public void displayInfoAll() {
        if (getSubjectsHashMap().isEmpty()) {
            throw new IllegalArgumentException("Uczelnia nie posiada żadnych przedmiotów.");
        }
        else {
            HashMap<String, String> university = new HashMap<>();
            getSubjectsHashMap().forEach((key, subInfo) -> {
                String subCode = "Kod: " + subInfo.getCourseCode() + "\n";
                String subName = "Nazwa: " + subInfo.getCourseName() + "\n";
                String subECTS = "Punkty ECTS: " + subInfo.getECTS() + "\n";
                String subHours = "Tygodniowa liczba godzin: " + subInfo.getWeeklyHours() + "\n";
                String subForm = "Forma zaliczenia: " + subInfo.getCompletionForm() + "\n";
                String info = subCode + subName + subECTS + subHours + subForm;
                university.put(key, info);
            });
            System.out.println(university.values());
        }
    }

    /**
     * Metoda wyświetlająca informacje o podanym przedmiocie
     * @param key klucz przedmiotu
     * @throws IllegalArgumentException gdy mapa jest pusta lub podany przedmiot nie istnieje w mapie
     */
    public void displaySubjectInfo(String key) {
        if (getSubjectsHashMap().containsKey(key)) {
            if (getSubjectsHashMap().isEmpty()) {
                throw new IllegalArgumentException("Uczelnia nie posiada żadnych przedmiotów.");
            }
            else {
                Subjects subInfo = getSubjectsHashMap().get(key);
                String subCode = "Kod: " + subInfo.getCourseCode() + "\n";
                String subName = "Nazwa: " + subInfo.getCourseName() + "\n";
                String subECTS = "Punkty ECTS: " + subInfo.getECTS() + "\n";
                String subHours = "Tygodniowa liczba godzin: " + subInfo.getWeeklyHours() + "\n";
                String subForm = "Forma zaliczenia: " + subInfo.getCompletionForm() + "\n";
                String info = subCode + subName + subECTS + subHours + subForm;
                System.out.println(info);
            }
        }
        else {
            throw new IllegalArgumentException("Podany przedmiot nie istnieje.");
        }
    }
}
