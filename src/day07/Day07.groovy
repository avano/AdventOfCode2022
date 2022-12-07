package day07

import util.Input
import util.Inputs

Inputs.load(this)

List<Node> parseFs(Input input, Node root = new Node(name: '/')) {
	Node current = root
	def leafDirs = []

	input.asLines().drop(1).each { line ->
		if (line.startsWith('$ cd')) {
			String dest = line - '$ cd '
			if (dest == '..') {
				if (current.isLeafDir()) {
					leafDirs.add(current)
				}
				current = current.parent
			} else {
				def destNode = current?.children?.find { n -> n.name == dest }
				current = destNode ?: new Node(name: dest, parent: root)
			}
		} else if (!line.startsWith('$ ls')) {
			def (String first, String name) = line.split(' ')
			def node = new Node(name: name, parent: current)
			if (first != 'dir') {
				node.addSize(first as int)
				node.children = null
			}
			current.children.add(node)
		}
	}

	if (current.isLeafDir()) {
		leafDirs.add(current)
	}

	return leafDirs
}

int traverseDirs(List<Node> leafDirs, int initValue, Closure compute) {
	int result = initValue
	while (leafDirs) {
		Node dir = leafDirs.pop()
		result = compute.call(result, dir) as int
		if (dir.parent.name != '/') {
			if (!leafDirs.contains(dir.parent)) {
				leafDirs.add(dir.parent)
			}
		}
	}
	return result
}

int part1(Input input = Inputs.input1) {
	def leafDirs = parseFs(input)

	int size = 100_000

	return traverseDirs(leafDirs, 0, { result, dir ->
		if (dir.size <= size) {
			result += dir.size
		}
		return result
	})
}

int part2(Input input = Inputs.input2) {
	Node root = new Node(name: '/')
	def leafDirs = parseFs(input, root)

	int size = Math.abs(70_000_000 - root.size - 30_000_000)

	return traverseDirs(leafDirs, Integer.MAX_VALUE, { result, dir ->
		if (dir.size >= size && dir.size < result) {
			result = dir.size
		}
		return result
	})
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
