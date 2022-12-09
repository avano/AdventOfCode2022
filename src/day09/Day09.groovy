package day09

import util.Coordinate
import util.Input
import util.Inputs

Inputs.load(this)

Coordinate vector(String direction) {
	return switch (direction) {
		case 'R' -> [1, 0] as Coordinate
		case 'L' -> [-1, 0] as Coordinate
		case 'U' -> [0, 1] as Coordinate
		case 'D' -> [0, -1] as Coordinate
		default -> throw new IllegalArgumentException('Wrong direction')
	}
}

Coordinate step(Coordinate tail, Coordinate head) {
	Coordinate step = [0, 0] as Coordinate
	if (tail.isAdjacent(head)) {
		return step
	}

	if (tail.x > head.x) {
		step + vector('L')
	} else if (tail.x < head.x) {
		step + vector('R')
	}

	if (tail.y > head.y) {
		step + vector('D')
	} else if (tail.y < head.y) {
		step + vector('U')
	}

	return step
}

List<Coordinate> knots(int count) {
	List<Coordinate> knots = []
	count.times { knots.add([0, 0] as Coordinate) }
	return knots
}

int solve(Input input, List<Coordinate> knots, Closure compute) {
	Set<Coordinate> tailCoordinates = [knots.last()]

	input.asLines().each { line ->
		def (String direction, String count) = line.split(' ')
		(count as int).times {
			compute.call(direction, tailCoordinates)
		}
	}

	return tailCoordinates.size()
}

int part1(Input input = Inputs.input1) {
	List<Coordinate> knots = knots(2)

	return solve(input, knots) { String direction, Set tailCoordinates ->
		Coordinate head = knots.first()
		Coordinate tail = knots.last()
		head + vector(direction)
		tail + step(tail, head)
		tailCoordinates.add(tail)
	}
}

int part2(Input input = Inputs.input2) {
	List<Coordinate> knots = knots(10)

	return solve(input, knots) { String direction, Set tailCoordinates ->
		knots.first() + vector(direction)
		for (int i = 1; i < knots.size(); i++) {
			Coordinate previous = knots[i - 1]
			Coordinate tail = knots[i]
			tail + step(tail, previous)
		}
		tailCoordinates.add(knots.last())
	}
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
