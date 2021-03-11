package it.reply.challenge.edition2021;

import it.reply.challenge.edition2021.model.Cell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SomeClass {

    public static void main(String[] args) {

        int w = 0, h = 0,
                buildings = 0,
                antennas = 0;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "input"));
            String line = reader.readLine();
            String[] s = line.split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);
            line = reader.readLine();
            buildings = Integer.parseInt(s[0]);
            antennas = Integer.parseInt(s[1]);

            Cell[][] grid = new Cell[w][h];

            for (int i; i < )



            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
