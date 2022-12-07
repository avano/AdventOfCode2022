package day07

class Node {
	String name
	int size
	Node parent
	List<Node> children = []

	void addSize(int size) {
		this.size = size;

		def parent = this.parent
		while (parent != null) {
			parent.size += this.size
			parent = parent.parent
		}
	}

	boolean isLeafDir() {
		return children?.every { child -> !child.children }
	}
}
