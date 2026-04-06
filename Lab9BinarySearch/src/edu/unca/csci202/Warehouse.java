package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public abstract class Warehouse<T extends InventoryItem> implements InventorySystem<T> {
	// data fields
	protected ArrayList<T> inventory;

	// constructors

	public Warehouse() {
		inventory = new ArrayList<T>();
	}

	// abstract methods for subclasses

	/**
	 * Find the InventoryItem with the given sku.
	 * 
	 * @param sku
	 * @return the index in the inventory list of the found item, -1 if not found.
	 */
	protected abstract int findHelper(int sku);

	@Override
	public abstract Iterator<T> priceRangeSearch(double lowPrice, double highPrice);

	// defined interface methods

	@Override
	public void addItem(T item) {
		inventory.add(item);
	}

	@Override
	public T findItem(int sku) {
		int location = findHelper(sku);
		if (location == -1)
			return null;
		else
			return inventory.get(location);
	}

	@Override
	public void removeItem(int sku) {
		int location = findHelper(sku);
		if (location == -1)
			return;
		else
			inventory.remove(location);
	}

	@Override
	public void updateItemQuantity(int sku, int quantity) {
		int location = findHelper(sku);
		if (location == -1)
			return;
		else
			inventory.get(location).setQuantity(quantity);
	}

	@Override
	public void updateItemPrice(int sku, double price) {
		int location = findHelper(sku);
		if (location == -1)
			return;
		else
			inventory.get(location).setPrice(price);
	}

	@Override
	public String toString() {
		return inventory.toString();
	}

	protected class PriceComparator<T extends InventoryItem> implements Comparator<T> {
		@Override
		public int compare(T o1, T o2) {
			return (int) (o1.getPrice() - o2.getPrice());
		}
	}
	
} // end of Warehouse superclass