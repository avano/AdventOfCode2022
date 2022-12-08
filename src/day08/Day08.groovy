package day08

import util.AOCMap
import util.Input
import util.Inputs

Inputs.load(this)

int part1(Input input = Inputs.input1) {
	AOCMap<Integer> map = new AOCMap(input.asLines())
	int result = 0
	map.each { int x, int y ->
		if (map.isCorner(x, y) || map.toEdges(x, y).any { line -> line.every { e -> e < map.get(x, y) } }) {
			result += 1
		}
	}
	return result
}

int part2(Input input = Inputs.input2) {
	AOCMap<Integer> map = new AOCMap(input.asLines())
	int max = -1
	map.each { int x, int y ->
		int current = 1
		map.toEdges(x, y).each { line ->
			int lineTrees = 0
			for (int i = 0; i < line.size(); i++) {
				lineTrees++
				if (line[i] >= map.get(x, y)) {
					break
				}
			}
			current *= lineTrees
		}
		if (current > max) {
			max = current
		}
	}
	return max
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
