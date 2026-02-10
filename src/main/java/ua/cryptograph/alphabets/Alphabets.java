package ua.cryptograph.alphabets;

import java.util.List;

public final class Alphabets {

    public static final Alphabet EN = new Alphabet(
            "EN", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

    public static final Alphabet CYRILLIC = new Alphabet(
            "CYRILLIC", "АБВГҐДЕЄЖЗИЙІЇКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгґдеєжзиійїклмнопрстуфхцчшщъыьэюя");

    public static final Alphabet SYMBOLS = new Alphabet(
            "SYMBOLS", ".,«»\"':!? 1234567890");

    private static final List<Alphabet> ALL = List.of(EN, CYRILLIC, SYMBOLS);

    private Alphabets() {
    }

    public static Alphabet detect(char ch) {
        for (Alphabet alphabet : ALL) {
            if (alphabet.contains(ch)) {
                return alphabet;
            }
        }
        return null;
    }

    public static int maxLength() {
        int max = 0;
        for (Alphabet alphabet : ALL) {
            if (alphabet.length() > max) {
                max = alphabet.length();
            }
        }
        return max;
    }
}
