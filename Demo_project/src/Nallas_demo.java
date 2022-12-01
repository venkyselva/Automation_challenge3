import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import io.netty.util.internal.ThreadLocalRandom;

public class Nallas_demo {

	public static String Set1 = "Yet to start";
	public static String Set2 = "Yet to start";
	public static JLabel Set_list1;
	public static JLabel Set_list2;
	public static JLabel Status;
	public static String user_status ="Yet to start";
	public static  String  Verification="Yet to start";
	public static  int Guess_count=0;
	public static JTextField userEnt;
	public static  String  finalstring="";
	public static Integer [] int_array;
	public static JButton number;
	public static JButton reset;
	public static String finalvalue="empty";
	public static void main(String[] args) 
	{
					
     try
     {
	     //---Javaframe and java Panel intialization----
		final JFrame frame = new JFrame();
		frame.setTitle("-----Welcome to NALLAS-----");
		
		JPanel pane1 = new JPanel();
		
		
		//---to identify system resolution----
		int[] scrn_resln = system_resolution();
		 int width = scrn_resln[0];
		 int height = scrn_resln[1];
		 frame.setSize(width/2,height/2);
		//---Element initialization----
		 
         number = new JButton("Generate");
         reset = new JButton("Reset");
         
        JLabel list_label = new JLabel("Enter Length of Pattern");
        userEnt = new JTextField("", 10);
        Set_list1 = new JLabel("<html>"+" show Pattern **-- "+Set1+" --**</html>");
        pane1.add(list_label);
        pane1.add(userEnt);
        pane1.add(number);
        pane1.add(reset);
        frame.add(pane1);
        frame.setVisible(true);
         number.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  reset.setEnabled(true);
				  userEnt.setEditable(false);
				  number.setEnabled(false);
				  String get_value = userEnt.getText();
				  generate_pattern(get_value);
				  JOptionPane.showMessageDialog(frame,"show Pattern" +finalstring);
			     			      
			  }  
		});  
         
         reset.addActionListener(new ActionListener(){  
			  public void actionPerformed(ActionEvent e){
				  number.setEnabled(true);
				  userEnt.setEditable(true);
				  userEnt.setText("");
				  reset.setEnabled(false);
				  finalvalue ="Reset Completed";
				  finalstring ="";
				  JOptionPane.showMessageDialog(frame, "<html><br>"+"show Pattern "+finalvalue+" </html>");
				  
			  }});
         
     }
     catch(Exception e)
     {
    	 finalvalue = "Invalid data";
     }
	}
	

	public static void generate_pattern(String value)
	{
		try
		{
		int len = Integer.parseInt(value);
		int a =0;
		int b=len;
		String vll ="Start";
		int n =0;
		String finalcompare ="true";
		while(b>=0)
		{
			
		if(vll.contains("Start")||vll.contains("end"))	
		{
			finalstring +="\r\n";
		System.out.println("");
		for(int c=0;c<len;c++)
		{
			finalstring +="*";
			System.out.print("*");
		}
		if(vll.contains("end"))
		{
			System.out.println(finalstring);
			break;
		}
		vll="test";
		}
		else
		{
		for(int c=0;c<len;c++)
		{
			if(vll.contains("next"))
			{
			  a=n+1;
			  finalcompare ="false";
			}
			else
			{
				a=b-1;
			}
	      if(c==0||c==a)
		    {
			if(c==0)
			{
				finalstring+="\r\n";
			System.out.println("");
			}	
			finalstring+="*";
			System.out.print("*");
			}
			else
			{
				finalstring+=" ";
			System.out.print(" ");
			}
		}
		}
		b=b-1;
		n=n+1;
		if(b==0||a==len-1)
		{
			b = len;
			vll="next";
			if(n==len-1 && finalcompare.contains("false"))
			{
				vll="end";
			}
			n=0;
		}
		}
		}
		catch(Exception e)
		{
			finalvalue = "Invalid data";
		}
	}
public static int[] system_resolution()
{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)screenSize.getWidth();
		
		int height = (int)screenSize.getHeight();
		int[] val = {width,height};
		return val;
		
}
	
	
	

}
