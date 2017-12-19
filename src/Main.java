import calculatrice.Menu;
import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            // select Look and Feel
            UIManager.setLookAndFeel(new DarculaLaf());
            // start application
            new Menu();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
