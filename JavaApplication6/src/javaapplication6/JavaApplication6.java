/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
//import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import com.jtattoo.plaf.smart.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Properties;

/**
 *
 * @author chandan
 */
public class JavaApplication6 {
    public static mainWin m = null;
public static framee f1=new framee(); 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        f1.create();
    }
    
}
 class framee  implements ActionListener,Runnable 
{
 public static   JFrame f; 
    JButton b;
    JButton b1;
     JLabel l1;
    Thread t;
    JLabel l;
    JPanel p;
    ImageIcon[] j=new ImageIcon[10];
  
    Color c[]={Color.BLUE,Color.ORANGE,Color.GREEN,Color.YELLOW,Color.red};
    
    framee()
            {
                try {
                    
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            // start application
           // new MinFrame();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
                p=new JPanel();
                 f=new JFrame("BILLING SOFTWARE");
                 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 l=new JLabel("");
                 f.setLayout(null);
                 f.setExtendedState(MAXIMIZED_BOTH);
                 f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("b.png")));
                 int w,h;
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                  w=screenSize.width;
                  h=screenSize.height;
                    l.setBounds(0, 0,w,h);
            
            for(int i=0;i<10;i++)
           {
             j[i]=new ImageIcon("F:/New Folder/JavaApplication6/"+i+".jpg");  
           }
      f.setVisible(true);
      t=new Thread(this);
      t.start();      
            }
void create()
{
    GridBagLayout gbl = new GridBagLayout();
    l.setLayout(gbl);
    GridBagConstraints gc =new GridBagConstraints();
    gbl.rowHeights = new int[] {50,25,50};
    gc.gridx=0;
    gc.gridy=0;
    gc.fill=GridBagConstraints.HORIZONTAL;
    b=new JButton("Admin");
    l.add(b,gc);
    gc.gridy=2;
    b1=new JButton("Client");
    l.add(b1,gc);
    b.addActionListener(this);
      b1.addActionListener(this);
    b.setPreferredSize(new Dimension(500,50));
    b1.setPreferredSize(new Dimension(500,50));
   //b.setBounds(100, 100, 100, 50);
    //b1.setBounds(300, 100, 100, 50);
    l.add(b);
    
/*l.add(p,BorderLayout.CENTER);
 p.setLayout(new GridLayout(2,1));
 p.add(b);
 p.add(b1);*/
    f.add(l);
    changecolor();              
}
void changecolor()
{
    
       for(int i=0;i>=0;i++)
                     {
        try {
            b.setForeground(c[i%5]);
            b1.setForeground(c[i%5]);
              
              
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(framee.class.getName()).log(Level.SEVERE, null, ex);
        }
                         
                     }
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b) {
            if(JavaApplication6.m == null)
            {
                JavaApplication6.m=new mainWin();
            }
            JavaApplication6.m.setLocationRelativeTo(null);
            JavaApplication6.m.setVisible(true);
            JavaApplication6.m.setTitle("Admin Login");
           }
        if(e.getSource() == b1) 
        {
            if(JavaApplication6.m == null)
            {
                JavaApplication6.m=new mainWin();
            }
            JavaApplication6.m.setLocationRelativeTo(null);
            JavaApplication6.m.setVisible(true);
            JavaApplication6.m.setTitle("Client Login");
            
        }
        
       
      // f.setVisible(false);
  }

    @Override
    public void run() {
         //To change body of generated methods, choose Tools | Templates.
             
           for(int i=0;i>=0;i++)
                     {
                         Image image = j[i%10].getImage(); // transform it 
                         Image newimg = image.getScaledInstance(l.getWidth(), l.getHeight(),Image.SCALE_FAST); // scale it the smooth way  
                         j[i%10] = new ImageIcon(newimg);
                         l.setIcon(j[i%10]);
                          l.setOpaque(true);
                         try {
                             Thread.sleep(3000);
                         } catch (InterruptedException ex) {
                             Logger.getLogger(framee.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
    }
           public void dispose()
           {
             this.dispose();
           }
    }

