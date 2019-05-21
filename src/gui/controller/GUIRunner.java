package gui.controller;

import java.util.logging.Level;

public class GUIRunner
{
	public static void main(String [ ] args)
	{
		//These lines are used to suppress unnecessary htmlUnit errors
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

		GUIController app = new GUIController();
		app.start();
	}
}


