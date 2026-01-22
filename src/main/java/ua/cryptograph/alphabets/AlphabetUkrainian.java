package ua.cryptograph.alphabets;

import java.util.ArrayList;
import java.util.List;

public class AlphabetUkrainian {
    private final List<Character> alphabet = new ArrayList<>();

    public AlphabetUkrainian() {
        for (char c = 'А'; c <= 'Я'; c++) alphabet.add(c);
        for (char c = 'а'; c <= 'я'; c++) alphabet.add(c);
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }
}