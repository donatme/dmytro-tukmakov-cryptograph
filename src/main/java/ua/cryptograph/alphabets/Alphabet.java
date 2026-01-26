package ua.cryptograph.alphabets;

public class Alphabet {
    public static final char[] ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    public static final char[] ALPHABET_CYRILLIC = "АБВГҐДЕЄЖЗИЙІЇКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгґдеєжзиійїклмнопрстуфхцчшщъыьэюя".toCharArray();

    public static boolean isInAlphabet(char ch, char[] alphabet) {
        for (char a : alphabet) {
            if (a == ch) return true;
        }
        return false;
    }
}
