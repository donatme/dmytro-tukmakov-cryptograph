package ua.cryptograph.caesar;

import ua.cryptograph.alphabets.Alphabet;

public class UniversalShifter {
    public String applyShift(String input, int shift) {
        if (input == null || input.isEmpty()) return input;
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Alphabet.isInAlphabet(ch, Alphabet.alphabet_en)) {
                sb.append(shiftChar(ch, shift, Alphabet.alphabet_en));
            } else if (Alphabet.isInAlphabet(ch, Alphabet.alphabet_cyrillic)) {
                sb.append(shiftChar(ch, shift, Alphabet.alphabet_cyrillic));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    private char shiftChar(char ch, int shift, char[] alphabet) {
        int idx = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == ch) {
                idx = i;
                break;
            }
        }
        int newIdx = (idx + shift + alphabet.length) % alphabet.length;
        return alphabet[newIdx];
    }
}
