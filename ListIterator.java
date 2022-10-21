/**
 * This represents the iterator design pattern which is implemented by OfferingIterator class.
 */
public interface ListIterator {

	public abstract boolean hasNext();

	public abstract Object Next();

	public abstract void MoveToHead();

	public abstract void Remove();

}
