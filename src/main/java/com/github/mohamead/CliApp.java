package com.github.mohamead;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import picocli.CommandLine;

@CommandLine.Command(
        name = "beat-the-dealer",
        description = "Command line application (cli) for playing a game of blackjack against a dealer",
        optionListHeading = "@|bold %nOptions|@:%n",
        sortOptions = false,
        header = " __ ___  __ _____  _____ _  _ ___   __  ___  __  _   ___ ___ \n" +
                "|  \\ __|/  \\_   _||_   _| || | __|_| _\\| __|/  \\| | | __| _ \\\n" +
                "| -< _|| /\\ || ||__|| | | >< | _|__| v | _|| /\\ | |_| _|| v /\n" +
                "|__/___|_||_||_|    |_| |_||_|___| |__/|___|_||_|___|___|_|_\\\n",
        footer = "\nDeveloped by Mohamed Adrik"
)
public class CliApp implements Callable<Integer> {

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "output usage information")
    private final Boolean help = false;

    @CommandLine.Option(names = {"-f", "--file"}, description = "file with the deck of cards")
    private File file;

    public static void main(String[] args) {
        final CommandLine commandLine = new CommandLine(new CliApp());
        final CommandLine.Help.Ansi ansi = CommandLine.Help.Ansi.OFF;
        final CommandLine.Help.ColorScheme colorScheme = new CommandLine.Help.ColorScheme.Builder(ansi).build();
        commandLine.setColorScheme(colorScheme);
        commandLine.execute(args);
    }

    @Override
    public Integer call() {
        try {
            final List<Card> cards = FileUtil.getCardsFromFile(file);
            final Deck deck = new Deck(cards);
            final Game blackjack = new Game(deck);
            blackjack.play();
            blackjack.showHands();
        } catch (Exception ex) {
            System.out.println();
            System.out.println("Obs! Something went wrong -> " + ex.getMessage());
            return -1;
        }
        return 0;
    }

}
