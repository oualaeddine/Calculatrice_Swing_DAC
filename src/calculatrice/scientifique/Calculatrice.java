package calculatrice.scientifique;

import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//@SuppressWarnings("ALL")
@SuppressWarnings("deprecation")
public class Calculatrice extends JFrame implements ActionListener, ItemListener {
    //JFrame frame=new JFrame();On peut ne pas l'inserer si on fait extends JFrame
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b, bexp, bc, bcl, bMult, bDiv, bSom, bSoust;
    private JButton bRes, bOff, bX1Y, b1X, bpm, bSqrt, bLog, bRand, bnCr, bnAr, bFact, bSin, bCos;
    private JButton bTan, bPuis, bX2, b10x, bEx, bF, bE, bD, bC, bB, bA, b2ndF;
    private JRadioButton Scie, Norm, Bin, Dec, Oct, Hex;
    private JPanel pTxt, p2, p3;
    private JTextField txt;
    private double xp = 1, xs = 0, aux = 0;
    private boolean op = false, mult = false, div = false, som = false, soust = false, init = true;
    private boolean dec = true, bin = false, oct = false, hex = false, YX = false, X1Y = false;
    private boolean nAr = false, nCr = false, shift = false, virg = false;

    public Calculatrice() {
        super("Calculatrice");
        initButtons();
        initPreferedSizes();
        txt = new JTextField("0");
        txt.setPreferredSize(new Dimension(440, 35));
        txt.setHorizontalAlignment(SwingConstants.RIGHT);
        txt.setBackground(Color.black);
        txt.setForeground(Color.GREEN);
        txt.setFont(new Font("DIALOG", Font.ITALIC, 12));
        // Declaration des Panel et leurs contenues
        p2 = new JPanel(new GridLayout(1, 1));
        p2.add(initNormPanel());
        p3 = new JPanel(new GridLayout(1, 1));
        p3.add(initSciPanel());
        initTextPanel();
        initButtonsListenners();
        customizeWindow();
        Scie.doClick();
    }

    private void customizeWindow() {
        // Mise en forme de la fenetre
        // ImageIcon image=new ImageIcon("Clock.png");
        // this.setIconImage(image.getImage());
        this.setSize(new Dimension(452, 240));
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(pTxt);
        this.getContentPane().add(p2);
        this.setLocation(300, 100);
        this.setCursor(12);
        this.setResizable(false);
        this.show();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void initPreferedSizes() {
        // Definir la taille prÃ©fÃ©rer des composants
        Dimension defDim = new Dimension(80, 30);
        b0.setPreferredSize(defDim);
        b1.setPreferredSize(defDim);
        b2.setPreferredSize(defDim);
        b3.setPreferredSize(defDim);
        b4.setPreferredSize(defDim);
        b5.setPreferredSize(defDim);
        b6.setPreferredSize(defDim);
        b7.setPreferredSize(defDim);
        b8.setPreferredSize(defDim);
        b9.setPreferredSize(defDim);
        b.setPreferredSize(defDim);
        bexp.setPreferredSize(defDim);
        bDiv.setPreferredSize(defDim);
        bSom.setPreferredSize(defDim);
        bSoust.setPreferredSize(defDim);
        bRes.setPreferredSize(new Dimension(165, 30));
        bX1Y.setPreferredSize(defDim);
        b1X.setPreferredSize(defDim);
        bpm.setPreferredSize(defDim);
        bMult.setPreferredSize(defDim);
        bSqrt.setPreferredSize(defDim);
        bLog.setPreferredSize(defDim);
        bRand.setPreferredSize(defDim);
        bnCr.setPreferredSize(defDim);
        bnAr.setPreferredSize(defDim);
        bFact.setPreferredSize(defDim);
        bCos.setPreferredSize(defDim);
        bPuis.setPreferredSize(defDim);
        bX2.setPreferredSize(defDim);
        b10x.setPreferredSize(defDim);
        bEx.setPreferredSize(defDim);
        bF.setPreferredSize(defDim);
        bE.setPreferredSize(defDim);
        bD.setPreferredSize(defDim);
        bC.setPreferredSize(defDim);
        bB.setPreferredSize(defDim);
        bA.setPreferredSize(defDim);
        b2ndF.setPreferredSize(defDim);
        Scie.setPreferredSize(defDim);
        Norm.setPreferredSize(defDim);
        Bin.setPreferredSize(defDim);
        Dec.setPreferredSize(defDim);
        Oct.setPreferredSize(defDim);
        Hex.setPreferredSize(defDim);
        bSin.setPreferredSize(defDim);
        bc.setPreferredSize(defDim);
        bOff.setPreferredSize(defDim);
        bcl.setPreferredSize(defDim);
        bTan.setPreferredSize(defDim);
    }

    private void initButtons() {
        // Initialisation des bouton et champs de saisie
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b = new JButton(".");
        bexp = new JButton("Pi");
        bX1Y = new JButton("X^(1/Y)");
        bpm = new JButton("+/-");
        bMult = new JButton("*");
        bDiv = new JButton("/");
        bSom = new JButton("+");
        bSoust = new JButton("-");
        bRes = new JButton("=");
        b1X = new JButton("1/X");
        bSqrt = new JButton("Rac");
        bLog = new JButton("Ln/Log");
        bRand = new JButton("Rand");
        bnCr = new JButton("nCr");
        bnAr = new JButton("nAr");
        bFact = new JButton("n!");
        bSin = new JButton("Sin");
        bCos = new JButton("Cos");
        bTan = new JButton("Tan");
        bPuis = new JButton("Y^X");
        bX2 = new JButton("X^2");
        b10x = new JButton("10^x");
        bEx = new JButton("e^x");
        bF = new JButton("F");
        bE = new JButton("E");
        bD = new JButton("D");
        bC = new JButton("C");
        bB = new JButton("B");
        bA = new JButton("A");
        b2ndF = new JButton("2nF");
        bc = new JButton("C");
        bOff = new JButton("OFF");
        bcl = new JButton("Del");
        Scie = new JRadioButton("Sci");
        Norm = new JRadioButton("Std");
        Bin = new JRadioButton("Bin");
        Dec = new JRadioButton("Dec");
        Oct = new JRadioButton("Oct");
        Hex = new JRadioButton("Hex");
        ButtonGroup bg1 = new ButtonGroup();
        ButtonGroup bg2 = new ButtonGroup();
        bg1.add(Norm);
        bg1.add(Scie);
        bg2.add(Bin);
        bg2.add(Oct);
        bg2.add(Hex);
        bg2.add(Dec);
        Dec.setSelected(true);
        Norm.setSelected(true);
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);
        bD.setEnabled(false);
        bE.setEnabled(false);
        bF.setEnabled(false);

    }

