package it.reply.challenge.edition2021;

import it.reply.challenge.edition2021.model.Antenna;
import it.reply.challenge.edition2021.model.Building;
import it.reply.challenge.edition2021.model.Cell;

import java.util.ArrayList;
import java.util.List;

public class ProblemSolver {

    int N, M;
    List<Building> buildings;
    List<Antenna> antennaList;
    Cell[][] grid;
    Antenna[] antennas;

    int maxScore;
    Cell[][] gridMaxScore;

    public ProblemSolver(int n, int m, List<Antenna> antennaList, Cell[][] grid) {
        N = n;
        M = m;
        this.antennaList = antennaList;
        this.grid = grid;
        this.antennas = (Antenna[]) antennaList.toArray();
    }

    public void solve(int level) {

        if(level == antennaList.size()) {
            //Condizione terminale, ho allocato tutte le antenne => calcolo punteggio
            int score = evaluateScore();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {

                if(!isFreeCell(i,j)) {
                    continue;
                }

                //Assegno
                grid[i][j].setAntenna(antennas[level]);
                antennas[level].setX(i);
                antennas[level].setY(j);

                solve(level+1);

                grid[i][j].setAntenna(null);
                antennas[level].setX(null);
                antennas[level].setY(null);

            }
        }

    }

    public int evaluateScore() {

        for(Building b : buildings) {
            List<Integer> scores = new ArrayList<>();
            for(Antenna a : antennas) {
                Integer dist = Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
                Integer score = (b.getConnSpeedWeight() * a.getConnSpeed()) - (b.getLatencyWeight() + dist);
                scores.add(score);
            }
            Integer maxSCore = scores.stream().max((o1, o2) -> o2 - o1).get();
        }

        return 0;
    }

    public boolean isFreeCell(int x, int y) {
        return grid[x][y].getAntenna() == null;
    }
}
