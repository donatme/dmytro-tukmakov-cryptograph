package ua.cryptograph.alphabets;

public class Alphabet {
    public static final char[] alphabet_en = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    public static final char[] alphabet_cyrillic = "АБВГҐДЕЄЖЗИЙІЇКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгґдеєжзиійїклмнопрстуфхцчшщъыьэюя".toCharArray();

    public static boolean isInAlphabet(char ch, char[] alphabet) {
        for (char a : alphabet) {
            if (a == ch) return true;
        }
        return false;
    }
}
