package maestro194.bomberman.testing.map;

import maestro194.bomberman.testing.GameEngine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MapParser<Entity> {
    public List<List<Entity>> parse(File file) {
        List<List<Entity>> res = new ArrayList<>();
        if (file == null || !file.isFile()) {
            throw new IllegalArgumentException("Not a valid file: " + file);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            String line;
            GameEngine.WIDTH = br.read();
            GameEngine.HEIGHT = br.read();
            while((line = br.readLine()) != null) {
                List<Entity> row = new ArrayList<>();
                int length = line.length();
                if(length == 0)
                    continue;
                for(int i = 0; i < length; i ++)
                    row.add(parseEntity(line.charAt(i)));
                res.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error in reading map file", e);
        }

        return res;
    }

    protected abstract Entity parseEntity(char charAt);
}
