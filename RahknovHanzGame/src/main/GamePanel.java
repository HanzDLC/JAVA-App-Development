package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable {
    final int MainSize = 16; //character size
    final int ScaleSize = 3; //character scaling 
    final int TileSize = MainSize * ScaleSize; 
    final int ScreenColumn = 16; // Y value for tiles
    final int ScreenRow = 12;    // X value for tiles 
    final int ScreenWidth = TileSize * ScreenColumn;
    final int ScreenHeight = TileSize * ScreenRow;
    
    int FPS = 60;

    KeyboardInput keyboardInput = new KeyboardInput();

    Thread gameThread;

    int PlayerPositionX = 50; // fixed x position of character
    int PlayerPositionY = 50; // fixed y position of character
    int playerSpeed = 3; // Pixels skipped by the main character to move 

    public GamePanel(){
        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboardInput);
        this.setFocusable(true);

    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start(); 

    }

    @Override
    public void run() {

       double Interval = 1000000000/FPS;
       double delta = 0;
       long lastTime = System.nanoTime();
       long currentTime;
       long timer = 0 ;
       int drawCount = 0;

       while(gameThread != null){

       currentTime = System.nanoTime();
       delta += (currentTime - lastTime)/Interval;
       timer += (currentTime - lastTime);
       lastTime = currentTime;
       
       if(delta>=1){
             update(); // 1st update: update character position 
             repaint();// 2nd update: update the screen with the updated information 
             delta--;
             drawCount++;
            }
        if (timer >= 1000000000) {
            System.out.println("FPS:"+drawCount);
            drawCount = 0; 
            timer = 0; 
        }
       }
    }

    public void update() {
        if (keyboardInput.UpKey == true) {
            PlayerPositionY -= playerSpeed;
        } else if (keyboardInput.DownKey == true) {
            PlayerPositionY += playerSpeed; 
        } else if (keyboardInput.LeftKey == true) {
            PlayerPositionX -= playerSpeed;
        } else if (keyboardInput.RightKey == true) {
            PlayerPositionX += playerSpeed;
        } 
    }
    
    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graph2D = (Graphics2D)graphics; // Change Graphics graphics to Graphics2D(more functions)
        graph2D.setColor(Color.cyan);
        graph2D.fillRect(PlayerPositionX, PlayerPositionY, TileSize, TileSize); // add a rectangle to the screen with a fixed position 
        graph2D.dispose();
    }
}
