public class Main {
  public static void main(String[] args) {
    Criatura c1 = new Criatura("Dragão", 2, 10, 3, "H1");
    Criatura c2 = new Criatura("Goblin", 2, 2, 2, "H2");
    c1.ataque(c1, c2);
  }
}