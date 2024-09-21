public class JogoTeste{
  public static void main(String[] args){
    // objeto criatura
    Criatura dragao = new Criatura("Dragão", 10, 20, 20, "Voar");

    System.out.printf("Nome: %s\n", dragao.getNome());
  }
}