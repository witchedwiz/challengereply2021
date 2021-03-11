package it.reply.challenge.edition2021.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Building {

    Integer x;
    Integer y;
    Integer latencyWeight;
    Integer connSpeedWeight;
}
