package actions;

import model.Criatura;

public interface Atacavel {
    public void ataque(Criatura criaturaAtacante, Criatura criaturaDefensora);
}
