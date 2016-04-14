package mess;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame 
{
	public Frame()
	{
		Color c = new Color(0, 100, 255);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setSize(250, 180);
		JPanel p = new JPanel();
		p.setOpaque(true);
		p.setBackground(c);
		this.add(p);
		
	}
	
	public static void main(String [] args) throws InterruptedException
	{
		Frame f = new Frame();
		Random rand = new Random();
		
		while(true)
		{
			int r = rand.nextInt(256);
			int g = rand.nextInt(256);
			int b = rand.nextInt(255);
			
			Color a = new Color(r, g, b);			
			f.setBackground(a);
			
			//Thread.sleep(1L);
		}
	}
}
