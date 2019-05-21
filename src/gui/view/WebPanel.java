package gui.view;

import java.awt.*;

import javax.swing.*;
import gui.controller.GUIController;
import gui.model.Item;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WebPanel extends JPanel
{
	private SpringLayout appLayout;
	private GUIController appController;

    private JTextField desiredFromPrice;
    private JTextField desiredToPrice;
    private JTextField desiredItem;
    private JTextField desiredZip;

    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel itemLabel;
    private JLabel zipLabel;
    
    private JLabel logo;

    private JButton searchButton;
	
	private JScrollPane itemScroll;
	private JTextArea itemsText;

	public WebPanel(GUIController appController)
	{
		super();
        this.appController = appController;
        appLayout = new SpringLayout();
        this.itemScroll = new JScrollPane();
        this.desiredItem = new JTextField();
        this.desiredFromPrice = new JTextField();
        this.desiredZip = new JTextField();
        this.itemsText = new JTextArea("Items will appear here");
        itemsText.setEditable(false);
        this.logo = new JLabel();
        appLayout.putConstraint(SpringLayout.NORTH, logo, 0, SpringLayout.NORTH, itemScroll);
        appLayout.putConstraint(SpringLayout.WEST, logo, 361, SpringLayout.EAST, itemScroll);
        logo.setEnabled(false);
        //logo.setIcon(new ImageIcon(WebPanel.class.getResource("/Images/kslLogo.png")));
        this.desiredToPrice = new JTextField();
        this.fromLabel = new JLabel();
        appLayout.putConstraint(SpringLayout.EAST, fromLabel, -470, SpringLayout.EAST, this);
        this.toLabel = new JLabel();
        appLayout.putConstraint(SpringLayout.WEST, toLabel, 121, SpringLayout.EAST, fromLabel);
        appLayout.putConstraint(SpringLayout.SOUTH, toLabel, -6, SpringLayout.NORTH, desiredToPrice);
        appLayout.putConstraint(SpringLayout.EAST, toLabel, -28, SpringLayout.EAST, desiredToPrice);
        this.itemLabel = new JLabel();
        this.zipLabel = new JLabel();
        this.searchButton = new JButton();
        
        
        setupPanel();
        setupLayout();
        setupListeners();
        
        
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(800, 500));
		this.setLayout(appLayout);

		//adds all components to the this
		this.add(desiredFromPrice);
		this.add(desiredToPrice);
		this.add(fromLabel);
		this.add(toLabel);
		this.add(itemLabel);
		this.add(zipLabel);
		this.add(logo);
		this.add(desiredItem);
		this.add(itemsText);
		this.add(desiredZip);
		this.add(searchButton);
		this.add(itemScroll);
		
		      
	}
	
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.EAST, desiredFromPrice, -435, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.NORTH, desiredToPrice, 0, SpringLayout.NORTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.WEST, desiredToPrice, 58, SpringLayout.EAST, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.EAST, desiredToPrice, -245, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.SOUTH, fromLabel, -6, SpringLayout.NORTH, desiredFromPrice);
        fromLabel.setText("Lowest Price");
        toLabel.setText("  Highest Price");
        appLayout.putConstraint(SpringLayout.NORTH, itemLabel, 0, SpringLayout.NORTH, fromLabel);
        appLayout.putConstraint(SpringLayout.WEST, itemLabel, 103, SpringLayout.WEST, this);
        itemLabel.setText("Item");
        appLayout.putConstraint(SpringLayout.NORTH, zipLabel, 83, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.EAST, zipLabel, -105, SpringLayout.EAST, this);
        zipLabel.setText("Zip Code");
        appLayout.putConstraint(SpringLayout.WEST, searchButton, 185, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.EAST, searchButton, -190, SpringLayout.EAST, this);
        searchButton.setText("Search");
        appLayout.putConstraint(SpringLayout.NORTH, desiredFromPrice, 0, SpringLayout.NORTH, desiredItem);
		appLayout.putConstraint(SpringLayout.WEST, desiredFromPrice, 48, SpringLayout.EAST, desiredItem);
		appLayout.putConstraint(SpringLayout.WEST, desiredItem, 53, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, desiredItem, -615, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, desiredZip, 0, SpringLayout.NORTH, desiredFromPrice);
		appLayout.putConstraint(SpringLayout.WEST, desiredZip, 52, SpringLayout.EAST, desiredToPrice);
		appLayout.putConstraint(SpringLayout.EAST, desiredZip, -61, SpringLayout.EAST, this);
		zipLabel.setLabelFor(desiredZip);
		appLayout.putConstraint(SpringLayout.SOUTH, desiredItem, -41, SpringLayout.NORTH, itemsText);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -6, SpringLayout.NORTH, itemsText);
		appLayout.putConstraint(SpringLayout.NORTH, itemsText, -336, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, itemsText, 35, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, itemsText, -29, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, itemsText, 766, SpringLayout.WEST, this);
		
	}
	

	
	private void setupListeners()
	{
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				Item[] ItemArr = appController.searchForItem(desiredItem.getText(), desiredFromPrice.getText(), desiredToPrice.getText(), desiredZip.getText());
				
				for (Item item : ItemArr)
				{
					
				}
			}
				});
				
	}
}
