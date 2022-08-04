package fr.slickteam.ecommerce;

import fr.slickteam.ecommerce.regles.*;

import java.util.HashSet;
import java.util.Set;

public class Panier {
    private static final double POIDS_PANIER = 0.5;

    private final Internaute internaute;
    private final Set<Produit> contenu;
    private double poidsEnKg;
    private final PanierAssezLeger panierAssezLeger;

    public Panier(Internaute internaute) {
        contenu = new HashSet<>();
        this.internaute = internaute;
        panierAssezLeger = new PanierAssezLeger(internaute);
        this.poidsEnKg = POIDS_PANIER;
    }

    public void ajouter(Produit produit) {
        if (panierAssezLeger.and(new EstProduitDeSaison()).isSatisfyBy(new DemandeAjoutProduit(this, produit))) {
            contenu.add(produit);
            majPoids(produit.getPoidsEnKilo());
        }
    }

    private void majPoids(double poidsEnKilo) {
        this.poidsEnKg += poidsEnKilo;
    }


    public double getPoidsEnKg() {
        return poidsEnKg;
    }
}
