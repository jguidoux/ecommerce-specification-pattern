package fr.slickteam.ecommerce;

import java.time.Month;
import java.util.Set;

public interface Produit {
    double getPoidsEnKilo();

    Set<Month> getMoisDeSaisons();
}
