package gui.view;

import javax.swing.JFrame;
import gui.controller.GUIController;

public class FirstFrame extends JFrame
{
	private GUIController appController;
	private FirstPanel appPanel;
	
	public FirstFrame(GUIController appController)
	{
		super();
		this.appController = appController;
		this.appPanel = new FirstPanel(appController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(800, 800);
		this.setTitle("GU(cc)I Gang");
		this.setResizable(true);
		this.setVisible(true);
	}
}
