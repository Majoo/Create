package se.chalmers.tda367.group25.resumate.views;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

import se.chalmers.tda367.group25.resumate.utils.Labels;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeSupport;

/**
 * A close component to the JTabbedPane in MainView
 * Contains a JLabel to show the name of the document (yet to be implemented) and 
 * a JButton to close the tab it belongs to
 */ 

public class ButtonTabClose extends JPanel {
    private final JTabbedPane pane;
    private PropertyChangeSupport pcs;

    public ButtonTabClose(final JTabbedPane tabbedPane) {
        // Set FlowLayout to the left (of the tab)
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (tabbedPane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = tabbedPane;
        setOpaque(false);
        
        // Make JLabel read titles from JTabbedPane
        JLabel label = new JLabel() {
            public String getText() {
                int i = tabbedPane.indexOfTabComponent(ButtonTabClose.this);
                if (i != -1) {
                    return tabbedPane.getTitleAt(i);
                }
                return null;
            }
        };
        
        add(label);
        // Add more space between the label and the button
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        // Tab button
        JButton button = new TabButton();
        add(button);
        // Add more space to the top of the component
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }
	/*
	 * Setting the tab button 
	 * 
	 * 
	 */
    private class TabButton extends JButton implements ActionListener {
        public TabButton() {
            int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("Close this tab");
            // Make the button looks the same for all Laf's
            setUI(new BasicButtonUI());
            // Make it transparent
            setContentAreaFilled(false);
            // No need to be focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            // Make a rollover effect
            // on all the buttons
            addMouseListener(btnMouseListener);
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            addActionListener(this);
        }
        
    	// What happens when you click on the close button
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfTabComponent(ButtonTabClose.this);
            if (i != -1) {
            	int selection = JOptionPane.showConfirmDialog(null,
    					"Do you want to save the document first?", null,
    					JOptionPane.YES_NO_OPTION);
    			if (selection == JOptionPane.YES_OPTION) {
    				// Saves the document
    				pcs.firePropertyChange(Labels.SAVE_DOC, false, true);
    				// Close tab
    				pane.remove(i);
    			}else if(selection == JOptionPane.CLOSED_OPTION){
    				// Cancel
    			}else{
    				// Close tab
    				pane.remove(i);
    			}  
            }
        }

        // We don't want to update UI for this button
        public void updateUI() {
        	;
        }

        // Paint the close button (a cross)
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.RED);
            }
            g2.drawLine(6, 6, getWidth() - 6 - 1, getHeight() - 6 - 1);
            g2.drawLine(getWidth() - 6 - 1, 6, 6, getHeight() - 6 - 1);
            g2.dispose();
        }
    }

    /*
     * Listeners for the mouse
     */
    private final static MouseListener btnMouseListener = new MouseAdapter() {
      
    	// When the mouse enter the close button area 
    	public void mouseEntered(MouseEvent e) {
            Component comp = e.getComponent();
            if (comp instanceof AbstractButton) {
                AbstractButton btn = (AbstractButton) comp;
                btn.setBorderPainted(true);
            }
        }
    	// When the mouse exit the close button area 
        public void mouseExited(MouseEvent e) {
            Component comp = e.getComponent();
            if (comp instanceof AbstractButton) {
                AbstractButton btn = (AbstractButton) comp;
                btn.setBorderPainted(false);
            }
        }
    };
}