package makingScreenFrame;

import cipherFunctionalProcess.FunctionalProcess;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;

public class CreateFrame extends JFrame {

    //declaration
    private ImageIcon icon;
    private Container box;
    private JLabel lblEnProptInput1, lblEnComlvlInput2, lblEnPassInput3, lblDeProptInput1, lblDeComlvlInput2, lblDePassInput3, lblOutpt1;
    private Font f;
    private JTextArea taEnPropt1, taDePropt1, taOutpt1;
    private JTextField tfEnComlvl1, tfDeComlvl1;
    private JPasswordField pfEn1, pfDe1;
    private JButton btnEn1, btnDe1;
    private Cursor cursor;
    private JScrollPane scroll;
    private JOptionPane msgBox;
    FunctionalProcess handler = new FunctionalProcess();

    public CreateFrame() {
        setComponents();
    }

    public void callFrame() {
        CreateFrame screen = new CreateFrame();
        screen.setVisible(true);
    }

    public void setComponents() {

        //frame initalized
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(this);

        //set backgroundcolor
        Color brown = new Color(51, 0, 0);
        box = this.getContentPane();
        box.setLayout(null);
        box.setBackground(brown);

        //set manual font attributes
        f = new Font("Arial", Font.BOLD, 18);

        //making hand cursor for button
        cursor = new Cursor(Cursor.HAND_CURSOR);

        //set icon
        icon = new ImageIcon(getClass().getResource("Security.png"));
        this.setIconImage(icon.getImage());

        //software title
        setTitle("CIPHER-Hide your secret");

        /*--------------propting txt from user for encryption-----------------*/
        lblEnProptInput1 = new JLabel("Enter your message here: ");
        lblEnProptInput1.setForeground(Color.white);
        lblEnProptInput1.setBounds(20, 30, 250, 50);
        lblEnProptInput1.setFont(f);
        box.add(lblEnProptInput1);

        taEnPropt1 = new JTextArea();
        taEnPropt1.setFont(f);
        taEnPropt1.setLineWrap(true);
        taEnPropt1.setWrapStyleWord(true);
        scroll = new JScrollPane(taEnPropt1);
        scroll.setBounds(260, 10, 200, 100);
        box.add(scroll);

        /*--------------propting compressed value from user for encryption-----------------*/
        lblEnComlvlInput2 = new JLabel("Compressed level: ");
        lblEnComlvlInput2.setForeground(Color.white);
        lblEnComlvlInput2.setBounds(480, 15, 180, 50);
        lblEnComlvlInput2.setFont(f);
        box.add(lblEnComlvlInput2);

        tfEnComlvl1 = new JTextField();
        tfEnComlvl1.setBounds(650, 15, 100, 50);
        tfEnComlvl1.setToolTipText("Give non fractional positive number,please!");
        tfEnComlvl1.setFont(f);
        box.add(tfEnComlvl1);

        /*--------------propting password from user for encryption-----------------*/
        lblEnPassInput3 = new JLabel("Password: ");
        lblEnPassInput3.setForeground(Color.white);
        lblEnPassInput3.setBounds(480, 70, 150, 50);
        lblEnPassInput3.setFont(f);
        box.add(lblEnPassInput3);

        pfEn1 = new JPasswordField();
        pfEn1.setBounds(600, 70, 150, 50);
        box.add(pfEn1);

        /*--------------button for encryption-----------------*/
        btnEn1 = new JButton("encrypt");
        btnEn1.setBounds(650, 130, 100, 50);
        btnEn1.setCursor(cursor);
        box.add(btnEn1);
        btnEn1.addActionListener(new EncryptButton1Listener());

        lblOutpt1 = new JLabel("Output: ");
        lblOutpt1.setForeground(Color.white);
        lblOutpt1.setBounds(150, 220, 150, 50);
        lblOutpt1.setFont(f);
        box.add(lblOutpt1);

        /*--------------output screen-----------------*/
        taOutpt1 = new JTextArea();
        taOutpt1.setFont(f);
        taOutpt1.setLineWrap(true);
        taOutpt1.setWrapStyleWord(true);
        scroll = new JScrollPane(taOutpt1);
        scroll.setBounds(250, 200, 300, 100);
        box.add(scroll);

        /*--------------propting encrypted txt from user for decryption-----------------*/
        lblDeProptInput1 = new JLabel("Enter encrypted text here: ");
        lblDeProptInput1.setForeground(Color.white);
        lblDeProptInput1.setBounds(20, 380, 250, 50);
        lblDeProptInput1.setFont(f);
        box.add(lblDeProptInput1);

        taDePropt1 = new JTextArea();
        taDePropt1.setFont(f);
        taDePropt1.setLineWrap(true);
        taDePropt1.setWrapStyleWord(true);
        scroll = new JScrollPane(taDePropt1);
        scroll.setBounds(260, 360, 200, 100);
        box.add(scroll);

        /*--------------propting password from user for decryption-----------------*/
        lblDePassInput3 = new JLabel("Password: ");
        lblDePassInput3.setForeground(Color.white);
        lblDePassInput3.setBounds(480, 360, 150, 50);
        lblDePassInput3.setFont(f);
        box.add(lblDePassInput3);

        pfDe1 = new JPasswordField();
        pfDe1.setBounds(600, 360, 150, 50);
        box.add(pfDe1);

        /*--------------propting compressed value from user for decryption-----------------*/
        lblDeComlvlInput2 = new JLabel("Compressed level: ");
        lblDeComlvlInput2.setForeground(Color.white);
        lblDeComlvlInput2.setBounds(480, 430, 180, 50);
        lblDeComlvlInput2.setFont(f);
        box.add(lblDeComlvlInput2);

        tfDeComlvl1 = new JTextField();
        tfDeComlvl1.setBounds(650, 430, 100, 50);
        tfDeComlvl1.setToolTipText("Give non fractional positive number,please!");
        tfDeComlvl1.setFont(f);
        box.add(tfDeComlvl1);

        /*--------------button for decryption-----------------*/
        btnDe1 = new JButton("decrypt");
        btnDe1.setBounds(650, 500, 100, 50);
        btnDe1.setCursor(cursor);
        box.add(btnDe1);
        btnDe1.addActionListener(new DecryptButtonListener());
    }

