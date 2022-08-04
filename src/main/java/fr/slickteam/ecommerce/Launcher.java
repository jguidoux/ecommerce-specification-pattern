package fr.slickteam.ecommerce;

import java.util.HashSet;
import java.util.Set;

public class Launcher {


    public static void main(String[] args) {
        Set<Produit> panier = new HashSet<>();

        panier.add(new FraiseDePlougastel(5, Unite.BARQUETTE));
        panier.add(new PommeDeTerreBinch(2, Unite.KILO));
    }
}
