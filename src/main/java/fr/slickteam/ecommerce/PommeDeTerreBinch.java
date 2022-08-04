package fr.slickteam.ecommerce;

public record PommeDeTerreBinch(int quantite, Unite unite) implements Produit {
    @Override
    public double getPoidsEnKilo() {
        return 0; //todo
    }
}
