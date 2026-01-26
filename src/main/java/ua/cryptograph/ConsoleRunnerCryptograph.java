package ua.cryptograph;

import ua.cryptograph.cli.CliCommand;
import ua.cryptograph.cli.CliParser;
import ua.cryptograph.cli.CryptographApplication;

public class ConsoleRunnerCryptograph {
    public static void main(String[] args) {

        CliCommand command = new CliParser().parse(args);
        new CryptographApplication().run(command);

    }
}
