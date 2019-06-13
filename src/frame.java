import java.awt.*;
import javax.swing.*;
/**
 * @(#)frame.java
 *
 *
 * @author yunus umeyr kýlýç 
 * @version 1.00 2015/4/6
 */


public class frame extends JFrame{

    public frame() 
    {
    	//set operations
    	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    	setLayout( new BorderLayout());
    	
    	add( new panel(),BorderLayout.CENTER);//add panel
    	
    	setVisible( true);
    	pack();
    	
    }
    
    
}