package gui.view;

import javax.swing.*;

import gui.controller.GUIController;

public class WebFrame extends JFrame
{
	private GUIController appController;
	private WebPanel appPanel;
    private JPanel SearchPanel;
    private JPanel WebPanel;

    /**
     * Constructor used to initialize frame components
     * @param appController
     */
    public WebFrame(GUIController appController)
	{
		super();
		this.appController = appController;
		this.appPanel = new WebPanel(appController);

		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(800, 500);
		this.setTitle("KSL Search");
		this.setResizable(false);
		this.setVisible(true);
	}
}
