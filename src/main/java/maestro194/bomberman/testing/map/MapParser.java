package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.GameEngine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class MapParser<Entity> implements IMapParser<Entity> {
    public List<List<Entity>> parse(String file) {
        List<List<Entity>> res = new ArrayList<>();

        InputStream map = getClass().getResourceAsStream(file);

        try (Scanner scanner = new Scanner(Objects.requireNonNull(map))) {
            // read level
            GameEngine.WIDTH = scanner.nextInt();
            GameEngine.HEIGHT = scanner.nextInt();
            scanner.nextLine();

            String line;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                List<Entity> row = new ArrayList<>();
                int length = line.length();
                for (int i = 0; i < length; i++)
                    row.add(parseEntity(line.charAt(i)));
                res.add(row);
            }
        } catch (Exception e) {
            throw new RuntimeException("File loading error.");
        }
        return res;
    }

    protected abstract String charConv(char charAt);
    protected abstract Entity parseEntity(char charAt);

}
