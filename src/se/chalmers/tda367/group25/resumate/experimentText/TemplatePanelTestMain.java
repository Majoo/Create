package se.chalmers.tda367.group25.resumate.experimentText;

import javax.swing.JFrame;

public class TemplatePanelTestMain {

	public static void main(String [] args){
	
	JFrame frame = new JFrame();
	frame.setTitle("Test TemplatePanel & RMText");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(100, 100, 450, 400);
	frame.setLocationRelativeTo(null);
	TemplatePanelTest tP = new TemplatePanelTest();
	TextController tc = new TextController();
	tP.addObserver(tc);
	frame.add(tP);
	frame.setResizable(false);
	frame.setVisible(true);
	}
}
