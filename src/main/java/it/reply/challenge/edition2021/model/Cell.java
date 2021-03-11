package it.reply.challenge.edition2021.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {

    int x;
    int y;
    Antenna antenna;
    Building building;
}
