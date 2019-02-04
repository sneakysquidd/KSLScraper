package gui.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import gui.controller.GUIController;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstPanel extends JPanel
{
	private SpringLayout appLayout;
	private GUIController appController;
	private JLabel icon;
	private JButton genButton;
	private JButton resButton;
	private JTextArea output;
	private JTextField input;
	
	
	public FirstPanel(GUIController appController)
	{
		super();
        this.appController = appController;        
        
        appLayout = new SpringLayout();
       
        genButton = new JButton("Generate");
        genButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        resButton = new JButton("Reset");
        appLayout.putConstraint(SpringLayout.EAST, resButton, -357, SpringLayout.EAST, this);
       
        input = new JTextField("");
        appLayout.putConstraint(SpringLayout.NORTH, genButton, 35, SpringLayout.NORTH, input);
        appLayout.putConstraint(SpringLayout.WEST, genButton, 105, SpringLayout.EAST, input);
        appLayout.putConstraint(SpringLayout.WEST, input, 194, SpringLayout.WEST, this);
        output = new JTextArea("",20,50);
        appLayout.putConstraint(SpringLayout.NORTH, input, 29, SpringLayout.SOUTH, output);
        appLayout.putConstraint(SpringLayout.NORTH, output, 40, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.EAST, output, -91, SpringLayout.EAST, this);
        


        setupPanel();
        setupLayout();
        setupListeners();
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(800, 600));
		this.setLayout(appLayout);
		icon = new JLabel("mmmmm");
		appLayout.putConstraint(SpringLayout.NORTH, icon, 550, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, icon, -362, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, resButton, -22, SpringLayout.NORTH, icon);
		appLayout.putConstraint(SpringLayout.SOUTH, input, -81, SpringLayout.SOUTH, icon);
		appLayout.putConstraint(SpringLayout.EAST, input, -34, SpringLayout.WEST, icon);
		this.add(icon);
		this.add(genButton);
		this.setBackground(Color.GRAY);
        this.add(resButton);
        this.add(genButton);
        this.add(output);
        this.add(input);		
	}
	
	private void setupLayout()
	{
		
		
	}
	
	private void setupListeners()
	{
		genButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent click)
		    {
        		String people = input.getText();
        		int input = Integer.valueOf(people);
        		int num = 0;
        		double random = 0;
        		String outputNum = "";
        		
        		for (int i = 1; i < input + 100; i++)
        		{
        			num = input;
        			random = Math.random();
        			num = (int) (num * random);
        			
        			outputNum = Integer.toString(num);
        			output = new JTextArea(outputNum,20,50);
        			
        		}
        		
        		
		    }
        });
		
		resButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				input.setText("");
				output.setText("");
			}
		});
				
	}
}
