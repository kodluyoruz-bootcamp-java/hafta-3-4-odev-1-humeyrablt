package CityCodeMap.Key_Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            System.out.println("Key Pressed " + KeyEvent.getKeyText(e.getKeyCode()));
            if("Right".equals(KeyEvent.getKeyText(e.getKeyCode())))
                System.out.println("Right Button Detected");
            if(e.getKeyCode()==KeyEvent.VK_CONTROL) //& e.getKeyCode()== KeyEvent.VK_X)
                System.exit(0);
        }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
