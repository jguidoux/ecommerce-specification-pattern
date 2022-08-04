package fr.slickteam.ecommerce;

import java.util.HashSet;
import java.util.Set;

public class Panier {

    private static final double LIMITE_DE_POIDS = 10.0;
    private static final double POIDS_PANIER_A_VIDE = 0.5 ;
    static Set<Produit> contenu;
    private double poidsEnKg;

    public Panier() {
        contenu = new HashSet<>();
        poidsEnKg = POIDS_PANIER_A_VIDE;
    }

    public void ajouter(Produit produit) {
        if (getPoidsEnKilo() + produit.getPoidsEnKilo() < LIMITE_DE_POIDS) {
            contenu.add(produit);
            majPoidsDuPanier(produit);
        }
    }

    private void majPoidsDuPanier(Produit produit) {
        this.poidsEnKg += produit.getPoidsEnKilo();
    }

    private double getPoidsEnKilo() {
        return poidsEnKg;
    }
}