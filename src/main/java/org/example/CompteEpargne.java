package org.example;

import jakarta.validation.constraints.Min;
import lombok.*;


@Setter
@Getter
public class CompteEpargne extends Compte {
    private final double soldeMin=10;
    @Override
    public double getSoldeMin(){
        return soldeMin;
    }
    private double tauxInteret ;
    public void calculerInteret(){
    super.setSolde(super.getSolde()+this.tauxInteret);
    }

}
