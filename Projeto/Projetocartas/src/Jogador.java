public class Jogador extends Deck{
  private int vida;
  private int mana;
  // em breve deck sera um atributo
  private int countXp;

  void progressao(int countXp){
    int[] level = new int[11];
    for(int i = 1; i < level.length; i++){
      level[i] = 2*i;
    }
    // level 1 = precisa de 2 de xp
    // level 2 = precisa de 4 de xp
    // assim em diante o level i precisara de 2*i de xp
    for(int i = 0; i < level.length; i++){
      if(countXp >= level[i]){
        System.out.println("Parabens! Voce subiu de nivel!");
      }
    }
  }
}