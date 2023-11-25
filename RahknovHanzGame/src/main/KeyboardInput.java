package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener{

    public boolean UpKey, DownKey, LeftKey, RightKey; 

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Input = e.getKeyCode();

        if (Input == KeyEvent.VK_W) {
            UpKey = true;
            
        }
        if (Input == KeyEvent.VK_A) {
            LeftKey = true;
            
        }
        if (Input == KeyEvent.VK_S) {
            DownKey = true;
            
        }
        if (Input == KeyEvent.VK_D) {
            RightKey = true;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int Input = e.getKeyCode();
        if (Input == KeyEvent.VK_W) {
            UpKey = false;
            
        }
        if (Input == KeyEvent.VK_A) {
            LeftKey = false;
            
        }
        if (Input == KeyEvent.VK_S) {
            DownKey = false;
            
        }
        if (Input == KeyEvent.VK_D) {
            RightKey = false;
            
        }
    }

    
}
