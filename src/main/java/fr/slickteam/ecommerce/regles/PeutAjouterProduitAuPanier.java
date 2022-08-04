package fr.slickteam.ecommerce.regles;

import fr.slickteam.ecommerce.DemandeAjoutProduit;
import fr.slickteam.ecommerce.Internaute;

public class PeutAjouterProduitAuPanier implements  Specification<DemandeAjoutProduit> {

    private final PanierAssezLeger panierAssezLeger;
    private final EstProduitDeSaison estProduitDeSaison;

    public PeutAjouterProduitAuPanier(Internaute internaute) {
        panierAssezLeger = new PanierAssezLeger(internaute);
        estProduitDeSaison = new EstProduitDeSaison();
    }

    @Override
    public boolean isSatisfyBy(DemandeAjoutProduit demandeAjoutProduit) {
        return panierAssezLeger.and(estProduitDeSaison).isSatisfyBy(demandeAjoutProduit);
    }

}
