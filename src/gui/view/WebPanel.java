package gui.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import gui.controller.GUIController;
import gui.model.Item;
import java.io.*;

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
    private JButton saveButton;
    private JButton loadButton;
	
	private JScrollPane itemScroll;
	private JTextArea itemsText;

	
	/**
	 * WebPanel is the constructor for the GUI panel and is used to initialize all the GUI components required for the project
	 * @param appController
	 */
	public WebPanel(GUIController appController)
	{
		super();
		setBackground(new Color(102, 204, 255));
        this.appController = appController;
        appLayout = new SpringLayout();
        this.itemScroll = new JScrollPane();
        this.desiredItem = new JTextField();
        this.desiredFromPrice = new JTextField();
        this.itemsText = new JTextArea();
        itemsText.setEditable(false);
        itemScroll.setViewportView(itemsText);
        //this.itemsText = new JTextArea(20,20);
        itemsText.setLineWrap(true);
        itemsText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        itemsText.setColumns(100);
        itemsText.setRows(7);
        this.desiredZip = new JTextField();
        appLayout.putConstraint(SpringLayout.EAST, desiredZip, -52, SpringLayout.EAST, this);
        this.saveButton = new JButton("Save Results");
        appLayout.putConstraint(SpringLayout.NORTH, saveButton, 6, SpringLayout.SOUTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.WEST, saveButton, 330, SpringLayout.WEST, this);
        this.logo = new JLabel();
        logo.setEnabled(false);
        //logo.setIcon(new ImageIcon(WebPanel.class.getResource("/Images/kslLogo.png")));
        this.desiredToPrice = new JTextField();
        this.fromLabel = new JLabel();
        this.toLabel = new JLabel();
        this.itemLabel = new JLabel();
        this.zipLabel = new JLabel();
        this.loadButton = new JButton("Load Previous Results");
        appLayout.putConstraint(SpringLayout.EAST, saveButton, -51, SpringLayout.WEST, loadButton);
        appLayout.putConstraint(SpringLayout.NORTH, loadButton, 6, SpringLayout.SOUTH, desiredToPrice);
        appLayout.putConstraint(SpringLayout.WEST, loadButton, 513, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.EAST, loadButton, -106, SpringLayout.EAST, this);
        this.searchButton = new JButton();
        appLayout.putConstraint(SpringLayout.NORTH, searchButton, 6, SpringLayout.SOUTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.WEST, searchButton, 29, SpringLayout.WEST, desiredItem);
        appLayout.putConstraint(SpringLayout.EAST, searchButton, -68, SpringLayout.WEST, saveButton);
                
        setupPanel();
        setupLayout();
        setupListeners();
        
        
	}
	
	/**
	 * used to add all the GUI components to the panel shown on the frame
	 */
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
		this.add(saveButton);
		this.add(loadButton);
		      
	}
	/**
	 * sets all of the constraints for the GUI components
	 */
	private void setupLayout()
	{
        fromLabel.setText("Lowest Price");
        toLabel.setText("  Highest Price");
        itemLabel.setText("Item");
        zipLabel.setText("Zip Code");
        searchButton.setText("Search");
		zipLabel.setLabelFor(desiredZip);
        appLayout.putConstraint(SpringLayout.WEST, desiredZip, 55, SpringLayout.EAST, desiredToPrice);
        appLayout.putConstraint(SpringLayout.NORTH, desiredToPrice, 0, SpringLayout.NORTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.WEST, desiredToPrice, 55, SpringLayout.EAST, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.EAST, desiredToPrice, -244, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.NORTH, zipLabel, 0, SpringLayout.NORTH, fromLabel);
        appLayout.putConstraint(SpringLayout.WEST, zipLabel, 101, SpringLayout.EAST, desiredToPrice);
        appLayout.putConstraint(SpringLayout.NORTH, fromLabel, 0, SpringLayout.NORTH, itemLabel);
        appLayout.putConstraint(SpringLayout.NORTH, itemLabel, 29, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.WEST, itemLabel, 102, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.NORTH, toLabel, 0, SpringLayout.NORTH, fromLabel);
        appLayout.putConstraint(SpringLayout.NORTH, desiredFromPrice, 6, SpringLayout.SOUTH, fromLabel);
        appLayout.putConstraint(SpringLayout.WEST, fromLabel, 86, SpringLayout.EAST, desiredItem);
        appLayout.putConstraint(SpringLayout.NORTH, logo, 0, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.WEST, logo, 382, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.NORTH, desiredZip, 0, SpringLayout.NORTH, desiredFromPrice);
        appLayout.putConstraint(SpringLayout.WEST, desiredFromPrice, 53, SpringLayout.EAST, desiredItem);
        appLayout.putConstraint(SpringLayout.EAST, desiredFromPrice, -431, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.NORTH, desiredItem, 49, SpringLayout.NORTH, this);
        appLayout.putConstraint(SpringLayout.WEST, desiredItem, 52, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.EAST, desiredItem, -616, SpringLayout.EAST, this);
        appLayout.putConstraint(SpringLayout.NORTH, itemsText, 79, SpringLayout.SOUTH, searchButton);
        appLayout.putConstraint(SpringLayout.WEST, itemsText, 165, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.SOUTH, itemsText, -98, SpringLayout.SOUTH, this);
        appLayout.putConstraint(SpringLayout.EAST, itemsText, 0, SpringLayout.EAST, toLabel);
        appLayout.putConstraint(SpringLayout.NORTH, itemScroll, -346, SpringLayout.SOUTH, this);
        appLayout.putConstraint(SpringLayout.WEST, itemScroll, 26, SpringLayout.WEST, this);
        appLayout.putConstraint(SpringLayout.SOUTH, itemScroll, -23, SpringLayout.SOUTH, this);
        appLayout.putConstraint(SpringLayout.EAST, itemScroll, -24, SpringLayout.EAST, this);
		itemScroll.setBorder(new LineBorder(Color.BLUE));
        appLayout.putConstraint(SpringLayout.WEST, toLabel, 107, SpringLayout.EAST, fromLabel);
        appLayout.putConstraint(SpringLayout.EAST, toLabel, 0, SpringLayout.EAST, desiredToPrice);

        //doc.addStyle(name, null);
	}
	/**
	 * This method is what gets the path for where you are saving or loading a file from.
	 * @param choice It takes the directory choice for the path.
	 * @return It returns the path for the file.
	 */
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if(choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getCurrentDirectory().getAbsolutePath();
			}
		}
		else
		{
			result = fileChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
		}
		return path;
	}

	/**
	 * adds listeners for the buttons in the project to add functionality to them
	 */
	private void setupListeners()
	{
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				itemsText.setText("Items will appear here shortly...");
				Item[] ItemArr = appController.searchForItem(desiredItem.getText(), desiredFromPrice.getText(), desiredToPrice.getText(), desiredZip.getText());
				itemsText.setText("");
				for (Item item : ItemArr)
				{
					itemsText.append(item.getTitle() + "  " + item.getPrice() + "\n");
					itemsText.append(item.getUrl() + "\n");
					itemsText.append("\n");
					
					
					itemsText.revalidate();
					itemsText.repaint();
				}
				
			
			}
				});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String wordText = itemsText.getText();
				//the . assigns the save to the current directory
				String path = getPath("save");
				try
				{
					appController.saveAs((itemsText.getText()), path);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				itemsText.setText("Word saved!");
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String items = "File Not loaded Correctly";
				String path = getPath("load");
				try
				{
					items = appController.loadResults(path);
				} catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				itemsText.setText(items);
			}
		});
	}
}
