package ua.cryptograph.alphabets;

import java.util.ArrayList;
import java.util.List;

public class AlphabetEnglish {
    private final List<Character> alphabet = new ArrayList<>();

    public AlphabetEnglish() {
        for (char c = 'A'; c <= 'Z'; c++) alphabet.add(c);
        for (char c = 'a'; c <= 'z'; c++) alphabet.add(c);
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }
}