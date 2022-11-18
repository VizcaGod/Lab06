package presentation;

import domain.AManufacturing;
import domain.Thing;

import javax.swing.*;
import java.awt.*;

class FotoAManufacturing extends JPanel {
    private final AManufacturingGUI gui;

    public FotoAManufacturing(AManufacturingGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(AManufacturingGUI.SIDE *gui.size +10, AManufacturingGUI.SIDE *gui.size +10));
    }


    public void paintComponent(Graphics g){
        AManufacturing aManufacturing = gui.getaManufacturing();
        super.paintComponent(g);

        for (int c=0;c<=aManufacturing.getSize();c++){
            g.drawLine(c* AManufacturingGUI.SIDE,0,c* AManufacturingGUI.SIDE,aManufacturing.getSize()*
                    AManufacturingGUI.SIDE);
        }
        for (int f=0;f<=aManufacturing.getSize();f++){
            g.drawLine(0,f* AManufacturingGUI.SIDE,aManufacturing.getSize()* AManufacturingGUI.SIDE,
                    f* AManufacturingGUI.SIDE);
        }
        for (int f=0;f<aManufacturing.getSize();f++){
            for(int c=0;c<aManufacturing.getSize();c++){
                if (aManufacturing.getThing(f,c)!=null){
                    g.setColor(aManufacturing.getThing(f,c).getColor());
                    if (aManufacturing.getThing(f,c).shape()== Thing.SQUARE){
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillRoundRect(AManufacturingGUI.SIDE *c+1, AManufacturingGUI.SIDE *f+1,
                                    AManufacturingGUI.SIDE -2,
                                    AManufacturingGUI.SIDE -2,2,2);
                        }else{
                            g.drawRoundRect(AManufacturingGUI.SIDE *c+1, AManufacturingGUI.SIDE *f+1,
                                    AManufacturingGUI.SIDE -2,
                                    AManufacturingGUI.SIDE -2,2,2);
                        }
                    }else {
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillOval(AManufacturingGUI.SIDE *c+1, AManufacturingGUI.SIDE *f+1,
                                    AManufacturingGUI.SIDE -2, AManufacturingGUI.SIDE -2);
                        } else {
                            g.drawOval(AManufacturingGUI.SIDE *c+1, AManufacturingGUI.SIDE *f+1,
                                    AManufacturingGUI.SIDE -2, AManufacturingGUI.SIDE -2);
                        }
                    }
                }
            }
        }
    }
}