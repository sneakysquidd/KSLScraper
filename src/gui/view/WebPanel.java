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

    private JButton searchButton;
	
	private JScrollPane itemScroll;
	private JTextArea itemsText;

	public WebPanel(GUIController appController)
	{
		super();
        this.appController = appController;
        appLayout = new SpringLayout();

        this.itemsText = new JTextArea("Items will appear here");
        this.itemScroll = new JScrollPane(itemsText);
        
        this.desiredFromPrice = new JTextField();
        desiredFromPrice.setColumns(8);
        this.desiredToPrice = new JTextField();
        desiredToPrice.setColumns(8);

        this.fromLabel = new JLabel();
        fromLabel.setText("Lowest Price");
        this.toLabel = new JLabel();
        toLabel.setText("  Highest Price");
        toLabel.setLabelFor(desiredToPrice);
        this.itemLabel = new JLabel();
        itemLabel.setText("Item");
        this.zipLabel = new JLabel();
        zipLabel.setText("Zip Code");

        this.searchButton = new JButton();
        searchButton.setText("Search");

        appLayout.putConstraint(SpringLayout.EAST, itemLabel, -56, SpringLayout.WEST, toLabel);
        appLayout.putConstraint(SpringLayout.NORTH, toLabel, 0, SpringLayout.NORTH, fromLabel);
        appLayout.putConstraint(SpringLayout.WEST, toLabel, 0, SpringLayout.WEST, desiredToPrice);
        appLayout.putConstraint(SpringLayout.EAST, toLabel, 0, SpringLayout.EAST, desiredToPrice);
        appLayout.putConstraint(SpringLayout.NORTH, itemLabel, 0, SpringLayout.NORTH, fromLabel);
        appLayout.putConstraint(SpringLayout.NORTH, desiredFromPrice, 6, SpringLayout.SOUTH, fromLabel);
        appLayout.putConstraint(SpringLayout.NORTH, desiredToPrice, 30, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.NORTH, fromLabel, 10, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.SOUTH, fromLabel, -276, SpringLayout.SOUTH, this);
        appLayout.putConstraint(SpringLayout.NORTH, zipLabel, 10, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.WEST, fromLabel, 34, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.EAST, desiredToPrice, -135, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.WEST, desiredFromPrice, 27, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.EAST, desiredFromPrice, -345, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.EAST, zipLabel, -44, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.WEST, searchButton, 173, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -31, SpringLayout.SOUTH, this);
        appLayout.putConstraint(SpringLayout.EAST, searchButton, -183, SpringLayout.EAST, this);


        setupPanel();
        setupScroll();
        setupLayout();
        setupListeners();
        
        
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(800, 600));
		this.setLayout(appLayout);

		//adds all components to the this
		this.add(desiredFromPrice);
		this.add(desiredToPrice);
		this.add(fromLabel);
		this.add(toLabel);
		this.add(itemLabel);
		this.add(zipLabel);
	
		this.desiredItem = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, desiredItem, 6, SpringLayout.SOUTH, itemLabel);
		appLayout.putConstraint(SpringLayout.WEST, desiredToPrice, 27, SpringLayout.EAST, desiredItem);
		appLayout.putConstraint(SpringLayout.WEST, desiredItem, 27, SpringLayout.EAST, desiredFromPrice);
		appLayout.putConstraint(SpringLayout.EAST, desiredItem, -240, SpringLayout.EAST, this);
		desiredItem.setColumns(8);
		this.add(desiredItem);
		this.desiredZip = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, desiredZip, 6, SpringLayout.SOUTH, zipLabel);
		appLayout.putConstraint(SpringLayout.WEST, desiredZip, 27, SpringLayout.EAST, desiredToPrice);
		appLayout.putConstraint(SpringLayout.EAST, desiredZip, 14, SpringLayout.EAST, zipLabel);
		zipLabel.setLabelFor(desiredZip);
		desiredZip.setColumns(8);
		this.add(desiredZip);
		this.add(searchButton);
		this.add(itemScroll);
	}
	
	private void setupLayout()
	{
		
		
	}
	
	private void setupScroll()
	{
		
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
