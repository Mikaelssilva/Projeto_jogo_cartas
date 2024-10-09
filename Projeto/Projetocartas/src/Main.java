import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            // parte do codigo sem aparecer na interface ainda
            Deck deck = new Deck();
            deck.addCard(new Criatura("Pikachu", 3, 5, 3, "Rapidez"));
            deck.addCard(new Criatura("Charizard", 6, 8, 5, "Força"));
            deck.addCard(new Criatura("Bulbasaur", 2, 3, 4, "Provocar"));
            deck.addCard(new Criatura("Squirtle", 2, 2, 5, "Rapidez"));
            deck.addCard(new Criatura("Jigglypuff", 3, 4, 4, "Provocar"));
            deck.addCard(new Criatura("Gengar", 5, 7, 4, "Força"));
            deck.addCard(new Criatura("Mewtwo", 8, 9, 6, "Rapidez"));
            deck.addCard(new Criatura("Eevee", 3, 3, 4, "Provocar"));
            deck.addCard(new Criatura("Snorlax", 4, 5, 10, "Força"));
            deck.addCard(new Criatura("Pidgeot", 4, 6, 3, "Rapidez"));

            deck.addCard(new Criatura("Onix", 4, 6, 8, "Provocar"));
            deck.addCard(new Criatura("Jolteon", 5, 6, 4, "Rapidez"));
            deck.addCard(new Criatura("Flareon", 5, 7, 4, "Força"));
            deck.addCard(new Criatura("Vaporeon", 5, 5, 6, "Força"));
            deck.addCard(new Criatura("Machamp", 6, 8, 5, "Força"));
            deck.addCard(new Criatura("Gyarados", 7, 9, 6, "Força"));
            deck.addCard(new Criatura("Lapras", 6, 5, 7, "Provocar"));
            deck.addCard(new Criatura("Alakazam", 5, 7, 4, "Rapidez"));
            deck.addCard(new Criatura("Scyther", 4, 6, 3, "Rapidez"));
            deck.addCard(new Criatura("Tyranitar", 8, 10, 8, "Força"));

            deck.addCard(new Criatura("Lucario", 5, 7, 5, "Força"));
            deck.addCard(new Criatura("Porygon-Z", 4, 5, 4, "Rapidez"));
            deck.addCard(new Criatura("Zubat", 2, 3, 3, "Rapidez"));
            deck.addCard(new Criatura("Mew", 5, 4, 5, "Provocar"));
            deck.addCard(new Criatura("Gardevoir", 6, 5, 6, "Rapidez"));
            deck.addCard(new Criatura("Dragonite", 7, 8, 7, "Força"));
            deck.addCard(new Criatura("Regice", 6, 4, 8, "Provocar"));
            deck.addCard(new Criatura("Regirock", 6, 8, 9, "Força"));
            deck.addCard(new Criatura("Sandslash", 4, 6, 5, "Provocar"));
            deck.addCard(new Criatura("Steelix", 7, 7, 10, "Provocar"));

            // 5 Feitiços nomes sujetos a mudanca
            Feitico feitico1 = new Feitico("Bola de Fogo", 5, "a definir");
            Feitico feitico2 = new Feitico("Relâmpago", 3, "a definir");
            Feitico feitico3 = new Feitico("Curar Feridas", 4, "a definir");
            Feitico feitico4 = new Feitico("Tempestade de Gelo", 6, "a definir");
            Feitico feitico5 = new Feitico("Barreira Arcana", 2, "a definir");

            // 5 Encantamentos nomes sujeitos a mudanca
            Encantamento encantamento1 = new Encantamento("Aura de Proteção", 4, "a definir");
            Encantamento encantamento2 = new Encantamento("Força da Natureza", 3, "a definir");
            Encantamento encantamento3 = new Encantamento("Campo de Energia", 5, "a definir");
            Encantamento encantamento4 = new Encantamento("Benção dos Deuses", 6, "a definir");
            Encantamento encantamento5 = new Encantamento("Vínculo Espiritual", 2, "a definir");

            Scanner in = new Scanner(System.in);

            // cada conjunto de cartas vai ser o inventario de cada jogador
            System.out.println("ESCOLHA SEU DECK (JOGADOR 1)");
            Deck deck1 = new Deck();
            for(int i = 0; i < 30;){
                boolean cartaEncontrada = false;
                boolean cartaRepitida = false;
                String carta = in.nextLine();

                for(int j = 0; j < deck1.size(); j++) {
                    if (carta.equals(deck1.getCarta(j).getNome())) {
                        cartaRepitida = true;
                        break;
                    }
                }

                for (int j = 0; j < deck.size(); j++) {
                    if (carta.equals(deck.getCarta(j).getNome())) {
                        deck1.addCard(deck.getCarta(j));
                        cartaEncontrada = true;
                        break;
                    }
                }
                if (cartaEncontrada && !cartaRepitida){
                    System.out.println("Carta adicionada com sucesso!");
                    i++;
                }
                else if(cartaRepitida){
                    System.out.println("Carta repitida!");
                }
                else{
                    System.out.println("Carta nao encontrada!");
                }
            }

            System.out.println("ESCOLHA SEU DECK (JOGADOR 2)");
            Deck deck2 = new Deck();
            for(int i = 0; i < 30;){
                boolean cartaEncontrada = false;
                boolean cartaRepitida = false;
                String carta = in.nextLine();

                for(int j = 0; j < deck2.size(); j++) {
                    if (carta.equals(deck1.getCarta(j).getNome())) {
                        cartaRepitida = true;
                        break;
                    }
                }

                for (int j = 0; j < deck.size(); j++) {
                    if (carta.equals(deck.getCarta(j).getNome())) {
                        deck2.addCard(deck.getCarta(j));
                        cartaEncontrada = true;
                        break;
                    }
                }
                if (cartaEncontrada && !cartaRepitida){
                    System.out.println("Carta adicionada com sucesso!");
                    i++;
                }
                else if(cartaRepitida){
                    System.out.println("Carta repitida!");
                }
                else{
                    System.out.println("Carta nao encontrada!");
                }
            }



            // COISAS DA INTERFACE ABAIXO
            JFrame  frame = new JFrame();
            frame.setSize(1000, 800);
            frame.setTitle("Crônicas de Arcana");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);


            ImageIcon imagem = new ImageIcon("icone_glico.ico");
            frame.setIconImage(imagem.getImage());

            JPanel panelJogador1 = new JPanel();
            panelJogador1.setBackground(Color.WHITE);
            panelJogador1.setBounds(0, 0, 1000, 400);
            panelJogador1.setLayout(null);

            JPanel panelJogador2 = new JPanel();
            panelJogador2.setBackground(Color.GRAY);
            panelJogador2.setBounds(0, 365, 1000, 400);
            panelJogador2.setLayout(null);


            JLabel labelJogador1 = new JLabel();
            labelJogador1.setText("Jogador 1");
            labelJogador1.setForeground(Color.gray);
            labelJogador1.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));


            JLabel labelJogador2 = new JLabel();
            labelJogador2.setText("Jogador 2");
            labelJogador2.setForeground(Color.WHITE);
            labelJogador2.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));



            labelJogador1.setBounds(450, 0, 100, 50);
            labelJogador2.setBounds(450, 350, 100, 50);

            frame.add(panelJogador1);
            frame.add(panelJogador2);

            panelJogador1.add(labelJogador1);
            panelJogador2.add(labelJogador2);

            frame.setVisible(true);

        }

    }


