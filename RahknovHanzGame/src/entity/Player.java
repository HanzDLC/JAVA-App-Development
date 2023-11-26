package entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


import main.GamePanel;
import main.KeyboardInput;

public class Player extends Entity {
	GamePanel gp;
	public KeyboardInput keyboardInput;
	
	
	
	public Player(GamePanel gp, KeyboardInput keyboardInput)
	{	
		this.gp = gp;
		this.keyboardInput = keyboardInput;
		setDefaultValues();
		getPlayerImage();
		
	}
	
	public void setDefaultValues()
	{
		x = 50;
		y = 50;
		speed = 2;
		direction = "down";
	}
	
	public void getPlayerImage()
	{
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/player_up_2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/player_down_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/player_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/player_right_2.png"));
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void update()
	{
		
		if(keyboardInput.UpKey == true || keyboardInput.DownKey == true || 
				keyboardInput.LeftKey == true || keyboardInput.RightKey == true) {

			 if (keyboardInput.UpKey == true) {
				 	direction = "up";
		            y -= speed;
		        } else if (keyboardInput.DownKey == true) {
		        	direction = "down";
		            y += speed; 
		        } else if (keyboardInput.LeftKey == true) {
		        	direction = "left";
		            x -= speed;
		        } else if (keyboardInput.RightKey == true) {
		        	direction = "right";
		            x += speed;
		        } 
			 spriteCounter++;
			 if(spriteCounter > 12) {
				 if(spriteNum  == 1) {
					 spriteNum = 2;
				 }
				 else if(spriteNum == 2) {
					 spriteNum = 1;
				 }
				 spriteCounter = 0;
			 }
			
		}
		
		/*
		 if (keyboardInput.UpKey == true) {
			 	direction = "up";
	            y -= speed;
	        } else if (keyboardInput.DownKey == true) {
	        	direction = "down";
	            y += speed; 
	        } else if (keyboardInput.LeftKey == true) {
	        	direction = "left";
	            x -= speed;
	        } else if (keyboardInput.RightKey == true) {
	        	direction = "right";
	            x += speed;
	        } 
		 spriteCounter++;
		 if(spriteCounter > 12) {
			 if(spriteNum  == 1) {
				 spriteNum = 2;
			 }
			 else if(spriteNum == 2) {
				 spriteNum = 1;
			 }
			 spriteCounter = 0;
		 }
		 */
	}
	public void draw(Graphics2D graph2D)
	{
		 //graph2D.setColor(Color.cyan);
	     //graph2D.fillRect(x, y, gp.TileSize, gp.TileSize);
		BufferedImage image = null;
		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}if(spriteNum == 2) {
				image = right2;
			}
			
			break;
		}	
		graph2D.drawImage(image, x, y, gp.TileSize, gp.TileSize,null);
	}
	
}
