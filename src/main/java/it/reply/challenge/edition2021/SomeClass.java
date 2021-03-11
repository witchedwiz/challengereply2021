package it.reply.challenge.edition2021;

import it.reply.challenge.edition2021.model.Antenna;
import it.reply.challenge.edition2021.model.Building;
import it.reply.challenge.edition2021.model.Cell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SomeClass {

    public static void main(String[] args) {

        int w = 0, h = 0,
                buildings = 0,
                antennas = 0;

        Cell[][] grid = null;

        List<Antenna> antennaList = new ArrayList<>();

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

             grid = new Cell[w][h];

            for (int i = 0; i < buildings; i++) {
                line = reader.readLine();
                String[] s1 = line.split(" ");
                int x = Integer.parseInt(s1[0]),
                y = Integer.parseInt(s1[1]);
                grid[x][y] = new Cell(x,y,null,new Building(x,y,
                        Integer.parseInt(s1[2]),
                        Integer.parseInt(s1[3])));
            }

            for (int i = 0; i < antennas; i++) {
                line = reader.readLine();
                String[] s1 = line.split(" ");
                antennaList.add(new Antenna(i,null,null,Integer.parseInt(s1[0]),Integer.parseInt(s1[1])));
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
