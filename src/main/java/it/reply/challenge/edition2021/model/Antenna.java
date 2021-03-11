package it.reply.challenge.edition2021.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Antenna {

    Integer id;
    Integer x;
    Integer y;
    Integer range;
    Integer connSpeed;

}
