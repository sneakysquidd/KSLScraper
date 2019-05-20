package gui.view;

import gui.controller.GUIController;

import javax.swing.*;
import java.awt.*;


public class SearchPanel extends JPanel
{
    private CardLayout appLayout;
    private GUIController appController;

    private JTextField desiredFromPrice;
    private JTextField desiredToPrice;
    private JTextField desiredItem;
    private JTextField desiredZip;

    private JLabel fromLabel;
    private JLabel toLabel;
    private JLabel itemLabel;
    private JLabel zipLabel;


    public SearchPanel(GUIController appController)
    {
        super();
        this.appController = appController;

        appLayout = new CardLayout();

        setupPanel();
        setupLayout();
        setupListeners();
    }

    private void setupPanel()
    {

    }

    private void setupLayout()
    {

    }

    private void setupListeners()
    {

    }
}
