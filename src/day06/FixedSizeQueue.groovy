package day06

class FixedSizeQueue<T> extends LinkedList<T> {
	private int size

	@Override
	boolean add(T e) {
		if (super.size() >= this.size) {
			super.removeFirst()
		}
		super.add(e)
	}
}
