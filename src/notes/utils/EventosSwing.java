package utils;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class EventosSwing  extends JFrame{

    public void EventosSwing (){
        /*
         * Hemos añadido un MouseMotionListener y no un KeyListener porque de esta manera se controla a la vez el
         * raton y el la tecla Ctrl.
         * De esta forma podemos tener informacion de las coordenadas que se encuentra el raton al pulsar Ctrl, por ejemplo (no en este ejemplo)
         * */
        addMouseMotionListener( new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if(e.isControlDown()) //Cuando se pulse la tecla Ctrl
                    System.out.println("Has pulsado  CTRL MouseMotionListener");
            }
        });

        /*
        * Solo hace lo que le digamos cuando pulsemos F1 y sin tener en cuenta otra cosa
        * */
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyCode()== KeyEvent.VK_F1)
                    System.out.println("Has pulsado F1 keyListener");
            }
        });
    }
}
