package se.chalmers.tda367.group25.resumate.views;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

import se.chalmers.tda367.group25.resumate.utils.Labels;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A close component to the JTabbedPane in MainView
 * Contains a JLabel to show the name of the document (yet to be implemented) and 
 * a JButton to close the tab it belongs to
 */ 

public class ButtonTabClose extends JPanel {
    private final JTabbedPane tabbedPane;
    private PropertyChangeSupport pcs;

    public ButtonTabClose(final JTabbedPane tabbedPane) {
        // Set FlowLayout to the left (of the tab)
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        this.tabbedPane = tabbedPane;
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
        
        pcs = new PropertyChangeSupport(this);
    }
	/**
	 * Settings for the close tab button. 
	 */
    private class TabButton extends JButton implements ActionListener {
        public TabButton() {
            int size = 20;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("Close this tab.");
            // Set the Look and Feel for a basic button
            setUI(new BasicButtonUI());
            // Make the button transperent
            setContentAreaFilled(false);

            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            // Make a rollover effect
            addMouseListener(btnMouseListener);
            setRolloverEnabled(true);
            //Close the proper tab by clicking the button
            addActionListener(this);
      
        }
        
    	// What happens when you click on the close button
        public void actionPerformed(ActionEvent arg0) {
            int i = tabbedPane.indexOfTabComponent(ButtonTabClose.this);
            if (i != -1) { 
            	int selection = JOptionPane.showConfirmDialog(null,
    					"Are you sure you want to close this tab?", null,
    					JOptionPane.YES_NO_OPTION);
    			if (selection == JOptionPane.YES_OPTION) {	
    				tabbedPane.remove(i);
    			}
            }
        }
        
        // We don't want to update UI for this button
        public void updateUI() {
        	;
        }

        /** Paint the close tab button
         * with the help of 2 dimensional graphics
         * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
         * 			for more information about 2D graphics
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            
            // Make it default black
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            
            // Make it red when the mouse rolls over
            if (getModel().isRollover()) {
                g2.setColor(Color.RED);
            }
            // Draw an X (cross)
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