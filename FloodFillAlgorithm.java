import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class FloodFillAlgorithm extends JFrame implements MouseListener
{
	int xk, yk;
	Graphics g;
	Color pixel[][] = new Color[700][700];

	FloodFillAlgorithm(){
		setTitle("FloodFillAlgorithm");
		setSize(700,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		g = getGraphics();
		addMouseListener(this);
	}

	public void mouseClicked(MouseEvent me){
		xk = me.getX();
		yk = me.getY();
		drawRectangles(xk,yk);
		floodFill(xk,yk,Color.green, Color.blue);
	}

	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseMove(MouseEvent me){}
	public void mouseDragged(MouseEvent me){}

	Color getPixel(int x, int y){
		return pixel[x][y];
	}

	public void setPixel(int x, int y, Color c){
		g = getGraphics();
		g.setColor(c);
		pixel[x][y] = g.getColor();
		g.drawOval(x,y,1,1);
	}

	public void floodFill(int x, int y, Color ovalue, Color nvalue){
		if(getPixel(x,y)==ovalue){
			setPixel(x,y,nvalue);
			floodFill(x-1,y+1,ovalue,nvalue);
			floodFill(x,y+1,ovalue,nvalue);
			floodFill(x+1,y+1,ovalue,nvalue);
			floodFill(x-1,y,ovalue,nvalue);
			floodFill(x+1,y,ovalue,nvalue);
			floodFill(x-1,y-1,ovalue,nvalue);
			floodFill(x,y-1,ovalue,nvalue);
			floodFill(x+1,y-1,ovalue,nvalue);
		}
	}
	public void drawRectangles(int x, int y){
		for(int i=x; i<x+50;i++){
			for(int j=y;j<y+50;j++){
				setPixel(i,j,Color.green);
			}
		}
	}

	public static void main(String args[]){
		FloodFillAlgorithm ob = new FloodFillAlgorithm();
	}
}