    /*---------------encryption button action listener------------------*/
    private class EncryptButton1Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //message box dialog
            msgBox = new JOptionPane();

            String filterComLvl = tfEnComlvl1.getText();

            /*filterTxtComFd funtion cheaking compressed value is a positive number or not.
             Also check first left side value is zero(0) or not*/
            boolean isNumber = handler.filterTxtComFd(filterComLvl);

            /*--------form validation condition for encryption system--------------*/
            if (isNumber == false || taEnPropt1.getText().isEmpty() || tfEnComlvl1.getText().isEmpty() || pfEn1.getText().isEmpty() || pfEn1.getText().length() < 6 || pfEn1.getText().length() > 8) {
                msgBox.showMessageDialog(null, "1. All field have to fill with proper information"
                    + "\n2. Give positive value in compressed level field"
                    + "\n3. Don't use '0' at the first left side in compressed level feild"
                    + "\n4. Password character length have to be minimum 6 and maximum 8\n"
                    + "\n[Authority(PSYs0s): CIPHER-Hide your text]", "Warning", JOptionPane.PLAIN_MESSAGE, icon);
            } else {
                String txt = taEnPropt1.getText();
                String compressedLvl = tfEnComlvl1.getText();
                String password = pfEn1.getText();

                /*---calling initialize function in functionalProccess class---*/
                handler.initializedValue(txt, compressedLvl, password);

                /*---calling txtToEncryptTxt function in functionalProccess class to encrypt text---*/
                String encryptTxt[] = handler.txtToEncryptTxt();

                /*---showing encrypted text in output screen by calling setEnTxtOutptBx function-----*/
                setEnTxtOutptBx(encryptTxt, password);
            }
        }
    }

    /*---------------decryption button action listener------------------*/
    private class DecryptButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //message box dialog
            msgBox = new JOptionPane();

            String filterComLvl = tfDeComlvl1.getText();

            /*filterTxtComFd funtion cheaking compressed value is a positive number or not.
             Also check first left side value is zero(0) or not*/
            boolean isNumber = handler.filterTxtComFd(filterComLvl);

            /*--------form validation condition for decryption system--------------*/
            if (isNumber == false || taDePropt1.getText().isEmpty() || tfDeComlvl1.getText().isEmpty() || pfDe1.getText().isEmpty() || pfDe1.getText().length() < 6 || pfDe1.getText().length() > 8) {
                msgBox.showMessageDialog(null, "1. All field have to fill with proper information"
                    + "\n2. Give positive value in compressed level field"
                    + "\n3. Don't use '0' at the first left side in compressed level feild"
                    + "\n4. Password character length have to be minimum 6 and maximum 8\n"
                    + "\n[Authority(PSYs0s): CIPHER-Hide your text]", "Warning", JOptionPane.PLAIN_MESSAGE, icon);
            } else {
                String txt = taDePropt1.getText();
                String pfForDe = pfDe1.getText();
                String compressedLvl = tfDeComlvl1.getText();

                /*---calling initialize function in functionalProccess class---*/
                handler.initializedValue(txt, compressedLvl, pfForDe);

                /*----password compare----*/
                boolean isMatch = handler.isPassMatch();
                if (isMatch) {

                    /*---calling txtToDecryptTxt function in functionalProccess class to decrypt text---*/
                    String decryptTxt = handler.txtToDecryptTxt();

                    /*---showing decrypted text in output screen by calling setDeTxtOutptBx function-----*/
                    setDeTxtOutptBx(decryptTxt);
                } else {
                    msgBox.showMessageDialog(null, "Password didn't match, try again."
                        + "\n[Authority(PSYs0s): CIPHER-Hide your text]", "Warning", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

    /*-----set encrypted text in output screen----*/
    public void setEnTxtOutptBx(String[] en, String p) {

        //secret
        int hiddenP = p.hashCode();
        String hashToStr = Integer.toString(hiddenP / 17395);

        String enTxt = "";

        for (String i : en) {
            enTxt = enTxt + i + " ";
        }
        taEnPropt1.setText("");
        tfEnComlvl1.setText("");
        pfEn1.setText("");
        taOutpt1.setText(enTxt + hashToStr);
    }

    /*-----set decrypted text in output screen----*/
    public void setDeTxtOutptBx(String de) {
        taOutpt1.setText("");
        taOutpt1.setText(de);
        taDePropt1.setText("");
        tfDeComlvl1.setText("");
        pfDe1.setText("");

    }
}
