package gui.controller;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import gui.view.WebFrame;

public class GUIController
{
	private WebFrame appFrame;
	
	public GUIController()
	{
		appFrame = new WebFrame(this);
	}
	
	public void start()
	{
		searchForItem("iphone", "1", "1", "84020");
	}
	
	public static void searchForItem(String Item, String fromPrice, String toPrice, String zipCode)
	{
		WebClient client = new WebClient();  
		client.getOptions().setCssEnabled(false);  
		client.getOptions().setJavaScriptEnabled(false);  
		try {  
		 String searchUrl = "https://classifieds.ksl.com/search?category[]=&subCategory[]=&keyword=%24" + Item + "&priceFrom=%24" + fromPrice + "&priceTo=" + toPrice + "&zip=" + zipCode + "&miles=25&sellerType[]=&marketType[]=Sale&hasPhotos[]=&postedTime[]=";
		  HtmlPage page = client.getPage(searchUrl);
		  System.out.println(searchUrl);

            final List<?> divs = page.getByXPath("//div");
            for(int i=0;i<divs.size();i++)
            {
                System.out.println(divs.get(i));
            }

            List<HtmlElement> items =  page.getByXPath("//section[@class='listing-item normal']");
			if(divs.isEmpty()){
				System.out.println("No items found !");
			}else{
				for(HtmlElement item : items){

				}
			}
		}catch(Exception e){
		  e.printStackTrace();
		}
		}
	}

