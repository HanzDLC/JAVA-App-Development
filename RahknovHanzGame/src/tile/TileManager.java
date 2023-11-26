package tile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import main.GamePanel;

public class TileManager {
    GamePanel gp; 
    Tile[] tile;
    int mapTileNum [][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        
        mapTileNum = new int[gp.ScreenColumn][gp.ScreenRow];
        getTileImage();
        loadMap("/maps/map1.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassTile.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rockyTile.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lavaTile.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try {
            InputStream iStream = getClass().getResourceAsStream(filePath);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
            
            int column2 = 0;
            int row2 = 0; 

         while (column2 < gp.ScreenColumn && row2 < gp.ScreenRow){
            String line = bReader.readLine();
            while(column2< gp.ScreenColumn && row2 < gp.ScreenRow){
                String numbers[] = line.split(" ");

                int num = Integer.parseInt(numbers[column2]);

                mapTileNum[column2][row2] = num; 
                column2++;
            }
            if (column2 == gp.ScreenColumn){
                column2 = 0;
                row2 ++;
            }
         }
        bReader.close();

        } catch (Exception e) {
           
        }
    }

    public void draw(Graphics2D graph2D){

        int column = 0;
        int row = 0;
        int x = 0; 
        int y = 0;

        while (column < gp.ScreenColumn && row < gp.ScreenRow) {
            int tileNum = mapTileNum[column][row];

            graph2D.drawImage(tile[tileNum].image ,x, y, gp.TileSize,gp.TileSize,null);
            column++;
            x+= gp.TileSize;

            if(column == gp.ScreenColumn){
                column = 0 ;
                x = 0;
                row++;
                y+=gp.TileSize;
            }
        }
        
    }
}

