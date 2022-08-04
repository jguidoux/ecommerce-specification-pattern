package fr.slickteam.ecommerce;

import fr.slickteam.ecommerce.regles.*;

import java.util.HashSet;
import java.util.Set;

public class Panier {
    private static final double POIDS_PANIER = 0.5;

    private final Internaute internaute;
    private final Set<Produit> contenu;
    private double poidsEnKg;
    private final PeutAjouterProduitAuPanier peutAjouterProduitAuPanier;

    public Panier(Internaute internaute) {
        contenu = new HashSet<>();
        this.internaute = internaute;
        peutAjouterProduitAuPanier = new PeutAjouterProduitAuPanier(internaute);
        this.poidsEnKg = POIDS_PANIER;
    }

    public void ajouter(Produit produit) {
        if (peutAjouterProduitAuPanier.isSatisfyBy(new DemandeAjoutProduit(this, produit))) {
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
