package ua.cryptograph;

import ua.cryptograph.application.ApplicationFactory;
import ua.cryptograph.cli.CliCommand;
import ua.cryptograph.cli.CliParser;
import ua.cryptograph.application.CryptographApplication;

public class ConsoleRunnerCryptograph {
    static void main(String[] args) {

        CryptographApplication app = ApplicationFactory.create();
        CliCommand cmd = new CliParser().parse(args);
        app.run(cmd);
    }
}
