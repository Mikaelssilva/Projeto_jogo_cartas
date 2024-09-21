public class Encantamento extends Carta{
  private int efeitoContinuo;

  // Construtor
  public Encantamento(String nome, int custoDeMana, int efeitoContinuo) {
      super(nome, custoDeMana);
      this.efeitoContinuo = efeitoContinuo;
  }

}