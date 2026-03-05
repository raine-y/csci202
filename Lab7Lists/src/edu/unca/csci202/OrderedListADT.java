package edu.unca.csci202;

/**
 * A list of elements kept sorted at all times
 * @param <T> the kind of item stored in this list
 */
public interface OrderedListADT<T extends Comparable<T>> extends ListADT<T> {
	/**
	 * Add the param element into the list at the correct place in order to keep the list sorted
	 * @param element the item to be added to list
	 */
	public void add(T element);
}