    private JPanel initNormPanel() {
        JPanel pNorm = new JPanel();
        pNorm.add(b7);
        pNorm.add(b8);
        pNorm.add(b9);
        pNorm.add(bexp);
        pNorm.add(bSqrt);
        pNorm.add(b4);
        pNorm.add(b5);
        pNorm.add(b6);
        pNorm.add(bMult);
        pNorm.add(bDiv);
        pNorm.add(b1);
        pNorm.add(b2);
        pNorm.add(b3);
        pNorm.add(bSom);
        pNorm.add(bSoust);
        pNorm.add(b0);
        pNorm.add(b);
        pNorm.add(bpm);
        pNorm.add(bRes);
        return pNorm;
    }

    private void initTextPanel() {
        pTxt = new JPanel();
        pTxt.add(txt);
        pTxt.add(initStdPanel());
    }

    private JPanel initSciPanel() {
        JPanel pSci = new JPanel();
        pSci.add(Bin);
        pSci.add(Oct);
        pSci.add(Hex);
        pSci.add(Dec);
        pSci.add(b2ndF);
        pSci.add(bA);
        pSci.add(bB);
        pSci.add(bC);
        pSci.add(bD);
        pSci.add(bE);
        pSci.add(bPuis);
        pSci.add(bX2);
        pSci.add(b10x);
        pSci.add(bEx);
        pSci.add(bF);
        pSci.add(bFact);
        pSci.add(bLog);
        pSci.add(bSin);
        pSci.add(bCos);
        pSci.add(bTan);
        pSci.add(bX1Y);
        pSci.add(b1X);
        pSci.add(bRand);
        pSci.add(bnCr);
        pSci.add(bnAr);
        return pSci;
    }

    private JPanel initStdPanel() {
        JPanel pStd = new JPanel();
        pStd.add(Scie);
        pStd.add(Norm);
        pStd.add(bcl);
        pStd.add(bc);
        pStd.add(bOff);

        return pStd;
    }

