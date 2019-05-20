package gui.model;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Item
{
	private String title;
	private String price;
	private String url;
	private String img;

	public Item()
	{
	//Constructor
	}

	public Item(String Title, String Price, String URL, String image)
	{
		this.title = Title;
		this.price = Price;
		this.url = URL;
		this.img = image;
	}


	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getPrice()
	{
		return price;
	}
	public void setPrice(String price)
	{
		this.price = price;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getImage()
	{
		return img;
	}

	public void setImage(String img)
	{
		this.img = img;
	}
}
