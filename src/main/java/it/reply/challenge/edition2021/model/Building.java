package it.reply.challenge.edition2021.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Building {

    int x;
    int y;
    Integer latencyWeight;
    Integer connSpeedWeight;
}
