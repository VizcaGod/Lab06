package presentation;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class AManufacturingGUI extends JFrame{  
    public static final int SIDE=11;

    public final int size;
    private JButton ticTacButton;
    private FotoAManufacturing photo;
    private final AManufacturing aManufacturing;
    private JMenuBar barraMenu;
    private JMenuItem newItem;
    private JMenuItem openItem;
    private JMenuItem saveAsItem;
    private JMenuItem exportAsItem;
    private JMenuItem importItem;
    private JMenuItem exitItem;
    private JMenu archivo;
    
    private AManufacturingGUI() {
        aManufacturing=new AManufacturing();
        size =aManufacturing.getSize();
        prepareElements();
        prepareActions();
    }

    private void raiseError(String message) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
    private void prepareElements() {
        setTitle("AManufacturing celular");
        photo=new FotoAManufacturing(this);
        ticTacButton=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo,BorderLayout.NORTH);
        add(ticTacButton,BorderLayout.SOUTH);
        setSize(new Dimension(SIDE* size +15,SIDE* size +72));
        setResizable(false);
        photo.repaint();
    }

    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ticTacButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ticTacButtonAction();
                }
            });
    }
    private void ticTacButtonAction() {
        aManufacturing.ticTac();
        photo.repaint();
    }

    public AManufacturing getaManufacturing(){
        return aManufacturing;
    }
    
    public static void main(String[] args) {
        AManufacturingGUI ca=new AManufacturingGUI();
        ca.setVisible(true);
    }

    private void opcionAbra(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
    }

}