    private void initButtonsListenners() {
        // Ajout des Ã©couteurs aux deffirents boutons
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b.addActionListener(this);
        bexp.addActionListener(this);
        b1X.addActionListener(this);
        bpm.addActionListener(this);
        bMult.addActionListener(this);
        bDiv.addActionListener(this);
        bSom.addActionListener(this);
        bSoust.addActionListener(this);
        bRes.addActionListener(this);
        bX1Y.addActionListener(this);
        bc.addActionListener(this);
        bcl.addActionListener(this);
        bOff.addActionListener(this);
        bSqrt.addActionListener(this);
        bLog.addActionListener(this);
        bRand.addActionListener(this);
        bnCr.addActionListener(this);
        bnAr.addActionListener(this);
        bFact.addActionListener(this);
        bSin.addActionListener(this);
        bCos.addActionListener(this);
        bTan.addActionListener(this);
        bPuis.addActionListener(this);
        bX2.addActionListener(this);
        b10x.addActionListener(this);
        bEx.addActionListener(this);
        b2ndF.addActionListener(this);
        bA.addActionListener(this);
        bB.addActionListener(this);
        bC.addActionListener(this);
        bD.addActionListener(this);
        bE.addActionListener(this);
        bF.addActionListener(this);
        Scie.addItemListener(this);
        Norm.addItemListener(this);
        Bin.addItemListener(this);
        Dec.addItemListener(this);
        Oct.addItemListener(this);
        Hex.addItemListener(this);
    }

    private void activatehex(boolean b) {
        bA.setEnabled(b);
        bB.setEnabled(b);
        bC.setEnabled(b);
        bD.setEnabled(b);
        bE.setEnabled(b);
        bF.setEnabled(b);
    }

    private void activateP2P3(boolean v) {
        b0.setEnabled(v);
        b1.setEnabled(v);
        b2.setEnabled(v);
        b3.setEnabled(v);
        b4.setEnabled(v);
        b5.setEnabled(v);
        b6.setEnabled(v);
        b7.setEnabled(v);
        b8.setEnabled(v);
        b9.setEnabled(v);
        b.setEnabled(v);
        bexp.setEnabled(v);
        bMult.setEnabled(v);
        bDiv.setEnabled(v);
        bSom.setEnabled(v);
        bSoust.setEnabled(v);
        bRes.setEnabled(v);
        bX1Y.setEnabled(v);
        b1X.setEnabled(v);
        bpm.setEnabled(v);
        bSqrt.setEnabled(v);
        bLog.setEnabled(v);
        bRand.setEnabled(v);
        bnCr.setEnabled(v);
        bnAr.setEnabled(v);
        bFact.setEnabled(v);
        bSin.setEnabled(v);
        bCos.setEnabled(v);
        bTan.setEnabled(v);
        bPuis.setEnabled(v);
        bX2.setEnabled(v);
        b10x.setEnabled(v);
        bEx.setEnabled(v);
        b2ndF.setEnabled(v);
        Scie.setEnabled(v);
        Norm.setEnabled(v);
        Bin.setEnabled(v);
        Dec.setEnabled(v);
        Oct.setEnabled(v);
        Hex.setEnabled(v);
        bA.setEnabled(v);
        bB.setEnabled(v);
        bC.setEnabled(v);
        bD.setEnabled(v);
        bE.setEnabled(v);
        bF.setEnabled(v);
    }

    private void activateOp(boolean v) {
        b.setEnabled(v);
        bexp.setEnabled(v);
        bMult.setEnabled(v);
        bDiv.setEnabled(v);
        bSom.setEnabled(v);
        bSoust.setEnabled(v);
        bRes.setEnabled(v);
        bX1Y.setEnabled(v);
        b1X.setEnabled(v);
        bpm.setEnabled(v);
        bSqrt.setEnabled(v);
        bLog.setEnabled(v);
        bRand.setEnabled(v);
        bnCr.setEnabled(v);
        bnAr.setEnabled(v);
        bFact.setEnabled(v);
        bSin.setEnabled(v);
        bCos.setEnabled(v);
        bTan.setEnabled(v);
        bPuis.setEnabled(v);
        bX2.setEnabled(v);
        b10x.setEnabled(v);
        bEx.setEnabled(v);
        b2ndF.setEnabled(v);
    }

    private int detBaseSource() {
        if (dec) return 10;
        else if (bin) return 2;
        else if (oct) return 8;
        else return 16;
    }

