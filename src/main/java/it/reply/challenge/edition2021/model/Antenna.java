package it.reply.challenge.edition2021.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Antenna {

    String id;
    int x;
    int y;
    Integer range;
    Integer connSpeed;

}
