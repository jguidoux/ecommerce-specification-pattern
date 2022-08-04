package fr.slickteam.ecommerce.regles;

import fr.slickteam.ecommerce.DemandeAjoutProduit;
import fr.slickteam.ecommerce.Internaute;

public class PanierPeutContenirProduit implements Specification<DemandeAjoutProduit> {
    private final double limitPoidsPanier;

    public PanierPeutContenirProduit(Internaute internaute) {
        this.limitPoidsPanier = switch (internaute.lieuHabitation()) {
            case ILE_DE_FRANCE -> 120;
            case METROPOLE -> 25;
            case DOM_TOM -> 10;
        };
    }

    @Override
    public boolean isSatisfyBy(DemandeAjoutProduit demandeAjoutProduit) {
        double poidsDuPanierEnKg = demandeAjoutProduit.panier().getPoidsEnKg();
        double poidsDuProduitEnKilo = demandeAjoutProduit.produit().getPoidsEnKilo();
        return poidsDuPanierEnKg + poidsDuProduitEnKilo < limitPoidsPanier;

    }
}
