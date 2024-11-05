package actions;

import model.Criatura;
import model.Jogador;

public interface Atacavel {
    public void atacar(Jogador jogador, Criatura atacante, Criatura defensor);
}
