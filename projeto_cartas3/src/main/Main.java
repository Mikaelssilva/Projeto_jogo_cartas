package main;

import model.Criatura;
import model.Deck;
import model.Jogador;
import view.GameGUI;

import static setupDeck.setupDeckInterface.setupDeck;

public class Main {
    public static void main(String[] args) {
        new GameGUI();
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        setupDeck(deck1);
        setupDeck(deck2);
        Jogador jogador1 = new Jogador(10, 10, deck1);
        Jogador jogador2 = new Jogador(10, 10, deck2);
    }

    public static void preencherDeck(Deck deck) {
        deck.addCard(new Criatura("Pikachu", 3, 5, 3, "Rapidez"));
        deck.addCard(new Criatura("Charizard", 6, 8, 5, "Força"));
        deck.addCard(new Criatura("Bulbasaur", 2, 3, 4, "Provocar"));
        deck.addCard(new Criatura("Squirtle", 2, 2, 5, "Rapidez"));
        deck.addCard(new Criatura("Jigglypuff", 3, 4, 4, "Provocar"));
        deck.addCard(new Criatura("Gengar", 5, 7, 4, "Força"));
        deck.addCard(new Criatura("Mewtwo", 8, 9, 6, "Rapidez"));
        deck.addCard(new Criatura("Eevee", 3, 3, 4, "Provocar"));
        deck.addCard(new Criatura("Snorlax", 4, 5, 10, "Força"));
        deck.addCard(new Criatura("Pidgeot", 4, 6, 3, "Rapidez"));
        deck.addCard(new Criatura("Onix", 4, 6, 8, "Provocar"));
        deck.addCard(new Criatura("Jolteon", 5, 6, 4, "Rapidez"));
        deck.addCard(new Criatura("Flareon", 5, 7, 4, "Força"));
        deck.addCard(new Criatura("Vaporeon", 5, 5, 6, "Força"));
        deck.addCard(new Criatura("Machamp", 6, 8, 5, "Força"));
        deck.addCard(new Criatura("Gyarados", 7, 9, 6, "Força"));
        deck.addCard(new Criatura("Lapras", 6, 5, 7, "Provocar"));
        deck.addCard(new Criatura("Alakazam", 5, 7, 4, "Rapidez"));
        deck.addCard(new Criatura("Scyther", 4, 6, 3, "Rapidez"));
        deck.addCard(new Criatura("Tyranitar", 8, 10, 8, "Força"));
        deck.addCard(new Criatura("Lucario", 5, 7, 5, "Força"));
        deck.addCard(new Criatura("Porygon-Z", 4, 5, 4, "Rapidez"));
        deck.addCard(new Criatura("Zubat", 2, 3, 3, "Rapidez"));
        deck.addCard(new Criatura("Mew", 5, 4, 5, "Provocar"));
        deck.addCard(new Criatura("Gardevoir", 6, 5, 6, "Rapidez"));
        deck.addCard(new Criatura("Dragonite", 7, 8, 7, "Força"));
        deck.addCard(new Criatura("Regice", 6, 4, 8, "Provocar"));
        deck.addCard(new Criatura("Regirock", 6, 8, 9, "Força"));
        deck.addCard(new Criatura("Sandslash", 4, 6, 5, "Provocar"));
        deck.addCard(new Criatura("Steelix", 7, 7, 10, "Provocar"));
    }

}
