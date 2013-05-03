package se.chalmers.tda367.group25.resumate.experimentText;

import javax.swing.JFrame;

public class TemplatePanelTestMain {

	public static void main(String [] args){
	
	JFrame frame = new JFrame();
	frame.setTitle("Test findtext in TemplatePanel");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBounds(100, 100, 600, 400);
	frame.setLocationRelativeTo(null);
	TemplatePanelTest test = new TemplatePanelTest();
	frame.add(test);
	frame.setResizable(false);
	frame.setVisible(true);
	}
}
