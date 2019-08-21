package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JTextArea;

import view.ResultPanel;

public class TextAreaController 
{
	private ResultPanel resultPanel = new ResultPanel();
	private JTextArea txtOutput;
	
	public class TextAreaOutputStream extends OutputStream
	{
		public TextAreaOutputStream(JTextArea output)
		{
			txtOutput = output;
		}
		
		@Override
		public void write(int arg0) throws IOException 
		{
			txtOutput.append(String.valueOf((char)arg0));
		}
	}
}
