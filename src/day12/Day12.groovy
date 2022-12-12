package day12

import util.AOCMap
import util.Input
import util.Inputs

Inputs.load(this)

AOCMap<Hill> loadMap(List<String> lines) {
	return new AOCMap<Hill>(lines, { int x, int y, char value ->
		new Hill(x, y, value)
	})
}

List<Hill> getLowestPoints(AOCMap<Hill> map) {
	List<Hill> lowest = []
	map.each { int x, int y ->
		if (map.get(x, y).height == ((int) ('a' as char))) {
			lowest.add(map.get(x, y))
		}
	}
	return lowest
}

int bfs(AOCMap<Hill> map, Queue<Hill> queue) {
	while (queue) {
		Hill current = queue.poll()
		if (current.value == 'E' as char) {
			return current.distance
		}
		current.visited = true

		map.surround4(current.x, current.y)
				.findAll { c ->
					!c.visited && current.height - c.height >= -1
				}.each { c ->
			c.distance = current.distance + 1
			if (!queue.contains(c)) {
				queue.add(c)
			}
		}
	}
	return Integer.MAX_VALUE
}

int part1(Input input = Inputs.input1) {
	AOCMap<Hill> map = loadMap(input.asLines())
	Queue<Hill> queue = getLowestPoints(map).findAll { h -> h.value == 'S' as char } as Queue
	return bfs(map, queue)
}

int part2(Input input = Inputs.input2) {
	AOCMap<Hill> map = loadMap(input.asLines())

	List<Hill> starts = getLowestPoints(map)

	int min = Integer.MAX_VALUE
	starts.each {
		Queue<Hill> queue = [it] as Queue
		int current = bfs(map, queue)
		if (min > current) {
			min = current
		}
		map.each { int x, int y ->
			map.get(x, y).visited = false
			map.get(x, y).distance = 0
		}
	}
	return min
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
