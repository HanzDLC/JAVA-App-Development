package main;
import javax.swing.JFrame;
public class Main {

    public static void main(String[] args) {
       JFrame mainWindow = new JFrame();
       mainWindow.setResizable(false);
       mainWindow.setTitle("RakhnovHanzGame");

       GamePanel gamePanel = new GamePanel(); //Calling the GamePanel Class
       mainWindow.add(gamePanel);
       mainWindow.pack();

       mainWindow.setVisible(true);   
       mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       gamePanel.startGameThread();
    }
}

