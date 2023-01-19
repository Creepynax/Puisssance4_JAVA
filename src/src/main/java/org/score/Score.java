package org.score;

import java.io.IOException;
import java.util.Date;
import java.io.*;

public class Score {
    public static void createScoreFile(String player, int turn, Date date) {
        File f = new File("score.txt");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f, true);
            fw.write("Nom du gagnant : " + player + "\n");
            fw.write("Score : " + turn + "\n");
            fw.write("Date : " + date + "\n");
            fw.write("-------------------\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void afficheScore(){
        try {
            FileReader fr = new FileReader("score.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
