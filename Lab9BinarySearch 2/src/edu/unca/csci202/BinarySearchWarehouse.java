package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchWarehouse<T extends InventoryItem> extends Warehouse<T> {

	@Override
	protected int findHelper(int sku) {
		// do a recursive binary search for item with the sku.
		return binarySearchBySKU(sku, 0, inventory.size() - 1);
	}

	/**
	 * Binary search recursive algo to find the item with the matching sku. Searches
	 * within the sub array of the iventory from index lower to upper, inclusive.
	 * 
	 * @param sku   The sku key
	 * @param lower smallest index of current subproblem
	 * @param upper largest index of the current subproblem
	 * @return index of matching sku item, or, -1
	 */
	private int binarySearchBySKU(int sku, int lower, int upper) {
		// base cases
		if (upper < lower) { // no elements
			return -1;
		} else if (lower == upper) {// one element
			if (inventory.get(upper).getSKU() == sku) { // one element does match
				return upper;
			} else
				return -1;
		}
		// recursive case (2+ elements)
		int middleIndex = (upper + lower) / 2;
		int middleSKU = inventory.get(middleIndex).getSKU();
		if (middleSKU == sku) {
			return middleIndex;
		} else if (sku < middleSKU) {
			return binarySearchBySKU(sku, lower, middleIndex - 1);
		} else { // greater than >
			return binarySearchBySKU(sku, middleIndex + 1, upper);
		}
	}

	@Override
	public Iterator<T> priceRangeSearch(double lowPrice, double highPrice) {
		// sort by price (standard lib sort)
		inventory.sort(new PriceComparator<T>());
		// make collection of results
		ArrayList<T> results = new ArrayList<>();
		// recursive method & base cases
		// firstInRange &
		int first = firstInRange(lowPrice, 0, inventory.size());
		// recusriveFill
		if (first != -1) {
	        recursiveFill(results, first, highPrice);
	    }
		// return itr...
		return results.iterator();
	}
	
	private void recursiveFill(ArrayList<T> results, int i, double highPrice) {
	    if (i >= inventory.size() || inventory.get(i).getPrice() > highPrice) {
	        return;
	    }
	    
	    results.add(inventory.get(i));	    
	    recursiveFill(results, i + 1, highPrice);
	}
	
	private int firstInRange(double minPrice, int start, int end) {
		if (end < start) {
			return -1;
		}

		int middleIndex = (start + end) / 2;
		double middlePrice = inventory.get(middleIndex).getPrice();
		if (middlePrice >= minPrice) {
			int prevIndex = firstInRange(minPrice, start, middleIndex - 1);
			if (prevIndex != -1) {
				return prevIndex;
			} else {
				return middleIndex;
			}
		} else
			return firstInRange(minPrice, middleIndex + 1, end);
	}

}
