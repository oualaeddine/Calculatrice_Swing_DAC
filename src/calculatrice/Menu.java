package calculatrice;

import calculatrice.scientifique.Calculatrice;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel container = new JPanel();
    JButton std = new JButton("Standard"), sci = new JButton("Scientifique");


    public Menu() throws HeadlessException {
        this.setSize(120, 115);
        this.setTitle("Calculette");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //On initialise le conteneur avec tous les composants
        initComposant();
        //On ajoute le conteneur
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void initComposant() {
        container.add(sci);
        container.add(std);
        container.setBorder(new EmptyBorder(5, 5, 5, 5));
        initListeners();
    }

    private void initListeners() {
        sci.addActionListener(e -> new Calculatrice());
        std.addActionListener(e -> new calculatrice.standard.Calculatrice());
    }
}
