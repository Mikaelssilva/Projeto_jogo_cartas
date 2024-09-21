public class Carta{
  private String nome;
  private int custoDeMana; // custo maximo = 10 (ta no roteiro)
  
  public Cartas(String nome, int custodemana){
    setNome(nome);
    setCustoDeMana(custodemana);
  }

  public String getNome(){
    return nome;
  }

  public setNome(String nome){
    this.nome = nome;
  }

  public int getCustoDeMana(){
    return custoDeMana;
  }

  public setCustoDeMana(int custoDeMana){
    if(cusotoDeMana <= 10){
      this.custoDeMana = custoDeMana;
    }
    else{
      System.out.println("Custo de mana excede o limite de 10");
      exit(1);
    }
  }
}