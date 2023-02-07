package p1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class MyWindow extends JFrame
{
	private JLabel heading;
	
	private JLabel clockLabel;
	
	private Font font=new Font("",Font.BOLD,35);
	MyWindow()
	{
		super.setTitle("My clock");
		super.setSize(400, 400);
		super.setLocation(300, 50);
		this.createGUI();
		this.startClock();
		super.setVisible(true);
	}
	public void createGUI()
	{
		//gui
		heading=new JLabel("my clock");
		clockLabel=new JLabel("clock");
		
		heading.setFont(font);
		clockLabel.setFont(font);
		
		this.setLayout(new GridLayout(2,1));
		this.add(heading);
		this.add(clockLabel);
		
		
	}
	public void startClock()
	{
	/*	Timer timer=new Timer(1000, new ActionListener()
				{ 
			         @Override
			        public void actionPerformed(ActionEvent e) {
					//String dateTime=new Date().toString();
			        	 String dateTime=new Date().toLocaleString();
			        	 Date d= new Date();
			        	 SimpleDateFormat sfd=new SimpleDateFormat("hh :mm: ss a");
			        	 
			        	String dateTime1=sfd.format(d);
					clockLabel.setText(dateTime1);
				}
			
				});
				timer.start(); */
				
			
				
				Thread t=new Thread() {
					public void run()
					{
						try
						{
							while(true)
							{
								Date d= new Date();
					        	 SimpleDateFormat sfd=new SimpleDateFormat("hh :mm: ss a");
					        	 
					        	String dateTime1=sfd.format(d);
							clockLabel.setText(dateTime1);
							//Thread.sleep(1000);
								Thread.currentThread().sleep(1000);
							}
							
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				};
				t.start();
				
	}
  
}
