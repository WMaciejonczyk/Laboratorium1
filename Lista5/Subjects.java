/**
 * Klasa tworząca obiekty reprezentujące predmioty uczelniane. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Subjects {
    private String courseCode;
    private String courseName;
    private int ECTS;
    private int weeklyHours;
    private String completionForm;

    /**
     * Konstruktor przyjmujący pięć parametrów
     * @param courseCode kod przedmiotu
     * @param courseName nazwa przedmiotu
     * @param ECTS liczba punktów ECTS
     * @param weeklyHours tygodniowa liczba godzin przedmiotu
     * @param completionForm forma zaliczenia przedmiotu
     * @throws IllegalArgumentException gdy kod, nazwa lub forma zaliczenia są puste lub ECTS < 0 lub weeklyHours <= 0
     * lub formą zaliczenia nie jest ani "pass" ani "exam" lub ostatnim znakiem w kodzie nie jest litera W/C/L
     */
    public Subjects(String courseCode, String courseName, int ECTS, int weeklyHours, String completionForm) {
        if (courseCode.isEmpty() || courseName.isEmpty() || ECTS < 0 || weeklyHours <= 0 || completionForm.isEmpty()
            || (!completionForm.equalsIgnoreCase("exam") && !completionForm.equalsIgnoreCase("pass"))
            || (courseCode.toUpperCase().charAt(courseCode.length()-1) != 'W'
                && courseCode.toUpperCase().charAt(courseCode.length()-1) != 'C'
                && courseCode.toUpperCase().charAt(courseCode.length()-1) != 'L')) {
            throw new IllegalArgumentException("Informacje przedmiotu są niepoprawne.");
        }
        else {
            this.courseCode = courseCode.toUpperCase();
            this.courseName = courseName;
            this.ECTS = ECTS;
            this.weeklyHours = weeklyHours;
            this.completionForm = completionForm.toLowerCase();
        }
    }

    /**
     * Metoda zwracająca kod przedmiotu
     * @return kod przedmiotu
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Metoda ustawiająca nowy kod przedmiotu
     * @param courseCode nowy kod przedmiotu
     * @throws IllegalArgumentException gdy kod jest pusty lub jego ostatnim znakiem nie jest W/C/L
     */
    public void setCourseCode(String courseCode) {
        if (courseCode.isEmpty()) {
            throw new IllegalArgumentException("Podany kod przedmiotu jest pusty.");
        }
        else {
            char c = courseCode.toUpperCase().charAt(courseCode.length()-1);
            if (c != 'W' && c != 'C' && c != 'L') {
                throw new IllegalArgumentException("Podano niepoprawny kod przedmiotu.");
            }
            else {
                this.courseCode = courseCode;
            }
        }
    }

    /**
     * Metoda zwracająca nazwę przedmiotu
     * @return nazwę przedmiotu
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Metoda ustawiająca nową nazwę przedmiotu
     * @param courseName nowa nazwa przedmiotu
     * @throws IllegalArgumentException gdy nowa nazwa jest pusta
     */
    public void setCourseName(String courseName) {
        if (courseCode.isEmpty()) {
            throw new IllegalArgumentException("Podana nazwa jest pusta.");
        }
        else {
            this.courseName = courseName;
        }
    }

    /**
     * Metoda zwracająca liczbę punktów ECTS
     * @return liczba punktów ECTS
     */
    public int getECTS() {
        return ECTS;
    }

    /**
     * Metoda ustawiająca nową liczbę punktów ECTS
     * @param ECTS nowa liczba punktów ECTS
     * @throws IllegalArgumentException gdy ECTS < 0
     */
    public void setECTS(int ECTS) {
        if (ECTS < 0) {
            throw new IllegalArgumentException("Liczba ECTS nie może być ujemna.");
        }
        else {
            this.ECTS = ECTS;
        }
    }

    /**
     * Metoda zwracająca tygodniową liczbę godzin przedmiotu
     * @return tygodniowa liczba godzin przedmiotu
     */
    public int getWeeklyHours() {
        return weeklyHours;
    }

    /**
     * Metoda ustawiająca nową tygodniową liczbę godzin przedmiotu
     * @param weeklyHours nowa tygodniowa liczba godzin przedmiotu
     * @throws IllegalArgumentException gdy weeklyHours <= 0
     */
    public void setWeeklyHours(int weeklyHours) {
        if (weeklyHours <= 0) {
            throw new IllegalArgumentException("Podana liczba jest mniejsza lub równa 0.");
        }
        else {
            this.weeklyHours = weeklyHours;
        }
    }

    /**
     * Metoda zwracająca formę zaliczenia przedmiotu
     * @return forma zaliczenia przedmiotu
     */
    public String getCompletionForm() {
        return completionForm;
    }

    /**
     * Metoda ustawiająca nową formę zaliczenia przedmiotu
     * @param completionForm nowa forma zaliczenia przedmiotu
     * @throws IllegalArgumentException gdy completionForm nie oznacza ani egzaminu, ani zaliczenia
     */
    public void setCompletionForm(String completionForm) {
        if (!completionForm.equalsIgnoreCase("exam") && !completionForm.equalsIgnoreCase("pass")) {
            throw new IllegalArgumentException("Podano błędną formę zaliczenia.");
        }
        else {
            this.completionForm = completionForm;
        }
    }
}
