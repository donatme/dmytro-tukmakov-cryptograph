package ua.cryptograph;

import ua.cryptograph.application.ApplicationFactory;
import ua.cryptograph.application.CryptographApplication;
import ua.cryptograph.cli.CliCommand;
import ua.cryptograph.cli.CliParser;

public class ConsoleRunnerCryptograph {
    static void main(String[] args) {
       // only for tests
        /*String[] arg = {
                "enc",
                "src/main/resources/text.txt",
                "13"
        };*/

        /*String[] arg = {
                "dec",
                "src/main/resources/text[ENCRYPTED].txt",
                "13"
        };*/

        String[] arg = {
                "bf",
                "src/main/resources/text[ENCRYPTED].txt",
        };

        CryptographApplication app = ApplicationFactory.create();
        CliCommand cmd = new CliParser().parse(arg);
        app.run(cmd);
    }
}
