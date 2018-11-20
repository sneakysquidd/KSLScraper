package gui.controller;

import gui.model.Minion;
import gui.view.FirstFrame;

public class GUIController
{
	private Minion myMinion;
	private FirstFrame appFrame;
	
	public GUIController()
	{
		myMinion = new Minion();

		appFrame = new FirstFrame(this);
	}
	
	public void start()
	{
		
	}
	
}
