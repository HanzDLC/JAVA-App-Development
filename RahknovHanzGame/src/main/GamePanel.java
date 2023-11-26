package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;


public class GamePanel extends JPanel implements Runnable {
    final int MainSize = 16; //character size
    final int ScaleSize = 3; //character scaling 
   
    public final int TileSize = MainSize * ScaleSize; 
    public final int ScreenColumn = 16; // Y value for tiles
    public final int ScreenRow = 12;    // X value for tiles 
    public final int ScreenWidth = TileSize * ScreenColumn;
    public final int ScreenHeight = TileSize * ScreenRow;
    
    int FPS = 60;
    TileManager tileManage = new TileManager(this);

    KeyboardInput keyboardInput = new KeyboardInput();
    Thread gameThread;
    Player player = new Player(this, keyboardInput);
    
   


    public GamePanel(){
        this.setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyboardInput);
        this.setFocusable(true);
        startGameThread();

    }
    
    public void startGameThread() {
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
    	player.update();
    	
    }
    
    
    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graph2D = (Graphics2D)graphics; 
        tileManage.draw(graph2D);
        player.draw(graph2D);
        graph2D.dispose();
    }
}
