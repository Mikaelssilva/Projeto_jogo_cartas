package controller;

import model.Carta;
import model.Criatura;
import model.Jogador;
import actions.Atacavel;
import Exception.manaInsuficienteException;

public class Jogo {

    public void atacar(Jogador jogador, Criatura atacante, Criatura defensor) {
        try {
            if (jogador.getMana() < atacante.getCustoDeMana()) {
                throw new manaInsuficienteException("Mana insuficiente para atacar!");
            }
        } catch (manaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public void jogarCarta(Jogador jogador, Carta carta) {
        try {
            if (jogador.getMana() < carta.getCustoDeMana()) {
                throw new manaInsuficienteException("Mana insuficiente para jogar esta carta!");
            }
        } catch (manaInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isGameOver() {
        return false;
    }
}