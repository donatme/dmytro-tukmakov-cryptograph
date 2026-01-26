package ua.cryptograph.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String read(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("File path must not be empty");
        }
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot read file: " + filePath, e);
        }
    }
}