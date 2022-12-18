package day18

import util.Coordinate
import util.Input
import util.Inputs

Inputs.load(this)

void compareSides(List<Tuple<ZCoordinate>> sides, Tuple<ZCoordinate> current) {
	def find = sides.find {it?.first() == current.first() && it?.last() == current.last() }
	if (find) {
		println("Removing ${find}")
		sides.remove(find)
	} else {
		sides.add(current)
	}
}

int part1(Input input = Inputs.input1) {
/*
- predna
- [x,y,z] + [x+1,y,z+1]
- [1,1,1] + [2,1,2]
- prava
- [x+1,y,z] + [x+1,y+1,z+1]
- [2,1,1] + [2,2,2]
- zadna
- [x,y+1,z] + [x+1,y+1,z+1]
- [1,2,1] + [2,2,2]
- lava
- [1,1,1] + [1,2,2]
- [x,y,z] + [x,y+1,z+1]
- dolna
- [1,1,1] + [2,2,1]
- [x,y,z] + [x+1,y+1,z]
- horna
- [1,1,2] + [2,2,2]
 */
	List<Tuple<ZCoordinate>> sides = []
	input.asLines().each { line ->
		def (x,y,z) = line.split(',')
		x = x as int
		y = y as int
		z = z as int

		// predna
		compareSides(sides, new Tuple([x,y,z] as ZCoordinate, [x+1, y, z+1] as ZCoordinate))
		// prava
		compareSides(sides, new Tuple([x+1,y,z] as ZCoordinate, [x+1, y+1, z+1] as ZCoordinate))
		// zadna
		compareSides(sides, new Tuple([x,y+1,z] as ZCoordinate, [x+1, y+1, z+1] as ZCoordinate))
		// lava
		compareSides(sides, new Tuple([x,y,z] as ZCoordinate, [x, y+1, z+1] as ZCoordinate))
		// horna
		compareSides(sides, new Tuple([x,y+1,z+1] as ZCoordinate, [x+1, y+1, z+1] as ZCoordinate))
		// spodna
		compareSides(sides, new Tuple([x,y,z] as ZCoordinate, [x+1, y+1, z] as ZCoordinate))
	}

	for (int i = 0; i < sides.size(); i++) {
		println(sides[i])
		if (i ==5) {
			println()
		}
	}

//3668 too low
	// 8550 too high
	return sides.size()
}

long part2(Input input = Inputs.input2) {
	return -1
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
