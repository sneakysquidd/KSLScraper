package gui.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import gui.controller.GUIController;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WebPanel extends JPanel
{
	private SpringLayout appLayout;
	private GUIController appController;
	
	public WebPanel(GUIController appController)
	{
		super();
        this.appController = appController;        
        
        appLayout = new SpringLayout();
       


        setupPanel();
        setupLayout();
        setupListeners();
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(800, 600));
		this.setLayout(appLayout);

	}
	
	private void setupLayout()
	{
		
		
	}
	
	private void setupListeners()
	{
		
				
	}
}
