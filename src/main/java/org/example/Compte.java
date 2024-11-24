package org.example;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Compte {
    @EqualsAndHashCode.Include
    private String RIB ;
   private double solde ;
   private LocalDate dateCreation ;
   private Etat etat ;
    public abstract double getSoldeMin();

    public double deposer(double m){
       if ((this.etat.equals(Etat.ACTIF))&&(m>=0)) {
           System.out.println(" depot réussi");

           return this.solde + m;
       }
       else {
           System.out.println(" depot échoué");
           return this.solde;
       }
   }
    public double retirer(double m){
        if ((this.etat.equals(Etat.ACTIF))&&(m>=0)&&(this.solde - m>=this.getSoldeMin())) {
            System.out.println(" transfert réussi");
            return this.solde - m;
        }
        else {
            System.out.println(" transfert échoué");
            return this.solde;
        }    }


}
