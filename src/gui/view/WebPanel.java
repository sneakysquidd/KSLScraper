package gui.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

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
        this.itemsText = new JTextArea(18,90);
        this.itemScroll = new JScrollPane(itemsText);
        appLayout.putConstraint(SpringLayout.WEST, itemScroll, 36, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.SOUTH, itemScroll, -33, SpringLayout.SOUTH, this);
        this.desiredItem = new JTextField();
        appLayout.putConstraint(SpringLayout.NORTH, desiredItem, 49, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.WEST, desiredItem, 52, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.EAST, desiredItem, -616, SpringLayout.EAST, this);
        this.desiredFromPrice = new JTextField();
        appLayout.putConstraint(SpringLayout.WEST, desiredFromPrice, 53, SpringLayout.EAST, desiredItem);
        appLayout.putConstraint(SpringLayout.EAST, desiredFromPrice, -431, SpringLayout.EAST, this);
        this.desiredZip = new JTextField();
        appLayout.putConstraint(SpringLayout.NORTH, desiredZip, 0, SpringLayout.NORTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.EAST, desiredZip, -57, SpringLayout.EAST, this);
        this.logo = new JLabel();
        appLayout.putConstraint(SpringLayout.NORTH, logo, 0, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.WEST, logo, 382, SpringLayout.WEST, this);
        logo.setEnabled(false);
        //logo.setIcon(new ImageIcon(WebPanel.class.getResource("/Images/kslLogo.png")));
        this.desiredToPrice = new JTextField();
        appLayout.putConstraint(SpringLayout.WEST, desiredZip, 55, SpringLayout.EAST, desiredToPrice);
        appLayout.putConstraint(SpringLayout.NORTH, desiredToPrice, 0, SpringLayout.NORTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.WEST, desiredToPrice, 55, SpringLayout.EAST, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.EAST, desiredToPrice, -244, SpringLayout.EAST, this);
        this.fromLabel = new JLabel();
        appLayout.putConstraint(SpringLayout.NORTH, desiredFromPrice, 6, SpringLayout.SOUTH, fromLabel);
        appLayout.putConstraint(SpringLayout.WEST, fromLabel, 86, SpringLayout.EAST, desiredItem);
        this.toLabel = new JLabel();
        appLayout.putConstraint(SpringLayout.NORTH, toLabel, 0, SpringLayout.NORTH, fromLabel);
        appLayout.putConstraint(SpringLayout.WEST, toLabel, 121, SpringLayout.EAST, fromLabel);
        this.itemLabel = new JLabel();
        appLayout.putConstraint(SpringLayout.NORTH, fromLabel, 0, SpringLayout.NORTH, itemLabel);
        appLayout.putConstraint(SpringLayout.NORTH, itemLabel, 29, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.WEST, itemLabel, 102, SpringLayout.WEST, this);
        this.zipLabel = new JLabel();
        appLayout.putConstraint(SpringLayout.EAST, toLabel, -130, SpringLayout.WEST, zipLabel);
        appLayout.putConstraint(SpringLayout.NORTH, zipLabel, 0, SpringLayout.NORTH, fromLabel);
        appLayout.putConstraint(SpringLayout.WEST, zipLabel, 101, SpringLayout.EAST, desiredToPrice);
        this.searchButton = new JButton();
        appLayout.putConstraint(SpringLayout.NORTH, searchButton, 20, SpringLayout.SOUTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.WEST, searchButton, 187, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.EAST, searchButton, -188, SpringLayout.EAST, this);
        
        
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
		//this.add(itemsText);
		this.add(desiredZip);
		this.add(searchButton);
		this.add(itemScroll);
		this.itemsText = new JTextArea(20,20);
		appLayout.putConstraint(SpringLayout.NORTH, itemsText, 79, SpringLayout.SOUTH, searchButton);
		appLayout.putConstraint(SpringLayout.WEST, itemsText, 165, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, itemsText, -98, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, itemsText, 0, SpringLayout.EAST, toLabel);
		itemsText.setLineWrap(true);
		itemsText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		itemsText.setColumns(100);
		itemsText.setEditable(false);
		//itemScroll.add(itemsText);
		      
	}
	
	private void setupLayout()
	{
        fromLabel.setText("Lowest Price");
        toLabel.setText("  Highest Price");
        itemLabel.setText("Item");
        zipLabel.setText("Zip Code");
        searchButton.setText("Search");
		zipLabel.setLabelFor(desiredZip);
		
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
					//itemsText.add(item.getTitle());
				}
			}
				});
				
	}
}
