package gui.controller;

import java.net.URLEncoder;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import gui.model.Minion;
import gui.view.WebFrame;

public class GUIController
{
	private Minion myMinion;
	private WebFrame appFrame;
	
	public GUIController()
	{
		myMinion = new Minion();

		appFrame = new WebFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public static void searchForItem(String Item, String fromPrice, String toPrice, String zipCode)
	{
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		try {  
		  String searchUrl = "https://classifieds.ksl.com/search?category[]=&subCategory[]=&keyword=" + URLEncoder.encode(Item, "UTF-8") + "&priceFrom=$1&priceTo=$2&zip=" + URLEncoder.encode(zipCode, "UTF-8") + "&miles=25&sellerType[]=&marketType[]=Sale&hasPhotos[]=&postedTime[]=";
		  HtmlPage page = client.getPage(searchUrl);
		}catch(Exception e){
		  e.printStackTrace();
		}
		}
	}

