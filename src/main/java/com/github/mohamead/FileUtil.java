package com.github.mohamead;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

final class FileUtil {

    private static final String tokenRegex = "(" + Suite.getRegex() +  Face.getRegex() + ")";
    private static final Pattern tokenPattern = Pattern.compile(tokenRegex);

    static List<Card> getCardsFromFile(File file) {
        if (file == null) return new ArrayList<>();
        if (!file.isFile()) {
            throw new IllegalArgumentException("Invalid file found \"" + file.getName() + "\", please try again!");
        }
        final List<Card> cardsFromFile = new ArrayList<>();
        try (final Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                final String token = scanner.next().toUpperCase().trim();
                if (!tokenPattern.matcher(token).matches()) {
                    throw new IllegalArgumentException("Invalid token found \"" + token + "\", please try again!");
                }
                final String suite = token.substring(0, 1);
                final String face = token.substring(1);
                cardsFromFile.add(new Card(Suite.of(suite), Face.of(face)));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
        if (cardsFromFile.isEmpty()) {
            throw new IllegalArgumentException("No token(s) found in \"" + file.getName() + "\", please try again!");
        }
        return cardsFromFile;
    }

}
