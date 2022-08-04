package fr.slickteam.ecommerce;

import java.time.Month;
import java.util.List;
import java.util.Set;

import static java.time.Month.*;

public record FraiseDePlougastel(int quantite, Unite unite) implements Produit {
    @Override
    public double getPoidsEnKilo() {
        return 0; //todo
    }

    @Override
    public Set<Month> getMoisDeSaisons() {
        return Set.of(APRIL, MAY, JUNE);
    }
}
