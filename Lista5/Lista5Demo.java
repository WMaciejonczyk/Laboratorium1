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
        Subjects s1 = new Subjects("FZP001064C", "Fizyka 1.3A", 2, 30, "pass");
        Subjects s2 = new Subjects("FZP001064W", "Fizyka 1.3A", 5, 45, "exam");
        University uni = new University();
        uni.addSubject(s1);
        uni.addSubject(s2);
        System.out.println("Mapa przedmiotów uczelni:");
        uni.displayInfoAll();
        System.out.println("Informacje na temat zadanego przedmiotu:");
        uni.displaySubjectInfo("FZP001064C");
        uni.deleteSubject("FZP001064C");
        try {
            uni.displaySubjectInfo("FZP001064C");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // Klasa Statistics
        System.out.println("Podaj zdanie do analizy:");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        Statistics stat = new Statistics(sentence);
        stat.analyzeWords();
        stat.analyzeCharacters();
        System.out.println("Liczba wystąpień poszczególnych słów: " + stat.getWordOccurrences());
        System.out.println("Liczba wystąpień poszczególnych znaków: " + stat.getCharOccurrences());
        System.out.println("Całkowita liczba słów: " + stat.getTotalWords());
        System.out.println("Całkowita liczba znaków: " + stat.getTotalCharacters());
        System.out.println("Zbiór wyjątkowych słów: " + stat.getWords());
        System.out.println("Zbiór wyjątkowych znaków: " + stat.getCharacters());
    }
}