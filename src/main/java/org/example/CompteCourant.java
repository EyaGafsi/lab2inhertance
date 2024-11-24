package org.example;

import jakarta.validation.constraints.Min;
import lombok.*;


@Setter
@Getter
public class CompteCourant extends Compte{
    private final double soldeMin=-900;
    @Override
    public double getSoldeMin(){
        return soldeMin;
    }
}