    private int detBaseDestination(Object src) {
        if (src == Dec) {
            dec = true;
            bin = false;
            oct = false;
            hex = false;
            activatehex(false);
            activateOp(true);
            b0.setEnabled(true);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            return 10;
        } else if (src == Bin) {
            dec = false;
            bin = true;
            oct = false;
            hex = false;
            activatehex(false);
            activateOp(false);
            b0.setEnabled(true);
            b1.setEnabled(true);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            return 2;
        } else if (src == Oct) {
            dec = false;
            bin = false;
            oct = true;
            hex = false;
            activatehex(false);
            activateOp(false);
            b0.setEnabled(true);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(false);
            b9.setEnabled(false);
            return 8;
        } else {
            dec = false;
            bin = false;
            oct = false;
            hex = true;
            activatehex(true);
            activateOp(false);
            b0.setEnabled(true);
            b1.setEnabled(true);
            b2.setEnabled(true);
            b3.setEnabled(true);
            b4.setEnabled(true);
            b5.setEnabled(true);
            b6.setEnabled(true);
            b7.setEnabled(true);
            b8.setEnabled(true);
            b9.setEnabled(true);
            return 16;
        }
    }

    private int conversionCarct(char c) {
        if (c == 'F') return 15;
        else if (c == 'E') return 14;
        else if (c == 'D') return 13;
        else if (c == 'C') return 12;
        else if (c == 'B') return 11;
        else if (c == 'A') return 10;
        else return (Character.getNumericValue(c));
    }

    private char toHexaCarct(int x) {
        if (x == 10) return 'A';
        else if (x == 11) return 'B';
        else if (x == 12) return 'C';
        else if (x == 13) return 'D';
        else if (x == 14) return 'E';
        else return 'F';
    }

