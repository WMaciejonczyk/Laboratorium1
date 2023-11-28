import java.util.HashMap;
import java.util.HashSet;

/**
 * Klasa przeprowadzająca statystykę zdania podanego przez użytkownika. <p>
 * Autor: Wojciech Maciejończyk 268337
 */
public class Statistics {
    private String sentence;
    private HashSet<String> words = new HashSet<>();
    private HashSet<Character> characters = new HashSet<>();
    private HashMap<String, Integer> wordOccurrences = new HashMap<>();
    private HashMap<Character, Integer> charOccurrences = new HashMap<>();

    /**
     * Konstruktor przyjmujący jeden parametr
     * @throws IllegalArgumentException gdy zdanie jest puste
     */
    public Statistics(String sentence) {
        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("Podane zdanie jest puste.");
        }
        else {
            this.sentence = sentence.trim();
        }
    }

    /**
     * Metoda tworząca mapę odzwierciedlającą liczbę wystąpień poszczególnych słów w zdaniu podanym przez użytkownika
     */
    public void analyzeWords() {
        String[] words = getSentence().split("\\s+");

        for (String word : words) {
            getWordOccurrences().put(word, getWordOccurrences().getOrDefault(word, 0) + 1);
        }
        for (String word : words) {
            getWords().add(word);
        }
    }

    /**
     * Metoda tworząca mapę odzwierciedlającą liczbę wystąpień poszczególnych znaków w zdaniu podanym przez użytkownika
     */
    public void analyzeCharacters() {
        char[] chars = getSentence().toCharArray();

        for (char character : chars) {
            getCharOccurrences().put(character, getCharOccurrences().getOrDefault(character, 0) + 1);
        }
        for (char character : chars) {
            getCharacters().add(character);
        }
    }

    /**
     * Metoda zwracająca zbiór wszystkich wyjątkowych słów
     * @return zbiór wyjątkowych słów
     */
    public HashSet<String> getWords() {
        return words;
    }

    /**
     * Metoda ustawiająca nowy zbiór wszystkich wyjątkowych słów
     * @param words nowy zbiór wyjątkowych słów
     */
    public void setWords(HashSet<String> words) {
        this.words = words;
    }

    /**
     * Metoda zwracająca zbiór wszystkich wyjątkowych znaków
     * @return zbiór wyjątkowych znaków
     */
    public HashSet<Character> getCharacters() {
        return characters;
    }

    /**
     * Metoda ustawiająca nowy zbiór wszystkich wyjątkowych znaków
     * @param characters nowy zbiór wyjątkowych znaków
     */
    public void setCharacters(HashSet<Character> characters) {
        this.characters = characters;
    }

    /**
     * Metoda zwracająca całkowitą liczbę wszystkich słów
     * @return liczba słów
     */
    public int getTotalWords() {
        return getSentence().split("\\s+").length;
    }

    /**
     * Metoda zwracająca całkowitą liczbę wszystkich znaków
     * @return liczba znaków
     */
    public int getTotalCharacters() {
        return getSentence().length();
    }

    /**
     * Metoda zwracająca zdanie podane przez użytkownika
     * @return zdanie
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Metoda ustawiająca nowe zdanie
     * @param sentence nowe zdanie
     * @throws IllegalArgumentException gdy podane zdanie jest puste
     */
    public void setSentence(String sentence) {
        if (sentence.isEmpty()) {
            throw new IllegalArgumentException("Podane zdanie jest puste.");
        }
        else {
            this.sentence = sentence.trim();
        }
    }

    /**
     * Metoda zwracająca mapę zawierającą informacje o wystąpieniach poszczególnych słów
     * @return mapa zawierająca informacje o wystąpieniach słów
     */
    public HashMap<String, Integer> getWordOccurrences() {
        return wordOccurrences;
    }

    /**
     * Metoda ustawiająca nową mapę wystąpień słów
     * @param wordOccurrences nowa mapa wystąpień słów
     */
    public void setWordOccurrences(HashMap<String, Integer> wordOccurrences) {
        this.wordOccurrences = wordOccurrences;
    }

    /**
     * Metoda zwracająca mapę zawierającą informacje o wystąpieniach poszczególnych znaków
     * @return mapa zawierająca informacje o wystąpieniach znaków
     */
    public HashMap<Character, Integer> getCharOccurrences() {
        return charOccurrences;
    }

    /**
     * Metoda ustawiająca nową mapę wystąpień znaków
     * @param charOccurrences nowa mapa wystąpień znaków
     */
    public void setCharOccurrences(HashMap<Character, Integer> charOccurrences) {
        this.charOccurrences = charOccurrences;
    }
}