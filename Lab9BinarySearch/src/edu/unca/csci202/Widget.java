package edu.unca.csci202;

public class Widget implements InventoryItem {

	private int sku;
	private String description;
	private double price;
	private int quantity;

	/**
	 * Constructor.
	 * 
	 * @param sku         an int representing the stock keeping unit number for the
	 *                    item
	 * @param description a String describing the inventory item
	 * @param price       a double representing the price of the item
	 * @param quantity    an int representing the quantity of the item on hand
	 */
	public Widget(int sku, String description, double price, int quantity) {
		this.sku = sku;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public int getSKU() {
		return sku;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("Widget[Desc: %s SKU: %d Price: $%4.2f Quantity: %d]", description, sku, price, quantity);
	}

	/**
	 * Test the InventoryItem class. (Note the explicit calls to each of the
	 * methods.)
	 * 
	 */
	public static void main(String[] args) {
		InventoryItem item1 = new Widget(123, "apple", 0.32, 100);
		System.out.println(item1);
		System.out.println("Item1 Description: " + item1.getDescription());
		System.out.println("Item1 SKU: " + item1.getSKU());
		System.out.println("Item1 Price: " + item1.getPrice());
		System.out.println("Item1 Quantity: " + item1.getQuantity());
		item1.setPrice(0.48);
		item1.setQuantity(10);
		System.out.println(item1);
	}

}
