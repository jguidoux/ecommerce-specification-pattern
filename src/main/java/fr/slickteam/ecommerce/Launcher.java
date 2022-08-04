package fr.slickteam.ecommerce;

import java.util.HashSet;

public class Launcher {


    public static void main(String[] args) {
        Panier panier = new Panier(new Internaute(LieuHabitation.ILE_DE_FRANCE));

        panier.ajouter(new FraiseDePlougastel(5, Unite.BARQUETTE));
        panier.ajouter(new PommeDeTerreBinch(2, Unite.KILO));
    }
}
