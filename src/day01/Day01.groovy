package day01

import util.Input
import util.Inputs

Inputs.load(this)

int part1(Input input = Inputs.input1) {
	def lines = input.asLines()
	def current = 0
	def max = -1
	for (int i = 0; i < lines.size(); i++) {
		if (lines[i].trim()) {
			current += lines[i] as int
		}
		// extra case for the last element
		if (i == lines.size() - 1 || lines[i].trim().isEmpty()) {
			if (current > max) {
				max = current
			}
			current = 0
		}
	}
	return max
}

int part2(Input input = Inputs.input2) {
	def lines = input.asLines()
	def current = 0
	def max = []
	for (int i = 0; i < lines.size(); i++) {
		if (lines[i].trim()) {
			current += lines[i] as int
		}
		// extra case for the last element
		if (i == lines.size() - 1 || lines[i].trim().isEmpty()) {
			max.add(current)
			current = 0
		}
	}

	return max.sort()[-3..-1].sum() as int
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
