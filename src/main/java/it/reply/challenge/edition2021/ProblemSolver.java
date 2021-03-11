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

    public ProblemSolver(int n, int m, List<Building> buildings, List<Antenna> antennaList, Cell[][] grid, int maxScore, Cell[][] gridMaxScore) {
        N = n;
        M = m;
        this.buildings = buildings;
        this.antennaList = antennaList;
        this.grid = grid;
        this.antennas = (Antenna[]) antennaList.toArray();
        this.maxScore = maxScore;
        this.gridMaxScore = gridMaxScore;
    }

    public void solve(int level) {

        if(level == antennaList.size()) {
            //Condizione terminale, ho allocato tutte le antenne => calcolo punteggio
            Integer score = evaluateScore();
            if(score > maxScore) {
                maxScore = score;
            }
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

                //considerare se ha senso così

                solve(level+1);

                grid[i][j].setAntenna(null);
                antennas[level].setX(null);
                antennas[level].setY(null);

            }
        }

    }

    public Integer evaluateScore() {

        List<Integer> buildingScores = new ArrayList<>();
        for(Building b : buildings) {
            List<Integer> scores = new ArrayList<>();
            for(Antenna a : antennas) {
                Integer dist = Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
                Integer score = (b.getConnSpeedWeight() * a.getConnSpeed()) - (b.getLatencyWeight() + dist);
                scores.add(score);
            }
            Integer buildingScore = scores.stream().max((o1, o2) -> o2 - o1).get();
            buildingScores.add(buildingScore);
        }

        Integer finalScore = buildingScores.stream().reduce(0, Integer::sum);

        return finalScore;
    }

    public boolean isFreeCell(int x, int y) {
        return grid[x][y].getAntenna() == null;
    }
}
