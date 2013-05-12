package se.chalmers.tda367.group25.resumate.experiment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fullscreen extends Window {
  private Button button;

  public Fullscreen() {
    super(new Frame());
    button = new Button("Close");
    button.addActionListener(new ActionListener() 
    {
      public void actionPerformed(ActionEvent e) 
      {
        System.exit(0);
      }
    });

    setLayout(new FlowLayout());
    add(button);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0,0,screenSize.width, screenSize.height);
  }

}