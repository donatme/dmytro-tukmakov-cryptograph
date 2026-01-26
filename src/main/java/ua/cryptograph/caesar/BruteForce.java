package ua.cryptograph.caesar;

public class BruteForce {
    private final CaesarCipher cipher;

    public BruteForce(CaesarCipher cipher) {
        this.cipher = cipher;
    }

    public String crack(String encryptedText) {
        int maxShift = 40;
        String best = encryptedText;
        int bestScore = Integer.MIN_VALUE;

        for (int shift = 0; shift < maxShift; shift++) {
            String candidate = cipher.caesarDecrypt(encryptedText, shift);
            int score = score(candidate);

            if (score > bestScore) {
                bestScore = score;
                best = candidate;
            }
        }
        return best;
    }

    private int score(String text) {
        int score = 0;

        score += count(text, ' ') * 2;

        if (text.contains(" the ")) score += 50;
        if (text.contains(" и ")) score += 50;
        if (text.contains(" що ")) score += 50;

        return score;
    }

    private int count(String text, char ch) {
        int c = 0;
        for (char t : text.toCharArray()) {
            if (t == ch) c++;
        }
        return c;
    }
}