    private boolean isValide(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' || s.charAt(i) == '-')
                return false;
        }
        return true;
    }

    private int toDec(String dep, int bs) {
        int i = (dep.length()) - 1;
        int puis = 0;
        int res = 0;
        while (i >= 0) {
            res = res + conversionCarct(dep.charAt(i)) * ((int) (Math.pow(bs, puis)));
            puis++;
            i--;
        }
        return res;
    }

    private String fromDec(String dep, int bd) {
        StringBuilder s = new StringBuilder();
        int aux = Integer.parseInt(dep);
        while (aux / bd != 0) {
            if (aux % bd < 10) {
                s.insert(0, (aux % bd));
            } else {
                s.insert(0, toHexaCarct(aux % bd));
            }
            aux = aux / bd;
        }
        if (aux % bd < 10) {
            s.insert(0, (aux % bd));
        } else {
            s.insert(0, toHexaCarct(aux % bd));
        }
        return s.toString();
    }

    private void Resultat() {
        double x2 = Double.parseDouble(txt.getText());
        if (mult) {
            txt.setText("" + (xp * x2));
            xp = Double.parseDouble(txt.getText());
        } else if (div) {
            if (x2 != 0) {
                txt.setText("" + (xp / x2));
                xp = Double.parseDouble(txt.getText());
            } else {
                activateP2P3(false);
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("  ERROR !!  DIVISION   PAR   ZERO   IMPOSSIBLE  ");
            }
        } else if (som) {
            txt.setText("" + (xs + x2));
            xs = Double.parseDouble(txt.getText());
        } else if (soust) {
            txt.setText("" + (xs - x2));
            xs = Double.parseDouble(txt.getText());
        } else if (YX) {
            double res = Math.pow(aux, x2);
            txt.setText("" + res);
        } else if (nAr) {
            if ((aux >= x2) && (aux >= 0) && (x2 >= 0)) {
                double res = (fact(aux) / fact((aux - x2)));
                txt.setText("" + res);
            } else {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("  ERROR!!  RULE  :  \"  n  doit  etre >= r  et  n >= 0  et  r >= 0  \" ");
                activateP2P3(false);
            }
        } else if (nCr) {
            if ((aux >= x2) && (aux >= 0) && (x2 >= 0)) {
                double res = (fact(aux) / (fact(x2) * fact((aux - x2))));
                txt.setText("" + res);
            } else {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText(" ERROR!!   RULE  :  \"  n  doit  etre  >= r  et  n  >= 0  et  r  >= 0  \" ");
                activateP2P3(false);
            }
        } else if (X1Y) {
            if (x2 != 0) {
                double res = Math.pow(aux, (1 / x2));
                txt.setText("" + res);
            } else {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText(" ERROR!!  DEUXIEME  NOMBRE  DOIT  ETRE  DIFFERENT  DE  0 ");
                activateP2P3(false);
            }
        }
        init = false;
        virg = false;
    }

    private double fact(double x) {
        double res = 1;
        if (x >= 0) {
            for (int i = 2; i <= x; i++) {
                res = res * i;
            }
            return res;
        } else return 0;
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        JButton baux = (JButton) src;
        ////////////*********Bouton des chiffres********//////////////
        if ((src == b0) || src == b1 || src == b2 || src == b3 || src == b4 || src == b5 || src == b6 || src == b7 || src == b8 || src == b9 || src == bA || src == bB || src == bC || src == bD || src == bE || src == bF) {
            if (!op) txt.setText(txt.getText() + baux.getLabel());
            else {
                txt.setText(baux.getLabel());
                op = false;
            }
        }
        ////////////*********Bouton virgule********//////////////
        else if (src == b) {
            if (!virg) {
                txt.setText(txt.getText() + ".");
                virg = true;
            }
        }
        ////////////*********Bouton Pi********//////////////
        else if (src == bexp) {
            txt.setText("" + Math.PI);
            virg = true;
        }
        ////////////*********Bouton clear********//////////////
        else if (src == bc) {
            txt.setText("0");
            xp = 1;
            xs = 0;
            init = true;
            aux = 0;
            shift = false;
            op = false;
            X1Y = true;
            mult = false;
            div = false;
            som = false;
            soust = false;
            nAr = false;
            nCr = false;
            activateP2P3(true);
            activatehex(false);
            Dec.setSelected(true);
            virg = false;
            txt.setBackground(Color.black);
            txt.setForeground(Color.GREEN);
        }
        ////////////*********Bouton de +/-********//////////////
        else if (src == bpm)
            txt.setText("" + Double.parseDouble(txt.getText()) * -1);
        else if (src == bcl)
            txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

            ////////////*********Multiplication********//////////////
        else if (src == bMult) {
            try {
                something();
                op = true;
                mult = true;
                div = false;
                som = false;
                soust = false;
                YX = false;
                nAr = false;
                nCr = false;
                X1Y = true;
            } catch (NumberFormatException execp) {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
                activateP2P3(false);
            }
        }
        ////////////*******Division******////////////
        else if (src == bDiv) {
            try {
                something();
                op = true;
                mult = false;
                div = true;
                som = false;
                soust = false;
                YX = false;
                nAr = false;
                nCr = false;
                X1Y = true;
            } catch (NumberFormatException execp) {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
                activateP2P3(false);
            }
        }
        ////////////////***********Somme**********////////////////
        else if (src == bSom) {
            try {
                something();
                op = true;
                mult = false;
                div = false;
                som = true;
                soust = false;
                YX = false;
                nAr = false;
                nCr = false;
                X1Y = true;
            } catch (NumberFormatException execp) {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
                activateP2P3(false);
            }
        }
        ////////////////************Soustraction***********//////////////////
        else if (src == bSoust) {
            try {
                something();
                op = true;
                mult = false;
                div = false;
                som = false;
                soust = true;
                YX = false;
                nAr = false;
                nCr = false;
                X1Y = true;
            } catch (NumberFormatException execp) {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE ");
                activateP2P3(false);
            }
        }
        //////////////////**************Resultat*************//////////////////
        else if (e.getSource() == bRes) {
            Resultat();
            init = true;
            virg = false;
        }
        //////////************Les fonction Scientifiques********/////////////
        else if (src == b2ndF) {
            shift = true;
        } else if (src == bPuis) {
            aux = Double.parseDouble(txt.getText());
            YX = true;
            init = false;
            nAr = false;
            nCr = false;
            X1Y = true;
            op = true;
            mult = false;
            div = false;
            som = false;
            soust = false;
        } else if (src == b10x) {
            double x = Double.parseDouble(txt.getText());
            double res = Math.pow(10, x);
            txt.setText("" + res);
        } else if (src == bX2) {
            double x = Double.parseDouble(txt.getText());
            double res = Math.pow(x, 2);
            txt.setText("" + res);
        } else if (src == bX1Y) {
            aux = Double.parseDouble(txt.getText());
            YX = false;
            init = false;
            nAr = false;
            nCr = false;
            X1Y = true;
            op = true;
            mult = false;
            div = false;
            som = false;
            soust = false;
        } else if (src == b1X) {
            double x = Double.parseDouble(txt.getText());
            if (x != 0) {
                txt.setText("" + (1 / x));
            } else {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText(" ERROR!!  DIVISION  PAR  ZERO  IMPOSSIBLE ");
                activateP2P3(false);
            }
        } else if (src == bLog) {
            double x = Double.parseDouble(txt.getText());
            if (!shift && x > 0) {
                double res = Math.log(x);
                txt.setText("" + res);
            } else if (shift && x > 0) {
                double res = Math.log10(x);
                txt.setText("" + res);
                shift = false;
            } else if (x <= 0) {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText(" ERROR!!  RULE : \"  X  DOIT  ETRE  >  A  ZERO  \" ");
                activateP2P3(false);
            }
        } else if (src == bEx) {
            double x = Double.parseDouble(txt.getText());
            double res = Math.exp(x);
            txt.setText("" + res);
        } else if (src == bFact) {


            if (isValide(txt.getText())) {
                double res = fact(Double.parseDouble(txt.getText()));
                txt.setText("" + res);
            } else {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText(" ERROR!!  RULE :  \"  N  DOIT  ETRE  UN ENTIER  >  A  ZERO \" ");
                activateP2P3(false);
            }
        } else if (src == bSin) {
            if (!shift) {
                double x = Math.toRadians(Double.parseDouble(txt.getText()));
                double res = Math.sin(x);
                txt.setText("" + res);
            } else {
                double x = Double.parseDouble(txt.getText());
                double res = Math.asin(x);
                txt.setText("" + Math.toDegrees(res));
                shift = false;
            }
        } else if (src == bCos) {
            if (!shift) {
                double x = Math.toRadians(Double.parseDouble(txt.getText()));
                double res = Math.cos(x);
                txt.setText("" + res);
            } else {
                double x = Double.parseDouble(txt.getText());
                double res = Math.acos(x);
                txt.setText("" + Math.toDegrees(res));
                shift = false;
            }
        } else if (src == bTan) {
            if (!shift) {
                double x = Math.toRadians(Double.parseDouble(txt.getText()));
                double res = Math.tan(x);
                txt.setText("" + res);
            } else {
                double x = Double.parseDouble(txt.getText());
                double res = Math.atan(x);
                txt.setText("" + Math.toDegrees(res));
                shift = false;
            }
        } else if (src == bSqrt) {
            double x = Double.parseDouble(txt.getText());
            if (x >= 0) {
                double res = Math.sqrt(x);
                txt.setText("" + res);
            } else {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText(" ERROR!!  RULE  :  \"  X  DOIT  ETRE  >  A  ZERO  \" ");
                activateP2P3(false);
            }
        } else if (src == bRand) {
            double res = Math.random();
            txt.setText("" + res);
        } else if (src == bnAr || src == bnCr) {
            aux = Double.parseDouble(txt.getText());
            nAr = true;
            YX = false;
            init = false;
            op = true;
            mult = false;
            div = false;
            som = false;
            soust = false;
        }
        /////////************FIN des Fonctions Scientifiques********/////////

        else if (src == bOff) System.exit(0);
    }

    private void something() {
        if (init || op) {
            xp = (Double.parseDouble(txt.getText()));
            init = false;
            virg = false;
            txt.setText("" + xp);
        } else {
            Resultat();
            xp = (Double.parseDouble(txt.getText()));
        }
    }

    public void itemStateChanged(ItemEvent i) {
        Object srci = i.getSource();
        if (srci == Scie) {
            this.resize(452, 550);
            this.getContentPane().setLayout(new GridLayout(3, 1));
            this.getContentPane().add(pTxt);
            this.getContentPane().add(p3);
            this.getContentPane().add(p2);
            this.setLocation(300, 100);

        } else if (srci == Norm) {
            //Calculatrice c=new Calculatrice();
            this.getContentPane().removeAll();
            this.getContentPane().setLayout(new GridLayout(2, 1));
            this.resize(452, 240);
            this.getContentPane().add(pTxt);
            this.getContentPane().add(p2);
            this.setLocation(300, 100);
            //	c.show();
            //	this.dispose();
        } else if (dec) {
            activateOp(false);
            String dep = txt.getText();
            try {
                String s = fromDec(dep, detBaseDestination(srci));
                txt.setText(s);
            } catch (NumberFormatException e) {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE  ");
                activateP2P3(false);
            }
        } else if (bin || oct || hex) {
            try {
                int x = toDec(txt.getText(), detBaseSource());
                String s = "" + x;
                txt.setText(fromDec(s, detBaseDestination(srci)));
            } catch (NumberFormatException e) {
                txt.setBackground(Color.LIGHT_GRAY);
                txt.setForeground(Color.RED);
                txt.setText("ERROR :  CONVERTION  AVEC  VERGULE  FLOTTANTE  NON  SUPPORTEE  ");
                activateP2P3(false);
            }
        }
    }
}