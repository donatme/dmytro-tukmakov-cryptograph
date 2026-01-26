package ua.cryptograph.alphabets;

import java.util.List;

public final class Alphabets {

    public static final Alphabet EN = new Alphabet(
            "EN",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    );

    public static final Alphabet CYRILLIC = new Alphabet(
            "CYRILLIC",
            "АБВГҐДЕЄЖЗИЙІЇКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгґдеєжзиійїклмнопрстуфхцчшщъыьэюя"
    );

    private static final List<Alphabet> ALL = List.of(EN, CYRILLIC);

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
}
