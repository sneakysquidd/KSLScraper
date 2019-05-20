package gui.controller;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import gui.model.Item;
import gui.view.WebFrame;

import javax.imageio.ImageIO;

public class GUIController
{
	private WebFrame appFrame;
	
	public GUIController()
	{
		appFrame = new WebFrame(this);
	}
	
	public void start()
	{
		searchForItem("iphone", "1", "2", "84020");
	}


	public void searchForItem(String Item, String fromPrice, String toPrice, String zipCode)
	{
		final WebClient client = new WebClient(BrowserVersion.CHROME);


		try
		{
		  String searchUrl = "https://classifieds.ksl.com/search?category[]=&subCategory[]=&keyword=%24" + Item + "&priceFrom=%24" + fromPrice + "&priceTo=" + toPrice + "&zip=" + zipCode + "&miles=25&sellerType[]=&marketType[]=Sale&hasPhotos[]=&postedTime[]=";
		  HtmlPage page = client.getPage(searchUrl);
		  System.out.println(searchUrl);


		    //gets all the sections with items in them.
            final List<HtmlElement> items = page.getByXPath("//section");


            //removes index 0 because it is just the search results section
            items.remove(0);
            Item[] ItemArr = new Item[items.size()];


			if(items.isEmpty())
			{
				System.out.println("No items found !");
			}
			else
				{
				for(int i = 0;i<items.size();i++)
				{
                    ItemArr[i] = new Item();
					//Block to get the anchors/links for the item at the current index
					final List<HtmlAnchor> anchors = page.getByXPath("//a[@class='listing-item-link']");
						String itemUrl = "https://classifieds.ksl.com" + (anchors.get(i)).getHrefAttribute();
						System.out.println(itemUrl);
                        ItemArr[i].setUrl(itemUrl);

					//Block to get the title for item at the current index
					final List<HtmlElement> titles = page.getByXPath("//div[@class='item-info-title-link']");
					    String title = (titles.get(i)).getTextContent();
					    System.out.println(title);
                        ItemArr[i].setTitle(title);

					//Block to get the price for the item at the current index
					final List<HtmlElement> prices = page.getByXPath("//div[@class='item-info-price info-line']");
					    String price = (prices.get(i)).getTextContent();
					    if (price.equals(""))
					    {
						    price = (prices.get(i+1)).getTextContent();
					    }
					    System.out.println(price);
					    ItemArr[i].setPrice(price);


					//Block to get the images for the item at the current index
					//The else is used to skip over an extra image not related to the item
					final List<HtmlImage> imgs = page.getByXPath("//img");
					String image = "";
					    if (imgs.get(i).hasAttribute("title"))
					    {
						    image = "https://" + (imgs.get(i).getAttribute("src"));
					    }
					    else
					    {
						    image = "https://" + (imgs.get(i+1).getAttribute("src"));
					    }
					    System.out.println(image);
					    //saveImage(image, "./images");
                        ItemArr[i].setImage((image));
				}
			}
		}
		catch(Exception e)
		{
		  e.printStackTrace();
		}
	}


	//Method to get an image from a URL
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.0.2.100", 80));

	    HttpURLConnection connection =
	        (HttpURLConnection)new URL(imageUrl).openConnection(proxy);
	    ((HttpURLConnection)new URL(imageUrl).openConnection(proxy)).getInputStream();
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		System.out.println(connection.usingProxy());
		
		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}
}

