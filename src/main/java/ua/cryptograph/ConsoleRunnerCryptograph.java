package ua.cryptograph;

import ua.cryptograph.application.ApplicationFactory;
import ua.cryptograph.application.CryptographApplication;
import ua.cryptograph.cli.CliCommand;
import ua.cryptograph.cli.CliParser;

public class ConsoleRunnerCryptograph {
    public static void main(String[] args) {
        CryptographApplication app = ApplicationFactory.create();
        CliCommand cmd = new CliParser().parse(args);
        app.run(cmd);
    }
}
