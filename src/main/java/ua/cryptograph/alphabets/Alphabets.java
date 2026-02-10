package ua.cryptograph.alphabets;

import java.util.List;
import java.util.Optional;

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

    public static Optional<Alphabet> detect(char ch) {
        for (Alphabet alphabet : ALL) {
            if (alphabet.contains(ch)) {
                return Optional.of(alphabet);
            }
        }
        return Optional.empty();
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
