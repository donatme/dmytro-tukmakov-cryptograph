package ua.cryptograph.cli;

import ua.cryptograph.caesar.BruteForce;
import ua.cryptograph.caesar.CaesarCipher;
import ua.cryptograph.io.FileReader;
import ua.cryptograph.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;

public class CryptographApplication {

    public void run(CliCommand cmd) {
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        CaesarCipher cipher = new CaesarCipher();
        BruteForce bruteForce = new BruteForce();
        Path inputPath = Path.of(cmd.filePath());

        if (!Files.exists(inputPath)) {
            System.out.println("ERROR: input file does not exist: " + inputPath);
            return;
        }
        String inputText = fileReader.read(inputPath.toString());
        String result =null;
        switch (cmd.mode()) {
            case ENCRYPT : result =cipher.caesarEncrypt(inputText, cmd.shift()); break;
            case DECRYPT : result =cipher.caesarDecrypt(inputText, cmd.shift());break;
            case BRUTE_FORCE : result =bruteForce.crack(inputText);break;
        }
        String outputPath = buildOutputPath(cmd.filePath(), cmd.mode());
        fileWriter.write(outputPath, result);
        System.out.println("Result saved to: " + outputPath);
    }

    private String buildOutputPath(String inputPath, Mode mode) {
        int dotIndex = inputPath.lastIndexOf('.');
        if (dotIndex == -1) dotIndex = inputPath.length();
        String name = inputPath.substring(0, dotIndex); //обрезака до точки
        String ext = dotIndex < inputPath.length() ? inputPath.substring(dotIndex) : "";
        name = name.replaceAll("\\[(ENCRYPT|DECRYPT|BRUTFORCE)\\]$", "");
        return name + "[" + mode + "]" + ext;
    }
}

