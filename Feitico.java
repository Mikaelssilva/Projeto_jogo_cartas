public class Feitico extends Carta{
  private String efeito; // não sei ao certo se efeito é string ou int

  // construtor
  public Feitico(String nome, int custodemana, String efeito){
    // chama o construtor da superclasse
    super(nome, custodemana);
    this.efeito = efeito;
  }
}