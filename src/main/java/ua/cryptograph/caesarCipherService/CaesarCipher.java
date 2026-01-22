package ua.cryptograph.caesarCipherService;

import ua.cryptograph.alphabets.AlphabetEnglish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaesarCipher {

    public String caesarEncrypt(String input, int shift) {
        AlphabetEnglish alphabet = new AlphabetEnglish();
        List<Character> alphabetList = alphabet.getAlphabet();
        List<Character> copy = new ArrayList<>(alphabetList);
        if (shift > 0) {
            shift = -shift;
        }
        Collections.rotate(copy, shift);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (copy.contains(ch)) {
                char c = copy.get(alphabetList.indexOf(ch));
                sb.append(c);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}