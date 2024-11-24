package org.example;

import lombok.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class Banque {
    private Map<String, Compte> comptes= new HashMap<>();
    public void ajouterCompte(Compte compte) {
        if (!rechercherCompte(compte.getRIB()))
         this.comptes.put(compte.getRIB(), compte);
    }
    public void supprimerCompte(String rib) {
        this.comptes.remove(rib);
    }
    public boolean rechercherCompte(String rib) {
        return this.comptes.containsKey(rib);
    }
    public void afficherTousLesComptes(Map<String, Compte> comptes) {
        System.out.println(comptes);
    }
    public void transferer(String ribA, String ribB, double m){
        Compte compteA = this.comptes.get(ribA);
        Compte compteB = this.comptes.get(ribB);
        compteA.setSolde(compteA.retirer(m));
        compteB.setSolde(compteB.deposer(m));
    }
    public Map<String, Compte> getComptesAvecSoldeNegatif() {
        Map<String, Compte> comptesNegatifs = new HashMap<>();
        for (Compte compte : this.comptes.values()) {
            if (compte.getSolde() < 0) {
                comptesNegatifs.put(compte.getRIB(),compte);
            }
        }
        return comptesNegatifs;
    }
    public Map<String, Compte> getComptesEpargneRecents() {
        Map<String, Compte> comptesEpargneRecents= new HashMap<>();
        for (Compte compte : this.comptes.values()) {
            if (compte.getSoldeMin()==10 && compte.getDateCreation().isBefore(LocalDate.now().minusMonths(3))) {
                comptesEpargneRecents.put(compte.getRIB(),compte);
            }
        }
        return comptesEpargneRecents;
    }
}
