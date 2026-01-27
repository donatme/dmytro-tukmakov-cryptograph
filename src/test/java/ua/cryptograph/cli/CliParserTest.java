package ua.cryptograph.cli;

import org.junit.jupiter.api.Test;
import ua.cryptograph.application.Mode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CliParserTest {

    @Test
    void encryptArgsParsedCorrectly() {
        String[] args = {"enc", "text.txt", "13"};
        CliCommand cmd = new CliParser().parse(args);
        assertEquals(Mode.ENCRYPTED, cmd.mode());
        assertEquals("text.txt", cmd.filePath());
        assertEquals(13, cmd.shift());
    }

    @Test
    void decryptArgsParsedCorrectly() {
        String[] args = {"dec", "text[ENCRYPTED].txt", "13"};
        CliCommand cmd = new CliParser().parse(args);
        assertEquals(Mode.DECRYPTED, cmd.mode());
        assertEquals(13, cmd.shift());
    }

    @Test
    void bruteforceArgsParsedCorrectly() {
        String[] args = {"bf", "text[ENCRYPTED].txt"};
        CliCommand cmd = new CliParser().parse(args);
        assertEquals(Mode.BRUTEFORCE, cmd.mode());
        assertNull(cmd.shift());
    }
}
