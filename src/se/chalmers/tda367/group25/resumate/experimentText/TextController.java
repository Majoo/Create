package se.chalmers.tda367.group25.resumate.experimentText;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

public class TextController implements PropertyChangeListener  {
	
	public static final String font = "fontChanged";
	public static final String style = "styleChanged";
	public static final String size = "sizeChanged";
	public static final String text = "textChanged";
	public static final String replace = "textReplaced";
	public RMText tX;
	
	public TextController(){
		 tX = new RMText();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		switch(arg0.getPropertyName()){
		case font:
			//JOptionPane.showMessageDialog(null,"In Controller for font");
			tX.changeFont((JEditorPane)arg0.getOldValue(), arg0.getNewValue().toString());
		break;
		case style:
			//JOptionPane.showMessageDialog(null,"In Controller for style");
			tX.changeStyle((JEditorPane)arg0.getOldValue(), arg0.getNewValue().toString());
		
		break;
		case size:
			//JOptionPane.showMessageDialog(null,"In Controller for size");
			tX.changeSize((JEditorPane)arg0.getOldValue(), (int)arg0.getNewValue());
			
		break;
		case text:
			//OptionPane.showMessageDialog(null,"In Controller for text");
			tX.setText(arg0.getNewValue().toString());
			
		break;
		case replace:
			//JOptionPane.showMessageDialog(null,"In Controller for replace");
			String [] t = arg0.getNewValue().toString().split("/");
			tX.replaceText((JEditorPane)arg0.getOldValue(), t[0], t[1]);
		
		default:
			//nothing
		}
		
	}

}
