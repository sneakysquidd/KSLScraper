package gui.controller;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import com.fa;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
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
		  String searchUrl = "https://classifieds.ksl.com/search?category[]=&subCategory[]=&keyword=%24" + URLEncoder.encode(Item, "UTF-8") + "&priceFrom=%24" + URLEncoder.encode(fromPrice, "UTF-8") + "&priceTo=" + URLEncoder.encode(toPrice, "UTF-8") + "&zip=" + URLEncoder.encode(zipCode, "UTF-8") + "&miles=25&sellerType[]=&marketType[]=Sale&hasPhotos[]=&postedTime[]=";
		  HtmlPage page = client.getPage(searchUrl);
		  
		  List<HtmlElement> items = (List<HtmlElement>) page.getByXPath("//span[@class='rows']/p") ;
			if(items.isEmpty()){
				System.out.println("No items found !");
			}else{
				for(HtmlElement item : items){
					HtmlAnchor itemAnchor = ((HtmlAnchor) item.getFirstByXPath(".//span[@class='txt']/span[@class='pl']/a"));

					String itemName = itemAnchor.asText();
					String itemUrl = itemAnchor.getHrefAttribute() ;

					HtmlElement spanPrice = ((HtmlElement) item.getFirstByXPath(".//span[@class='txt']/span[@class='l2']/span[@class='price']")) ;
					// It is possible that an item doesn't have any price
					String itemPrice = spanPrice == null ? "no price" : spanPrice.asText() ;
					System.out.println( String.format("Name : %s Url : %s Price : %s", itemName, itemPrice, itemUrl));
				}
			}
		}catch(Exception e){i
		  e.printStackTrace();
		}
		}
	}

