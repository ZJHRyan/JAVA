package prestudent.jhpt.jinternalframe;

// Fig. 22.11: DesktopFrame.java
// Demonstrating JDesktopPane.
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class DesktopFrame extends JFrame 
{
   private final JDesktopPane theDesktop;

   // set up GUI
   public DesktopFrame()
   {
      super("Using a JDesktopPane");

      JMenuBar bar = new JMenuBar(); 
      
      JMenu addMenu1 = new JMenu("Add"); 
      JMenu addMenu2 = new JMenu("Remove"); 
      JMenuItem newFrame1 = new JMenuItem("Internal Frame1");
      JMenuItem newFrame2 = new JMenuItem("Internal Frame2");

      addMenu1.add(newFrame1); // add new frame item to Add menu
      addMenu1.add(newFrame2);
      addMenu2.add(newFrame2);
      bar.add(addMenu1); // add Add menu to menu bar
      bar.add(addMenu2); // add Add menu to menu bar
      setJMenuBar(bar); // set menu bar for this application

      theDesktop = new JDesktopPane(); 
      add(theDesktop); // add desktop pane to frame
    
      // set up listener for newFrame menu item
      newFrame1.addActionListener(
         new ActionListener() // anonymous inner class
         {  
            // display new internal window
            @Override
            public void actionPerformed(ActionEvent event) 
            {
               // create internal frame
               JInternalFrame frame = new JInternalFrame(
                  "Internal Frame", true, true, true, true);

               MyJPanel panel = new MyJPanel();
               frame.add(panel, BorderLayout.CENTER);
               frame.pack(); // set internal frame to size of contents

               theDesktop.add(frame); // attach internal frame
               frame.setVisible(true); // show internal frame
            } 
         } 
      ); 
      newFrame2.addActionListener(
    	         new ActionListener() // anonymous inner class
    	         {  
    	            // display new internal window
    	            @Override
    	            public void actionPerformed(ActionEvent event) 
    	            {
    	               // create internal frame
    	               JInternalFrame frame = new JInternalFrame(
    	                  "Internal Frame", true, true, true, true);

    	               MyJPanel panel = new MyJPanel();
    	               frame.add(panel, BorderLayout.CENTER);
    	               frame.pack(); // set internal frame to size of contents

    	               theDesktop.add(frame); // attach internal frame
    	               frame.setVisible(true); // show internal frame
    	            } 
    	         } 
    	      ); 
   } // end constructor DesktopFrame
} // end class DesktopFrame

// class to display an ImageIcon on a panel
class MyJPanel extends JPanel 
{
   private static final SecureRandom generator = new SecureRandom();
   private final ImageIcon picture; // image to be displayed
   private static final String[] images = {"./resources/complex_images/yellowflowers.png", 
      "./resources/complex_images/purpleflowers.png", "./resources/complex_images/redflowers.png", "./resources/complex_images/redflowers2.png", 
      "./resources/complex_images/lavenderflowers.png"};

   // load image
   public MyJPanel()
   {
      int randomNumber = generator.nextInt(images.length);
      picture = new ImageIcon(images[randomNumber]); // set icon
   }

   // display imageIcon on panel
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      picture.paintIcon(this, g, 0, 0); // display icon
   }

   // return image dimensions
   public Dimension getPreferredSize()
   {
      return new Dimension(picture.getIconWidth(), 
         picture.getIconHeight());  
   }
} // end class MyJPanel

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
