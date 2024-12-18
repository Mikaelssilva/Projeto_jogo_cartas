package controller;

import actions.Jogavel;
import model.*;
import actions.Atacavel;
import Exception.manaInsuficienteException;
import view.GameGUI;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;
import static java.lang.Math.min;


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

        // pede o nome dos jogadores
        System.out.println("Nome do jogador 1: ");
        String nomej1 = in.nextLine();
        System.out.println("Nome do jogador 2: ");
        String nomej2 = in.nextLine();
        new GameGUI(jogador1, jogador2, nomej1, nomej2);
        int nRamdomico = (int)(Math.random() * 2); // 1 == 2 0 == 1 (quem vai iniciar)
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
            System.out.println("Mao do jogador 1: ");
            mostrarMao(jogador1);
            System.out.println("Mao do jogador 2: ");
            mostrarMao(jogador2);
            // condicoes de parada --->
            // vida de jogador 1 ou 2 == 0
            // qnt de cartas do tipo criatura no deck == 0
            // jogadores ganharao uma carta e um ponto de mana a cada rodada
            if(nRamdomico == 1){
                System.out.println("Vez do jogador 2");
                acao(jogador2, jogador1);
                if(!jogador2.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador2.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                jogador2.setMana(min(jogador2.getMana() + 1, 10));
                if(jogador2.getMao().size() <= 5){
                    Carta ultimaCarta = jogador2.getDeck().getCarta(jogador2.getDeck().size() - 1);
                    jogador2.getMao().add((Criatura) ultimaCarta);
                    jogador2.getDeck().removerCarta(ultimaCarta);
                }
                System.out.println("Vez do jogador 1");
                acao(jogador1, jogador2);
                if(!jogador1.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador1.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                if(jogador1.getMao().size() <= 5){
                    Carta ultimaCarta = jogador1.getDeck().getCarta(jogador1.getDeck().size() - 1);
                    jogador1.getMao().add((Criatura) ultimaCarta);
                    jogador1.getDeck().removerCarta(ultimaCarta);
                }
                jogador1.setMana(min(jogador1.getMana() + 1, 10));
            }
            if(nRamdomico == 0){
                System.out.println("Vez do jogador 1");
                acao(jogador1, jogador2);
                if(!jogador1.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador1.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                if(jogador1.getMao().size() <= 5){
                    Carta ultimaCarta = jogador1.getDeck().getCarta(jogador1.getDeck().size() - 1);
                    jogador1.getMao().add((Criatura) ultimaCarta);
                    jogador1.getDeck().removerCarta(ultimaCarta);
                }
                jogador1.setMana(min(jogador1.getMana() + 1, 10));
                System.out.println("Vez do jogador 2");
                acao(jogador2, jogador1);
                if(!jogador2.getUltimasCartas().isEmpty()) {
                    for (Criatura c : jogador2.getUltimasCartas()) {
                        c.setPodeAtacar(true);
                    }
                }
                if(jogador2.getMao().size() <= 5){
                    Carta ultimaCarta = jogador2.getDeck().getCarta(jogador2.getDeck().size() - 1);
                    jogador2.getMao().add((Criatura) ultimaCarta);
                    jogador2.getDeck().removerCarta(ultimaCarta);
                }
                jogador2.setMana(min(jogador2.getMana() + 1, 10));
            }
        }
        jogador1.getUltimasCartas().clear();
        jogador2.getUltimasCartas().clear();
    }

    public static void atacar(Jogador jogadorA, Jogador jogadorD, Criatura atacante, Criatura defensor) {
        int mana = jogadorA.getMana();
        try {
            if (mana < atacante.getCustoDeMana()) {
                throw new manaInsuficienteException("Mana insuficiente para atacar!");
            } else {
                if (!jogadorD.getCartasEmJogo().isEmpty()) {
                    // atacar carta -- carta atacante ou carta vitima morre (ambos recebem dano)
                    // atacar jogador -- a mesma coisa (so é possivel se nao tiver cartas em jogo do
                    // outro jogador)
                    // falta implementar a habilidade das cartas ***(!!!)***
                    // sempre alguem morre
                    // se a sua criatura morrer no ataque ela ainda vai dar dano
                    // se carta entrou sua carta entrou no cemiterio ela saira da cartasEmJogo
                    if (atacante.getPoder() > defensor.getResistencia()) { // atacante mata
                        jogadorD.getCartasEmJogo().remove(defensor);
                        jogadorD.getCemiterio().addCartaCemiterio(defensor);
                    } else if (atacante.getPoder() < defensor.getResistencia()) { // defensor mata
                        jogadorA.getCartasEmJogo().remove(atacante);
                        jogadorA.getCemiterio().addCartaCemiterio(atacante);
                    } else if (atacante.getPoder() == defensor.getResistencia()) { // ambos morrem
                        jogadorA.getCartasEmJogo().remove(atacante);
                        jogadorD.getCartasEmJogo().remove(defensor);
                        jogadorD.getCemiterio().addCartaCemiterio(defensor);
                        jogadorD.getCemiterio().addCartaCemiterio(atacante);
                    }
                } else{
                    // um jogador ataca o outro se ele nao tiver cartas em jogo
                    if(atacante.getPoder() >= jogadorD.getVida()){
                        jogadorD.setVida(0);
                    } else{
                        jogadorA.getCartasEmJogo().remove(atacante);
                        jogadorA.getcemiterio().addCartaCemiterio(atacante);
                    }
                }
                jogadorA.setMana(mana - atacante.getCustoDeMana());
            }
        } catch (manaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    //public static void comprarCarta()
    // metodo serve para "colocar carta na mesa"
    //@Override
    public static void jogarCarta(Jogador jogador, Criatura carta) {
        jogador.getMao().remove(carta);
        jogador.getCartasEmJogo().add(carta);
    }

    public static void preencherMao(Jogador jogador){
        while(jogador.getMao().size() < 5) {
            int nRandomico = (int) (Math.random() * jogador.getDeck().size());
            Deck deckDoJogador = jogador.getDeck();
            Carta carta = deckDoJogador.getCarta(nRandomico);
            jogador.getMao().add((Criatura) carta);
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

    public static void gerarEfeitoDaHabilidade(Criatura carta, Jogador jogador){
        // rapidez   -- atacar no mesmo round
        // forca     -- atacar duas vezes seguidas
        // provocar  -- todas as cartas do deck ganham um de dano
        if(carta.getHabilidadeEspecial().equals("Rapidez")){
            carta.setPodeAtacar(true);
        }
        else if(carta.getHabilidadeEspecial().equals("Forca")){
            carta.setAtaquesRestantes(2);
        }
        else if(carta.getHabilidadeEspecial().equals("Provocar")){
            for(Criatura c : jogador.getCartasEmJogo()){
                if(c != carta){
                    c.setDano(min(c.getPoder() + 1, 10));
                }
            }
        }
    }

    public static void acao(Jogador jogadorA, Jogador jogadorD){
        System.out.println("Selecione sua acao");
        System.out.println("A = atacar P = pular turno J jogar carta");
        char acao = toUpperCase(in.next().charAt(0));
        if(acao == 'A'){
            //ArrayList<Boolean> podeAtacar = new ArrayList<>(jogadorD.getCartasEmJogo().size());
           // for(Carta c : jogadorA.getCartasEmJogo()){
            //    if(((Criatura) c).getPodeAtacar()){

            //    }
           // }
            // selecionar carta que vai ser usada
            // selcecionar botao atacar
            // selecionar carta que vai ser atacada
            System.out.println("Digite carta que vai atacar");
            in.nextLine(); // consumir \n
            boolean encontradoA = false;
            boolean encontradoD = false;
            Criatura cartaA = null;
            String cartaAs = in.nextLine();
            // cartaA existe? vamos fazer uma busca
            for(Criatura c : jogadorA.getCartasEmJogo()){
                if(c.getNome().equals(cartaAs)){
                    encontradoA = true;
                    cartaA = c;
                    break;
                }
            }
            System.out.println("Digite carta que vai defender");
            String cartaDs = in.nextLine();
            Criatura cartaD = null;
            for(Criatura c : jogadorD.getCartasEmJogo()){
                if(c.getNome().equals(cartaDs)){
                    encontradoD = true;
                    cartaD = c;
                    break;
                }
            }
            if (encontradoA && encontradoD){
                // se ambas cartas existem posso chamar a habilidade
                System.err.println(cartaA.getHabilidadeEspecial());
                gerarEfeitoDaHabilidade(cartaA, jogadorA);
                if(cartaA.getPodeAtacar()) {
                    while(cartaA.getAtaquesRestantes() != 0) {
                        atacar(jogadorA, jogadorD, cartaA, cartaD);
                        cartaA.setAtaquesRestantes(cartaA.getAtaquesRestantes() - 1);
                    }
                    System.out.println("Jogador atacou");
                } else{
                    System.out.println("Voce nao pode atacar com essa carta ainda");
                }
            } else{
                System.out.println("Algum input nao estava correto!");
            }
        }
        else if(acao == 'P'){
            System.out.println("Jogador pulou turno");
        }
        else if(acao == 'J'){
            if(!jogadorA.getMao().isEmpty()) {
                in.nextLine(); // consumir \n
                System.out.println("Escolha a carta que vai jogar");
                String cartaS = in.nextLine();
                Criatura carta = null;
                boolean encontrado = false;
                for (Criatura c : jogadorA.getMao()) {
                    if (c.getNome().equals(cartaS)) {
                        carta = c;
                        jogadorA.getUltimasCartas().add(carta);
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    System.err.println(carta.getHabilidadeEspecial());
                    jogarCarta(jogadorA, carta);
                    gerarEfeitoDaHabilidade(carta, jogadorA);
                    System.out.println("Jogador jogou carta");
                } else {
                    System.out.println("Carta nao encontrada");
                }
            } else{
                System.out.println("Voce nao pode jogar nenhuma carta");
            }
        }
        else{
            System.out.println("acao invalida");
        }
        System.out.println("Terminar turno? s/n");
        char o = toUpperCase(in.next().charAt(0));
        if(o == 'S'){
            System.out.println("turno finalizado com sucesso");
        }
        else if(o == 'N'){
            acao(jogadorA, jogadorD);
        }
        else{
            System.out.println("acao invalida");
        }
    }
}