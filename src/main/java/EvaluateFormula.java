import it.reply.challenge.edition2021.model.Antenna;
import it.reply.challenge.edition2021.model.Building;

import java.util.ArrayList;
import java.util.List;

public class EvaluateFormula {


    public static void pairElaboration(List<Building> buildingsList, List<Antenna> antennaeList,
            int maxX, int maxY) {

        List<Object> scoreList = new ArrayList<>();
        for (int i = 0; i < maxX; i++) {
            for (int y = 0; y < maxY; y++) {
                for (Building aBuilding : buildingsList) {
                    for (Antenna aAntenna : antennaeList) {
                        aAntenna.setX(i);
                        aAntenna.setY(y);
                        Integer distance = Math.abs(aAntenna.getX() - aBuilding.getX()) + Math.abs(aAntenna.getY() - aBuilding.getY());
                        Integer score = (aBuilding.getConnSpeedWeight() * aAntenna.getConnSpeed()) - (aBuilding.getLatencyWeight() * distance);
                        scoreList.add(score);
                    }
                }
            }
        }

    }
}
