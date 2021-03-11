package it.reply.challenge.edition2021;

import it.reply.challenge.edition2021.model.Antenna;
import it.reply.challenge.edition2021.model.Building;
import it.reply.challenge.edition2021.model.Cell;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SomeClass {

    public static void main(String[] args) {

        String inputFileName = "data_scenarios_a_example.in";

        if (args.length > 1)
            inputFileName = args[1];

        int w = 0, h = 0,
                buildings = 0,
                antennas = 0;

        Cell[][] grid = null;

        Integer score = null;

        List<Antenna> antennaList = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    SomeClass.class.getResourceAsStream("/" + inputFileName)));
            String line = reader.readLine();
            String[] s = line.split(" ");
            w = Integer.parseInt(s[0]);
            h = Integer.parseInt(s[1]);
            line = reader.readLine();
            String[] s2 = line.split(" ");
            buildings = Integer.parseInt(s2[0]);
            antennas = Integer.parseInt(s2[1]);
            score = Integer.parseInt(s2[2]);

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

        //printGrid(grid);

    }

    private static void printGrid(Cell[][] grid) {

        for(Cell[] cLine : grid) {
            for (Cell c : cLine) {
                System.out.print(c.getBuilding() != null ? "B\t" : ".\t");
            }
            System.out.println();
        }

    }

}
