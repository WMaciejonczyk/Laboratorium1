import java.util.Arrays;
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
                String subHours = "Tygodniowa liczba godzin: " + subInfo.getHours() + "\n";
                String subType = "Typ zajęć: " + subInfo.getCourseType().name() + "\n";
                String subForm = "Forma zaliczenia: " + subInfo.getCompletionForm().name() + "\n";
                String info = subCode + subName + subECTS + subHours + subType + subForm;
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
                String subHours = "Tygodniowa liczba godzin: " + subInfo.getHours() + "\n";
                String subType = "Typ zajęć: " + subInfo.getCourseType().name() + "\n";
                String subForm = "Forma zaliczenia: " + subInfo.getCompletionForm() + "\n";
                String info = subCode + subName + subECTS + subHours + subType + subForm;
                System.out.println(info);
            }
        }
        else {
            throw new IllegalArgumentException("Podany przedmiot nie istnieje.");
        }
    }
    /**
     * Metoda podliczająca całkowitą liczbę godzin danego typu zajęć oraz liczbę godzin i sumę punktów ECTS zajęć kończących się egzaminem
     * @param courseTypeName nazwa typu zajęć do podliczenia godzin
     * @return tablica zawierająca liczbę godzin dla danego typu zajęć oraz liczbę godzin i sumę punktów ECTS zajęć kończących się egzaminem
     * @throws IllegalArgumentException gdy podano błędną nazwę typu zajęć
     */
    public int[] getResultsAboutHoursAndECTS(String courseTypeName) {
        String[] viable = {"LECTURE", "EXCERCISES", "LAB", "SEMINAR", "PROJECT", "THESIS", "PRACTICUM", "OTHER"};
        boolean contains = Arrays.asList(viable).contains(courseTypeName.toUpperCase());
        if (courseTypeName.isEmpty() || !contains) {
            throw new IllegalArgumentException("Podano błędną nazwę typu zajęć");
        }
        else {
            Subjects.CourseType courseType = Subjects.CourseType.valueOf(courseTypeName.toUpperCase());
            int[] results = new int[3];
            int totalHoursByCourseType = getSubjectsHashMap().values().stream()
                    .filter(subject -> subject.getCourseType() == courseType)
                    .mapToInt(Subjects::getHours)
                    .sum();
            results[0] = totalHoursByCourseType;

            int totalExamHours = getSubjectsHashMap().values().stream()
                    .filter(subject -> subject.getCompletionForm() == Subjects.CompletionType.EXAM)
                    .mapToInt(Subjects::getHours)
                    .sum();
            results[1] = totalExamHours;

            int totalExamECTS =getSubjectsHashMap().values().stream()
                    .filter(subject -> subject.getCompletionForm() == Subjects.CompletionType.EXAM)
                    .mapToInt(Subjects::getECTS)
                    .sum();
            results[2] = totalExamECTS;
            return results;
        }
    }
}
