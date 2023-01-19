package org.score;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Score {

    public static void createScoreFile(String player, int turn, Date) {
        File f = new File("score.txt");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f, true);
            fw.write("Nom du gagnant : " + player + "\n");
            fw.write("Score : " + turn + "\n");
            fw.write("Date : " + Date + "\n");
            fw.write("-------------------\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




