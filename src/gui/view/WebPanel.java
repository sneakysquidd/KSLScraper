package gui.view;

import java.awt.*;

import javax.swing.*;
import gui.controller.GUIController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WebPanel extends JPanel
{
	private CardLayout appLayout;
	private GUIController appController;

    private JTextField desiredFromPrice;
    private JTextField desiredToPrice;
    private JTextField desiredItem;
    private JTextField desiredZip;

    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel itemLabel;
    private JLabel zipLabel;



	
	public WebPanel(GUIController appController)
	{
		super();
        this.appController = appController;        
        
        appLayout = new CardLayout();
       


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
