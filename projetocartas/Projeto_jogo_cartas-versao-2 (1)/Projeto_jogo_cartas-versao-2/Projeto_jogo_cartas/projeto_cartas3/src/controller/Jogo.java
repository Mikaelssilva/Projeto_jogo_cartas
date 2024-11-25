package controller;

import actions.Jogavel;
import model.*;
import actions.Atacavel;
import Exception.manaInsuficienteException;
import view.GameGUI;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class Jogo implements Atacavel, Jogavel {
    static Scanner in = new Scanner(System.in);
    public static void inciarJogo(){

        Cemiterio cemiterioJogador1 = new Cemiterio();
        Cemiterio cemiterioJogador2 = new Cemiterio();
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Jogador jogador1 = new Jogador(10, 10, deck1, cemiterioJogador1);
        Jogador jogador2 = new Jogador(10, 10, deck2, cemiterioJogador2);
        preencherDeck(jogador1);
        preencherDeck(jogador2);
        preencherMao(jogador1);
        preencherMao(jogador2);
        System.out.println("Mao do jogador 1: ");
        mostrarMao(jogador1);
        System.out.println("Mao do jogador 2: ");
        mostrarMao(jogador2);
        //new GameGUI(jogador1, jogador2);
        int nRamdomico =(int) (Math.random() * 2); // 1 == 2 0 == 1 (quem vai iniciar)
        if(nRamdomico == 0){
            System.out.println("Jogador 1 vai comecar");
        }
        if(nRamdomico == 1){
            System.out.println("Jogador 2 vai comecar");
        }
        while(true){
            if(jogador1.getVida() == 0){
                System.out.println("Jogador2 venceu");
                break;
            }
            else if(jogador2.getVida() == 0){
                System.out.println("Jogador1 venceu");
                break;
            }
            else if(jogador1.getDeck().size() == 0){
                System.out.println("Jogador2 venceu");
                break;
            }
            else if(jogador2.getDeck().size() == 0){
                System.out.println("Jogador1 venceu");
                break;
            }
            // condicoes de parada --->
            // vida de jogador 1 ou 2 == 0
            // qnt de cartas do tipo criatura no deck == 0
            if(nRamdomico == 1){
                System.out.println("Vez do jogador 2");
                acao(jogador2, jogador1);
                acao(jogador1, jogador2);
            }
            if(nRamdomico == 0){
                System.out.println("Vez do jagador 1");
                acao(jogador1, jogador2);
                acao(jogador2, jogador1);
            }
        }
    }

    public static void atacar(Jogador jogadorA, Jogador jogadorD, Criatura atacante, Criatura defensor) {
        try {
            if (jogadorA.getMana() < atacante.getCustoDeMana()) {
                throw new manaInsuficienteException("Mana insuficiente para atacar!");
            } else{
                if(atacante.getPoder() >= defensor.getResistencia()){
                    jogadorD.getCemiterio().addCartaCemiterio(atacante);
                }
            }
        } catch (manaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
    //public static void comprarCarta()
    // metodo serve para "colocar carta na mesa"
    //@Override
    public static void jogarCarta(Jogador jogador, Carta carta) {
        jogador.getMao().remove(carta);
        jogador.getCartasEmJogo().add(carta);
    }

    public static void preencherMao(Jogador jogador){
        while(jogador.getMao().size() < 5) {
            int nRandomico = (int) (Math.random() * jogador.getDeck().size());
            Deck deckDoJogador = jogador.getDeck();
            Carta carta = deckDoJogador.getCarta(nRandomico);
            jogador.getMao().add(carta);
            jogador.getDeck().removerCarta(carta);
        }
    }

    public static void preencherDeck(Jogador jogador) {
        jogador.getDeck().addCard(new Criatura("Pikachu", 3, 5, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Charizard", 6, 8, 5, "Força"));
        jogador.getDeck().addCard(new Criatura("Bulbasaur", 2, 3, 4, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Squirtle", 2, 2, 5, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Jigglypuff", 3, 4, 4, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Gengar", 5, 7, 4, "Força"));
        jogador.getDeck().addCard(new Criatura("Mewtwo", 8, 9, 6, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Eevee", 3, 3, 4, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Snorlax", 4, 5, 10, "Força"));
        jogador.getDeck().addCard(new Criatura("Pidgeot", 4, 6, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Onix", 4, 6, 8, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Jolteon", 5, 6, 4, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Flareon", 5, 7, 4, "Força"));
        jogador.getDeck().addCard(new Criatura("Vaporeon", 5, 5, 6, "Força"));
        jogador.getDeck().addCard(new Criatura("Machamp", 6, 8, 5, "Força"));
        jogador.getDeck().addCard(new Criatura("Gyarados", 7, 9, 6, "Força"));
        jogador.getDeck().addCard(new Criatura("Lapras", 6, 5, 7, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Alakazam", 5, 7, 4, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Scyther", 4, 6, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Tyranitar", 8, 10, 8, "Força"));
        jogador.getDeck().addCard(new Criatura("Lucario", 5, 7, 5, "Força"));
        jogador.getDeck().addCard(new Criatura("Porygon-Z", 4, 5, 4, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Zubat", 2, 3, 3, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Mew", 5, 4, 5, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Gardevoir", 6, 5, 6, "Rapidez"));
        jogador.getDeck().addCard(new Criatura("Dragonite", 7, 8, 7, "Força"));
        jogador.getDeck().addCard(new Criatura("Regice", 6, 4, 8, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Regirock", 6, 8, 9, "Força"));
        jogador.getDeck().addCard(new Criatura("Sandslash", 4, 6, 5, "Provocar"));
        jogador.getDeck().addCard(new Criatura("Steelix", 7, 7, 10, "Provocar"));
    }

    public static void mostrarMao(Jogador jogador){
        for(Carta c : jogador.getMao()){
            System.out.println(c.getNome());
        }
    }

    public static void acao(Jogador jogadorA, Jogador jogadorD){
        System.out.println("Selecione sua acao");
        System.out.println("A = atacar P = pular turno J jogar carta");
        char acao = toUpperCase(in.next().charAt(0));
        if(acao == 'A'){
            // selecionar carta que vai ser usada
            // selcecionar botao atacar
            // selecionar carta que vai ser atacada
            System.out.println("Digite carta que vai atacar");
            in.nextLine(); // consumir \n
            boolean encontradoA = false;
            boolean encontradoD = false;
            Carta cartaA = null;
            String cartaAs = in.nextLine();
            // cartaA existe? vamos fazer uma busca
            for(Carta c : jogadorA.getCartasEmJogo()){
                if(c.getNome().equals(cartaAs)){
                    encontradoA = true;
                    cartaA = c;
                    break;
                }
            }
            System.out.println("Digite carta que vai defender");
            String cartaDs = in.nextLine();
            Carta cartaD = null;
            for(Carta c : jogadorD.getCartasEmJogo()){
                if(c.getNome().equals(cartaDs)){
                    encontradoD = true;
                    cartaD = c;
                    break;
                }
            }
            if (encontradoA && encontradoD){
                atacar(jogadorA, jogadorD, (Criatura) cartaA, (Criatura) cartaD);
                System.out.println("Jogador atacou");
            } else{
                System.out.println("Algum input nao estava correto!");
            }
        }
        else if(acao == 'P'){
            System.out.println("Jogador pulou turno");
        }
        else if(acao == 'J'){
            in.nextLine(); // consimir \n
            System.out.println("Escolha a carta que vai jogar");
            String cartaS = in.nextLine();
            Carta carta = null;
            boolean encontrado = false;
            for(Carta c : jogadorA.getMao()){
                if(c.getNome().equals(cartaS)){
                    carta = c;
                    encontrado = true;
                    break;
                }
            }
            if(encontrado) {
                jogarCarta(jogadorA, carta);
                System.out.println("Jogador jogou carta");
            } else{
                System.out.println("Carta nao encontrada");
            }
        }
        else{
            System.out.println("acao invalida");
        }
    }


}