package it.reply.challenge.edition2021.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cell {

    Integer x;
    Integer y;
    Antenna antenna;
    Building building;
}
