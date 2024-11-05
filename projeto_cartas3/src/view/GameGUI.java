package view;

import javax.swing.*;
import java.awt.*;

public class GameGUI {
    public GameGUI() {

        JFrame frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setTitle("Crônicas de Arcana");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        ImageIcon imagem = new ImageIcon("icone_glico.ico");
        frame.setIconImage(imagem.getImage());

        JPanel panelJogador1 = createPlayerPanel("Jogador 1", Color.WHITE, Color.GRAY, 0);
        JPanel panelJogador2 = createPlayerPanel("Jogador 2", Color.GRAY, Color.WHITE, 365);

        frame.add(panelJogador1);
        frame.add(panelJogador2);

        frame.setVisible(true);
    }

    private JPanel createPlayerPanel(String playerName, Color bgColor, Color fgColor, int y) {
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        panel.setBounds(0, y, 1000, 400);
        panel.setLayout(null);

        JLabel label = new JLabel();
        label.setText(playerName);
        label.setForeground(fgColor);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setBounds(450, (y == 0 ? 0 : 350), 100, 50);

        panel.add(label);
        return panel;
    }
}
