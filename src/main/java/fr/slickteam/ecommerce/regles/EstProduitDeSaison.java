package fr.slickteam.ecommerce.regles;

import fr.slickteam.ecommerce.DemandeAjoutProduit;

import java.time.LocalDate;
import java.time.Month;

public class EstProduitDeSaison implements Specification<DemandeAjoutProduit> {
    @Override
    public boolean isSatisfyBy(DemandeAjoutProduit demandeAjoutProduit) {
        Month moisActuel = LocalDate.now().getMonth();
        return demandeAjoutProduit.produit().getMoisDeSaisons().contains(moisActuel);
    }
}
