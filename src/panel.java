import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @(#)panel.java
 *
 *
 * @author yunus umeyr kýlýç
 * @version 1.00 2015/4/6
 */


public class panel extends JPanel{

    //properties
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    final int NUMBEROFBUTTONS = 25;
    static int count;
    int random;
    Random generator = new Random();
    static JLabel label;
    
    //constructor
    public panel() 
    {
    	count = 0;
    	random = generator.nextInt( 25);// take a number randomly
    	setLayout( new GridLayout( 6, 5));
    	
    	label = new JLabel( "Number of guesses is: " + panel.count);   	
    	add( label);
    	//add invisible labels
    	add( new JLabel());
    	add( new JLabel());
    	add( new JLabel());
    	add( new JLabel());
    	
    	ButtonListener listener = new ButtonListener();
    	
    	//create and add buttons
    	for( int i = 0; i < NUMBEROFBUTTONS; i++)
    	{
    		buttons.add( new JButton());
    		buttons.get( i).addActionListener( listener);
    		add( buttons.get( i) );
    	}
    	
    	//set layout and size
    	setLayout( new GridLayout( 7, 5));	
    	setPreferredSize( new Dimension( 800,800));
    	setBackground( Color.white);
    		
    }
    
    //represent a listener for button push events
    private class ButtonListener implements ActionListener
    {
    	public void actionPerformed( ActionEvent e)
    	{
    		count++;//show number of guess
    		label.setText("Number of guesses is: " + count); //update the text of label
    		//paint the buttons and remove their action
    		((JButton)(e.getSource())).setBackground( Color.BLUE);  	
    		((JButton)(e.getSource())).removeActionListener( this);
    		
    		
    		if( e.getSource() == buttons.get( random))
    		{
    			buttons.get( random).setBackground(Color.RED );
    			JLabel label2 = new JLabel( "You got it in " + count + " attempt");
    			add( label2);
    			
    			int i = 0;
    			while( i < NUMBEROFBUTTONS)
    			{
    				((JButton)(buttons.get( i))).removeActionListener( this);
    				i++;
    			}
    				
    					
    		}
    	}
    }
    
    
}