/**
 * Klasa tworząca obiekty reprezentujące przedmioty uczelniane. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Subjects {
    public enum CourseType {
        LECTURE,
        EXCERCISES,
        LAB,
        SEMINAR,
        PROJECT,
        THESIS,
        PRACTICUM,
        OTHER
    }

    public enum CompletionType {
        EXAM,
        PASS
    }
    private String courseCode;
    private String courseName;
    private int ECTS;
    private int hours;
    private CourseType courseType;
    private CompletionType completionForm;

    /**
     * Konstruktor przyjmujący pięć parametrów
     * @param courseCode kod przedmiotu
     * @param courseName nazwa przedmiotu
     * @param ECTS liczba punktów ECTS
     * @param hours wymiar godzinowy przedmiotu
     * @param completionForm forma zaliczenia przedmiotu
     * @throws IllegalArgumentException gdy kod, nazwa lub forma zaliczenia są puste lub ECTS < 0 lub hours <= 0
     * lub formą zaliczenia nie jest ani "pass", ani "exam" lub gdy kod nie odpowiada żadnemu typowi zajęć
     */
    public Subjects(String courseCode, String courseName, int ECTS, int hours, CompletionType completionForm) {
        if (courseCode.isEmpty()) {
            throw new IllegalArgumentException("Podany kod przedmiotu jest pusty.");
        }
        else {
            char c = courseCode.toUpperCase().charAt(courseCode.length()-1);
            char[] viable = {'W', 'C', 'L', 'S', 'P', 'D', 'Q', 'K'};
            boolean contains = new String(viable).contains(String.valueOf(c));
            if (courseName.isEmpty() || ECTS < 0 || hours <= 0 || !contains
                    || (!completionForm.name().equalsIgnoreCase("exam") && !completionForm.name().equalsIgnoreCase("pass"))) {
                throw new IllegalArgumentException("Informacje przedmiotu są niepoprawne.");
            }
            else {
                this.courseCode = courseCode.toUpperCase();
                this.courseName = courseName;
                this.ECTS = ECTS;
                this.hours = hours;
                this.completionForm = completionForm;
                setCourseTypeFromCourseCode();
            }
        }
    }

    /**
     * Metoda pozwalająca na ustalenie typu zajęć na podstawie kodu przedmiotu
     * @throws IllegalArgumentException gdy kod przedmiotu nie odpowiada żadnemu typowi zajęć
     */
    private void setCourseTypeFromCourseCode() {
        char lastChar = courseCode.charAt(courseCode.length() - 1);

        switch (lastChar) {
            case 'W' -> this.courseType = CourseType.LECTURE;
            case 'C' -> this.courseType = CourseType.EXCERCISES;
            case 'L' -> this.courseType = CourseType.LAB;
            case 'S' -> this.courseType = CourseType.SEMINAR;
            case 'P' -> this.courseType = CourseType.PROJECT;
            case 'D' -> this.courseType = CourseType.THESIS;
            case 'Q' -> this.courseType = CourseType.PRACTICUM;
            case 'K' -> {
                char secondLastChar = courseCode.charAt(courseCode.length() - 2);
                if (secondLastChar == 'B') {
                    this.courseType = CourseType.OTHER;
                } else {
                    throw new IllegalArgumentException("Błędny kod przedmiotu.");
                }
            }
            default -> throw new IllegalArgumentException("Błędny kod przedmiotu.");
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
            char[] viable = {'W', 'C', 'L', 'S', 'P', 'D', 'Q'};
            boolean contains = new String(viable).contains(String.valueOf(c));
            if (!contains) {
                throw new IllegalArgumentException("Podano niepoprawny kod przedmiotu.");
            }
            else {
                this.courseCode = courseCode;
                setCourseType();
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
     * Metoda zwracająca wymiar godzinowy przedmiotu
     * @return wymiar godzinowy przedmiotu
     */
    public int getHours() {
        return hours;
    }

    /**
     * Metoda ustawiająca nowy wymiar godzinowy przedmiotu
     * @param hours nowy wymiar godzinowy przedmiotu
     * @throws IllegalArgumentException gdy hours <= 0
     */
    public void setHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Podana liczba jest mniejsza lub równa 0.");
        }
        else {
            this.hours = hours;
        }
    }

    /**
     * Metoda zwracająca typ zajęć przedmiotu
     * @return typ zajęć
     */
    public CourseType getCourseType() {
        return courseType;
    }

    /**
     * Metoda ustawiająca nowy typ zajęć przedmiotu
     */
    public void setCourseType() {
        setCourseTypeFromCourseCode();
    }

    /**
     * Metoda zwracająca formę zaliczenia przedmiotu
     * @return forma zaliczenia przedmiotu
     */
    public CompletionType getCompletionForm() {
        return completionForm;
    }

    /**
     * Metoda ustawiająca nową formę zaliczenia przedmiotu
     * @param completionForm nowa forma zaliczenia przedmiotu
     * @throws IllegalArgumentException gdy completionForm nie oznacza ani egzaminu, ani zaliczenia
     */
    public void setCompletionForm(CompletionType completionForm) {
        if (!completionForm.name().equalsIgnoreCase("exam") && !completionForm.name().equalsIgnoreCase("pass")) {
            throw new IllegalArgumentException("Podano błędną formę zaliczenia.");
        }
        else {
            this.completionForm = completionForm;
        }
    }
}
