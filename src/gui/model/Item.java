package gui.model;

import javax.swing.*;

public class Item
{
	private String title;
	private String price;
	private String url;
	private ImageIcon img;

	public Item()
	{
	//Constructor
	}

	public Item(String Title, String Price, String URL, ImageIcon image)
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

	public ImageIcon getImage()
	{
		return img;
	}

	public void setImage(ImageIcon img)
	{
		this.img = img;
	}
}
