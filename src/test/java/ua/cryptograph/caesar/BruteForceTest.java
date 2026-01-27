package ua.cryptograph.caesar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BruteForceTest {

    @Test
    void bruteForceFindsCorrectShift() {
        CaesarCipher cipher = new CaesarCipher();
        BruteForce bruteForce = new BruteForce(cipher);

        String original = "Lorem Ipsum 1 is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer " +
                "took a galley of type and scrambled it to make a type specimen book. It has survived not only five " +
                "centuries, but also the leap into electronic typesetting, remaining essentially unchanged.";
        String encrypted = cipher.caesarEncrypt(original, 13);

        String decrypted = bruteForce.crack(encrypted);

        assertEquals(original, decrypted);
        assertEquals(13, bruteForce.getBestShift());
    }
}
