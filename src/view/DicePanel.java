package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import model.interfaces.DicePair;

public class DicePanel extends JPanel
{
	JLabel lblDice1 = new JLabel("", JLabel.CENTER);
	JLabel lblDice2 = new JLabel("", JLabel.CENTER);
	private Image dice1, dice2, dice3, dice4, dice5, dice6;
	
	DicePanel()
	{
		setLayout(new GridLayout(1, 0, 0, 0));
		add(lblDice1);
		add(lblDice2);
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		try 
		{
			dice1 = ImageIO.read(new File("src/resources/dice1.png"));
			dice2 = ImageIO.read(new File("src/resources/dice2.png"));
			dice3 = ImageIO.read(new File("src/resources/dice3.png"));
			dice4 = ImageIO.read(new File("src/resources/dice4.png"));
			dice5 = ImageIO.read(new File("src/resources/dice5.png"));
			dice6 = ImageIO.read(new File("src/resources/dice6.png"));
		}	
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void updateDP(DicePair dicePair)
	{
		if(dicePair.getDice1() == 1)
		{
			lblDice1.setIcon(new ImageIcon(dice1));
		}
		if(dicePair.getDice1() == 2)
		{
			lblDice1.setIcon(new ImageIcon(dice2));
		}
		if(dicePair.getDice1() == 3)
		{
			lblDice1.setIcon(new ImageIcon(dice3));
		}
		if(dicePair.getDice1() == 4)
		{
			lblDice1.setIcon(new ImageIcon(dice4));
		}
		if(dicePair.getDice1() == 5)
		{
			lblDice1.setIcon(new ImageIcon(dice5));
		}
		if(dicePair.getDice1() == 6)
		{
			lblDice1.setIcon(new ImageIcon(dice6));
		}
		
		
		
		if(dicePair.getDice2() == 1)
		{
			lblDice2.setIcon(new ImageIcon(dice1));
		}
		if(dicePair.getDice2() == 2)
		{
			lblDice2.setIcon(new ImageIcon(dice2));
		}
		if(dicePair.getDice2() == 3)
		{
			lblDice2.setIcon(new ImageIcon(dice3));
		}
		if(dicePair.getDice2() == 4)
		{
			lblDice2.setIcon(new ImageIcon(dice4));
		}
		if(dicePair.getDice2() == 5)
		{
			lblDice2.setIcon(new ImageIcon(dice5));
		}
		if(dicePair.getDice2() == 6)
		{
			lblDice2.setIcon(new ImageIcon(dice6));
		}
	}	
}
