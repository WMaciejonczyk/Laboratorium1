import java.util.HashSet;
import java.util.Scanner;

/**
 * Program sprawdzający działanie klas Sets, Subjects, University i Statistics. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Lista5Demo {
    /**
     * Klasa Lista5.Demo
     * @param args badane obiekty i metody klas Sets, Subjects, University i Statistics
     */
    public static void main(String[] args) {
        // Klasa Sets
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        HashSet<Integer> setC = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            setA.add(i);
            setC.add(i);
        }
        for (int i = 7; i < 15; i++) {
            setB.add(i);
        }
        Sets s = new Sets(setA, setB);
        Sets ss = new Sets(setA, setC);
        System.out.println("Zbiór A: " + s.getSetA());
        System.out.println("Zbiór B: " + s.getSetB());
        System.out.println("Zbiór C: " + ss.getSetB());
        System.out.println("Wynik sumy: " + s.Addition());
        System.out.println("Wynik różnicy A\\B: " + s.Substraction(true));
        System.out.println("Wynik różnicy B\\A: " + s.Substraction(false));
        System.out.println("Wynik iloczynu: " + s.Multiplication());
        System.out.println("Wynik różnicy symetrycznej: " + s.SymmetricSubstration());
        System.out.println("Czy dane zbiory (A i B) są równe?: " + s.areEqual());
        System.out.println("Czy dane zbiory (A i C) są równe?: " + ss.areEqual());
        // Klasy Subjects i Univeristy
        Subjects s1 = new Subjects("FZP001064C", "Fizyka 1.3A", 2, 30, Subjects.CompletionType.PASS);
        Subjects s2 = new Subjects("FZP001064W", "Fizyka 1.3A", 5, 45, Subjects.CompletionType.EXAM);
        Subjects s3 = new Subjects("FTP002001W", "Optyka inżynierska", 2, 30, Subjects.CompletionType.EXAM);
        Subjects s4 = new Subjects("MDP001000P", "Anatomia", 3, 60, Subjects.CompletionType.EXAM);
        Subjects s5 = new Subjects("INP001030L", "Pakiety obliczeniowe", 2, 30, Subjects.CompletionType.PASS);
        s1.setCourseCode("FZP001064D");
        University uni = new University();
        uni.addSubject(s1);
        uni.addSubject(s2);
        uni.addSubject(s3);
        uni.addSubject(s4);
        uni.addSubject(s5);
        System.out.println("Mapa przedmiotów uczelni:");
        uni.displayInfoAll();
        System.out.println("Informacje na temat zadanego przedmiotu:");
        uni.displaySubjectInfo("FZP001064D");
        uni.deleteSubject("FZP001064D");
        try {
            uni.displaySubjectInfo("FZP001064D");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        int[] results = uni.getResultsAboutHoursAndECTS("lab");
        System.out.println("Liczba godzin danego typu zajęć: " + results[0]);
        System.out.println("Liczba godzin zajęć kończących się egzaminem: " + results[1]);
        System.out.println("Suma punktów ECTS zajęć kończących się egzaminem: " + results[2]);
        // Klasa Statistics
        System.out.println("Podaj zdanie do analizy:");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        Statistics stat = new Statistics(sentence);
        stat.analyzeWords(true, "nie");
        stat.analyzeCharacters(true, 'M');
        System.out.println("Liczba wystąpień poszczególnych słów: " + stat.getWordOccurrences());
        System.out.println("Liczba wystąpień poszczególnych znaków: " + stat.getCharOccurrences());
        System.out.println("Całkowita liczba słów: " + stat.getTotalWords());
        System.out.println("Całkowita liczba znaków: " + stat.getTotalCharacters());
        System.out.println("Zbiór wyjątkowych słów: " + stat.getWords());
        System.out.println("Zbiór wyjątkowych znaków: " + stat.getCharacters());
    }
}
