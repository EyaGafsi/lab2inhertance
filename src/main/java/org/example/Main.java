package org.example;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();

        CompteCourant compte1 = new CompteCourant();
        compte1.setSolde(500);
        compte1.setEtat(Etat.ACTIF);
        compte1.setDateCreation(LocalDate.now().minusMonths(1));
        compte1.setRIB("RIB001");
        CompteCourant compte2 = new CompteCourant();
        compte2.setSolde(-10);
        compte2.setEtat(Etat.ACTIF);
        compte2.setDateCreation(LocalDate.now().minusMonths(5));
        compte2.setRIB("RIB002");
        CompteEpargne compte3 = new CompteEpargne();
        compte3.setSolde(1000);
        compte3.setEtat(Etat.ACTIF);
        compte3.setDateCreation(LocalDate.now().minusMonths(6));
        compte3.setRIB("RIB003");
        CompteEpargne compte4 = new CompteEpargne();
        compte4.setSolde(200);
        compte4.setEtat(Etat.ACTIF);
        compte4.setDateCreation(LocalDate.now());
        compte4.setRIB("RIB004");
        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);
        banque.ajouterCompte(compte3);
        banque.ajouterCompte(compte4);

        compte1.setSolde(compte1.deposer(300));

        compte2.setSolde(compte2.retirer(50));

        if(banque.rechercherCompte("RIB003")){
            System.out.println("Compte existe");
        }else {
            System.out.println("Compte n'existe pas");
        }


        banque.afficherTousLesComptes(banque.getComptes());

        banque.transferer("RIB001", "RIB004", 200);

        banque.afficherTousLesComptes(banque.getComptes());

        banque.afficherTousLesComptes(banque.getComptesAvecSoldeNegatif());

        banque.afficherTousLesComptes(banque.getComptesEpargneRecents());

    }
}
