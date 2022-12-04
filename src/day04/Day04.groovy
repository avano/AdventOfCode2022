package day04

import util.Input
import util.Inputs

Inputs.load(this)

IntRange[] parseLine(String line) {
	def matcher = line =~ Constants.LINE_REGEX
	return [new IntRange(matcher[0][1] as int, matcher[0][2] as int), new IntRange(matcher[0][3] as int, matcher[0][4] as int)]
}

int part1(Input input = Inputs.input1) {
	int result = 0
	input.asLines().each { line ->
		def (IntRange r1, IntRange r2) = parseLine(line)
		if ((r1.from <= r2.from && r1.to >= r2.to) || (r2.from <= r1.from && r2.to >= r1.to)) {
			result++
		}
	}
	return result
}

int part2(Input input = Inputs.input2) {
	return input.asLines().inject(0) { result, line ->
		def (IntRange r1, IntRange r2) = parseLine(line)
		result += r1.any { n -> r2.contains(n) } ? 1 : 0
	}
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
