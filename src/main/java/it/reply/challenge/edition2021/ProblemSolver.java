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

    public ProblemSolver(int n, int m, List<Building> buildings, List<Antenna> antennaList, Cell[][] grid) {
        N = n;
        M = m;
        this.buildings = buildings;
        this.antennaList = antennaList;
        this.grid = grid;
        this.antennas = (Antenna[]) antennaList.toArray();

        this.maxScore = 0;
    }

    public void solve(int level) {

        if(level == antennaList.size()) {
            //Condizione terminale, ho allocato tutte le antenne => calcolo punteggio
            Integer score = evaluateScore();
            if(score > maxScore) {
                maxScore = score;
                //cloneGrid();
                System.out.println("Found max score");
                printGrid();
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
                if(antennaReachesBuilding(antennas[level]));

                solve(level+1);

                grid[i][j].setAntenna(null);
                antennas[level].setX(null);
                antennas[level].setY(null);

            }
        }
    }

    public boolean antennaReachesBuilding(Antenna a) {
        for(int i = a.getX()-a.getRange(); i < a.getX()+a.getRange(); i++) {
            for(int j = a.getY()-a.getRange(); i < a.getY()+a.getRange(); j++) {
                if((i < 0 ) || (j < 0)) {
                    continue;
                }

                if(grid[i][j].getBuilding() != null) {
                    return true;
                }
            }
        }

        return false;
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

    private void cloneGrid() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                gridMaxScore[i][j] = grid[i][j]; //Doesn't work, needs to make a copy of the objects (thanks Java)
            }
        }
    }

    private void printGrid() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(grid[i][j].getBuilding() != null) {
                    System.out.println("B");
                }
                if(grid[i][j].getAntenna() != null) {
                    System.out.println("A");
                }

                System.out.println(" ");
            }
            System.out.println("\n");
        }
    }
}
