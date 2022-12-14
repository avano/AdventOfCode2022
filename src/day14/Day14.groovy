package day14


import util.AOCMap
import util.Coordinate
import util.Input
import util.Inputs

Inputs.load(this)

AOCMap<Structure> loadMap(List<String> lines) {
	AOCMap<Structure> map = new AOCMap<>(1, 1, { int x, y -> new Structure(x, y) })

	lines.each { line ->
		def points = line.split(' -> ')
		for (int i = 0; i < points.size() - 1; i++) {
			Coordinate first = new Coordinate(points[i])
			Coordinate second = new Coordinate(points[i + 1])
			int x = Math.max(first.x, second.x)
			int y = Math.max(first.y, second.y)

			if (x >= map.length()) {
				(x - map.length() + 1).times { map.resizeX() }
			}
			if (y >= map.height()) {
				(y - map.height() + 1).times { map.resizeY() }
			}

			for (y; y >= Math.min(first.y, second.y); y--) {
				for (x = Math.max(first.x, second.x); x >= Math.min(first.x, second.x); x--) {
					map.get(x, y).value = '#'
				}
			}
		}
	}

	return map
}

Coordinate move(AOCMap<Structure> map, Coordinate current, Closure<Boolean> moveCondition, boolean part2 = false) {
	int y = current.y
	while (moveCondition.call(current.x, y)) {
		y++
		if (!part2 && y == map.height()) {
			throw new Exception('Part 1 stop')
		}
	}
	current = [current.x, y - 1] as Coordinate

	def movedLeft = false
	if (moveCondition.call(current.x - 1, current.y + 1)) {
		def newCoordinate = move(map, [current.x - 1, current.y + 1] as Coordinate, moveCondition, part2)
		movedLeft = newCoordinate != current
		current = newCoordinate
	}

	if (part2) {
		if (current.x + 1 == map.length()) {
			map.resizeX()
		}
	}
	if (!movedLeft && moveCondition.call(current.x + 1, current.y + 1)) {
		current = move(map, [current.x + 1, current.y + 1] as Coordinate, moveCondition, part2)
	}
	return current
}

int part1(Input input = Inputs.input1) {
	AOCMap<Structure> map = loadMap(input.asLines())

	int count = 0
	Coordinate start = [500, 0] as Coordinate

	while (true) {
		count++
		try {
			Coordinate c = move(map, start, { int x, int y -> map.get(x, y).value == '.' })
			map.get(c.x, c.y).value = 'o'
		} catch (Exception ignored) {
			return count - 1
		}
	}
}

int part2(Input input = Inputs.input2) {
	AOCMap<Structure> map = loadMap(input.asLines())
	2.times { map.resizeY() }

	int count = 0
	Coordinate start = [500, 0] as Coordinate

	while (true) {
		count++
		Coordinate c = move(map, start, { int x, int y -> map.get(x, y).value == '.' && y != map.height() - 1 }, true)
		if (c == start) {
			return count
		}
		map.get(c.x, c.y).value = 'o'
	}
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
