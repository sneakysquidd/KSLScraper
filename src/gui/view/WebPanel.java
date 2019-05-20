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
    private JPanel panels;

    private JTextField desiredFromPrice;
    private JTextField desiredToPrice;
    private JTextField desiredItem;
    private JTextField desiredZip;

    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel itemLabel;
    private JLabel zipLabel;

    private JButton searchButton;

	private JPanel searchPanel;
	private JPanel viewPanel;
	private SpringLayout sl_searchPanel;

	public WebPanel(GUIController appController)
	{
		super();
        this.appController = appController;
        appLayout = new CardLayout();
        panels = new JPanel(new CardLayout());

        this.desiredFromPrice = new JTextField();
        desiredFromPrice.setColumns(8);
        this.desiredToPrice = new JTextField();
        desiredToPrice.setColumns(8);

        this.fromLabel = new JLabel();
        fromLabel.setText("Lowest Price");
        this.toLabel = new JLabel();
        toLabel.setText("Highest Price");
        toLabel.setLabelFor(desiredToPrice);
        this.itemLabel = new JLabel();
        itemLabel.setText("Item");
        this.zipLabel = new JLabel();
        zipLabel.setText("Zip Code");

        this.searchButton = new JButton();
        searchButton.setText("Search");

        sl_searchPanel = new SpringLayout();
        sl_searchPanel.putConstraint(SpringLayout.NORTH, itemLabel, 0, SpringLayout.NORTH, zipLabel);
        sl_searchPanel.putConstraint(SpringLayout.NORTH, toLabel, 0, SpringLayout.NORTH, fromLabel);
        sl_searchPanel.putConstraint(SpringLayout.NORTH, desiredToPrice, 0, SpringLayout.NORTH, desiredFromPrice);
        sl_searchPanel.putConstraint(SpringLayout.WEST, desiredToPrice, 80, SpringLayout.EAST, desiredFromPrice);
        sl_searchPanel.putConstraint(SpringLayout.SOUTH, fromLabel, -6, SpringLayout.NORTH, desiredFromPrice);
        this.searchPanel = new JPanel(sl_searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.WEST, itemLabel, 112, SpringLayout.WEST, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.EAST, zipLabel, -109, SpringLayout.EAST, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.NORTH, searchButton, 246, SpringLayout.NORTH, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.EAST, toLabel, -95, SpringLayout.EAST, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.NORTH, desiredFromPrice, 76, SpringLayout.NORTH, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.WEST, desiredFromPrice, 75, SpringLayout.WEST, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.EAST, desiredFromPrice, -269, SpringLayout.EAST, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.WEST, fromLabel, 86, SpringLayout.WEST, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.WEST, searchButton, 179, SpringLayout.WEST, searchPanel);
        sl_searchPanel.putConstraint(SpringLayout.EAST, searchButton, -177, SpringLayout.EAST, searchPanel);
        this.viewPanel = new JPanel(new SpringLayout());

        //Adds the two panels to the cardlayout
        panels.add(searchPanel, "KSL Search");
        panels.add(viewPanel, "Results");

        setupPanel();
        setupLayout();
        setupListeners();
	}
	
	private void setupPanel()
	{
		this.setPreferredSize(new Dimension(800, 600));
		this.setLayout(appLayout);

		//adds all components to the searchPanel
		searchPanel.add(desiredFromPrice);
		searchPanel.add(desiredToPrice);
		searchPanel.add(fromLabel);
		searchPanel.add(toLabel);
		searchPanel.add(itemLabel);
		searchPanel.add(zipLabel);
		this.desiredItem = new JTextField();
		sl_searchPanel.putConstraint(SpringLayout.EAST, desiredItem, 0, SpringLayout.EAST, desiredFromPrice);
		desiredItem.setColumns(8);
		searchPanel.add(desiredItem);
		this.desiredZip = new JTextField();
		sl_searchPanel.putConstraint(SpringLayout.NORTH, desiredItem, 0, SpringLayout.NORTH, desiredZip);
		sl_searchPanel.putConstraint(SpringLayout.SOUTH, desiredZip, -48, SpringLayout.NORTH, searchButton);
		sl_searchPanel.putConstraint(SpringLayout.SOUTH, zipLabel, -6, SpringLayout.NORTH, desiredZip);
		sl_searchPanel.putConstraint(SpringLayout.EAST, desiredZip, 0, SpringLayout.EAST, desiredToPrice);
		zipLabel.setLabelFor(desiredZip);
		desiredZip.setColumns(8);
		searchPanel.add(desiredZip);
		searchPanel.add(searchButton);
	}
	
	private void setupLayout()
	{
		
		
	}
	
	private void setupListeners()
	{
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				appController.searchForItem(desiredItem.getText(), desiredFromPrice.getText(), desiredToPrice.getText(), desiredZip.getText());
				
			}
				});
				
	}
}
