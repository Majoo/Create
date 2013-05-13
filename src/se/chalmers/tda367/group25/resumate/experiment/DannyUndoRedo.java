package se.chalmers.tda367.group25.resumate.experiment;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class DannyUndoRedo extends JFrame {
	
	private static JTextPane textContentPane;
	
	public DannyUndoRedo() {
		super("ResuMate Undo/Redo");

	    textContentPane = new JTextPane(); // Create the text pane
	    textContentPane.setEditable(true); // Editable
	    getContentPane().add(new JScrollPane(textContentPane), BorderLayout.CENTER);
	
	
	    // Create the undo manager and actions
	    UndoManager manager = new UndoManager();
	    textContentPane.getDocument().addUndoableEditListener(manager);
	
	    Action undoAction = new UndoAction(manager);
	    Action redoAction = new RedoAction(manager);
	    
	    // Assign the actions to keys
	    textContentPane.registerKeyboardAction(undoAction, KeyStroke.getKeyStroke(
	        KeyEvent.VK_Z, InputEvent.CTRL_MASK), JComponent.WHEN_FOCUSED);
	    textContentPane.registerKeyboardAction(redoAction, KeyStroke.getKeyStroke(
	        KeyEvent.VK_Y, InputEvent.CTRL_MASK), JComponent.WHEN_FOCUSED);
	  }
	
	  // The Undo action
	  public class UndoAction extends AbstractAction {
	    public UndoAction(UndoManager manager) {
	      this.manager = manager;
	    }
	
	    public void actionPerformed(ActionEvent evt) {
	      try {
	        manager.undo();
	      } catch (CannotUndoException e) {
	        Toolkit.getDefaultToolkit().beep();
	      }
	    }
	
	    private UndoManager manager;
	  }
	
	  // The Redo action
	  public class RedoAction extends AbstractAction {
	    public RedoAction(UndoManager manager) {
	      this.manager = manager;
	    }
	
	    public void actionPerformed(ActionEvent evt) {
	      try {
	        manager.redo();
	      } catch (CannotRedoException e) {
	        Toolkit.getDefaultToolkit().beep();
	      }
	    }
	
	    private UndoManager manager;
	  }
	
	  
	  
	  public static void main(String[] args) {
	  
	    JFrame f = new DannyUndoRedo();
	    f.setSize(400, 300);
	    f.setVisible(true);
	  }
}
