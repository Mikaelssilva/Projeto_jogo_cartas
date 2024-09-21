public class Criatura extends Carta{
  private int dano;
  private int resistencia;
  private String habilidadeEspecial;

  // contrutuor
  public Criatura(String nome, int custodemana, int dano, int resistencia, String habilidadeEspecial){
    // chama o construtor da superclasse
    super(nome, custodemana);
    this.dano = dano;
    this.resistencia = resist;
    this.habilidadeEspecial = habilidade;
  }
}