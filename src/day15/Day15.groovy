package day15

import util.Coordinate
import util.Input
import util.Inputs

Inputs.load(this)

int distance(Coordinate c1, Coordinate c2) {
	return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y)
}

Map<Coordinate, Coordinate> parse(List<String> lines) {
	Map<Coordinate, Coordinate> sb = [:]
	lines.each { line ->
		def matcher = line =~ /Sensor at x=(.*), y=(.*): closest beacon is at x=(.*), y=(.*)/
		if (matcher.find()) {
			Coordinate sensor = [matcher[0][1] as int, matcher[0][2] as int] as Coordinate
			Coordinate beacon = [matcher[0][3] as int, matcher[0][4] as int] as Coordinate
			sb[sensor] = beacon
		}
	}

	return sb
}

int part1(Input input = Inputs.input1, int y = 2000000) {
	def sb = parse(input.asLines())

	Set<Integer> points = []
	sb.forEach { sensor, beacon ->
		int distance = distance(sensor, beacon)
		if (y in (sensor.y - distance)..(sensor.y + distance)) {
			points.add(sensor.x)
			for (int i = 1; i <= (distance - Math.abs(sensor.y - y)); i++) {
				[-1, 1].each { sign -> points.add(sensor.x - (i * sign)) }
			}
		}
	}

	sb.values().findAll { beacon -> beacon.y == y }.forEach { beacon -> points.remove(beacon.x) }
	sb.keySet().findAll { sensor -> sensor.y == y }.forEach { sensor -> points.remove(sensor.x) }
	return points.size()
}

long part2(Input input = Inputs.input2, int max = 4000000) {
	Map<Coordinate, Coordinate> sb = parse(input.asLines())

	List<Coordinate> outerPoints = []
	for (e in sb) {
		Coordinate sensor = e.key
		Coordinate beacon = e.value
		int distance = distance(sensor, beacon) + 1
		for (int i = 0; i <= distance; i++) {
			[-1, 1].each { j ->
				[-1, 1].each { k ->
					int x = sensor.x - (distance * j) - (i * k)
					int y = sensor.y - (i * k)
					if (x in (0..max) && y in (0..max)) {
						outerPoints.add([x, y] as Coordinate)
					}
				}
			}
		}
	}

	for (p in outerPoints) {
		if (sb.every { sensor, beacon -> distance(p, sensor) > distance(sensor, beacon) }) {
			return p.x * 4000000L + p.y
		}
	}
	return -1
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
