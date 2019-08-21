package view;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.MenuController;

public class MenuBar extends JMenuBar
{
	public MenuBar(MainFrame frame)
	{
		JMenuBar toolBar = new JMenuBar();
		
		JMenu mnFile = new JMenu("File");
		JMenuItem mntmHelp = new JMenuItem("Help");
		JMenuItem mntmQuit = new JMenuItem("Quit");
		
		toolBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		
		MenuController menuCont = new MenuController(frame);
		mntmHelp.addActionListener(menuCont);
		mntmQuit.addActionListener(menuCont);
		
		toolBar.add(mnFile);
		mnFile.add(mntmHelp);
		mnFile.add(mntmQuit);
		
		this.add(mnFile);
	}
}
