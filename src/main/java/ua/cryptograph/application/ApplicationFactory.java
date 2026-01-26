package ua.cryptograph.application;

import ua.cryptograph.caesar.BruteForce;
import ua.cryptograph.caesar.CaesarCipher;
import ua.cryptograph.io.FileReader;
import ua.cryptograph.io.FileWriter;

public class ApplicationFactory {

    public static CryptographApplication create() {
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        CaesarCipher cipher = new CaesarCipher();
        BruteForce bruteForce = new BruteForce(cipher);

        return new CryptographApplication(fileReader, fileWriter, cipher, bruteForce);
    }

    private ApplicationFactory() {
    }
}
