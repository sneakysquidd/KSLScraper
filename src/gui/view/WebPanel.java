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

	public WebPanel(GUIController appController)
	{
		super();
        this.appController = appController;
        appLayout = new CardLayout();
        panels = new JPanel(new CardLayout());

        this.desiredFromPrice = new JTextField();
        this.desiredToPrice = new JTextField();
        this.desiredItem = new JTextField();
        this.desiredZip = new JTextField();

        this.fromLabel = new JLabel();
        this.toLabel = new JLabel();
        this.itemLabel = new JLabel();
        this.zipLabel = new JLabel();

        this.searchButton = new JButton();

        this.searchPanel = new JPanel();
        this.viewPanel = new JPanel();

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
		searchPanel.add(desiredItem);
		searchPanel.add(desiredZip);
		searchPanel.add(fromLabel);
		searchPanel.add(toLabel);
		searchPanel.add(itemLabel);
		searchPanel.add(zipLabel);
		searchPanel.add(searchButton);
	}
	
	private void setupLayout()
	{
		
		
	}
	
	private void setupListeners()
	{
		
				
	}
}
