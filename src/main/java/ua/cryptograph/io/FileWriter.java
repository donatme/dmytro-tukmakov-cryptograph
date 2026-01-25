package ua.cryptograph.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {

    public void write(String path, String content) {
        try {
            Path output = Path.of(path);
            Path parent = output.getParent();
            if (parent != null) Files.createDirectories(parent);
            Files.writeString(output, content);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + path, e);
        }
    }
}
