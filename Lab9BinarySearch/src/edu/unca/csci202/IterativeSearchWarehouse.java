package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Iterator;

public class IterativeSearchWarehouse<T extends InventoryItem> extends Warehouse<T> {

	@Override
	protected int findHelper(int sku) {
		// do a linear time iterative linear search for the item with the sku.
		for (int i = 0; i < inventory.size(); i++) {
			int currSKU = inventory.get(i).getSKU();
			if (currSKU == sku) {
				return i;
			}
		} // end of the loop
		return -1; // not found
	}

	@Override
	public Iterator<T> priceRangeSearch(double lowPrice, double highPrice) {
		// sort by price (standard lib sort)
		inventory.sort(new PriceComparator<T>());
		// make collection of results
		ArrayList<T> results = new ArrayList<>();
		// fill collction with all items in the price range from inv.
		for (int i = 0; i < inventory.size(); i++) {
			double currPrice = inventory.get(i).getPrice();
			if (currPrice >= lowPrice && currPrice <= highPrice) {
				results.add(inventory.get(i));
			}
		}
		// return an iterator over the reults
		return results.iterator();
	}

}