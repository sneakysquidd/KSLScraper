package gui.view;

import javax.swing.JFrame;
import gui.controller.GUIController;

public class WebFrame extends JFrame
{
	private GUIController appController;
	private WebPanel appPanel;
	
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
		this.setSize(800, 800);
		this.setTitle("Final");
		this.setResizable(false);
		this.setVisible(true);
	}
}
