package day10

import util.Input
import util.Inputs

Inputs.load(this)

int part1(Input input = Inputs.input1) {
	int x = 1
	int cycle = 0

	int result = 0

	input.asLines().each { line ->
		int count = (line == 'noop') ? 1 : 2
		count.times {
			cycle++
			result += (((cycle - 20) % 40) == 0) ? (cycle * x) : 0
		}
		if (line.contains('addx')) {
			x += (line - 'addx ') as int
		}
	}
	return result
}

String part2(Input input = Inputs.input2) {
	int x = 1
	int cycle = 0

	String currentLine = ''
	String result = ''

	input.asLines().each { line ->
		int count = (line.contains('addx')) ? 2 : 1
		count.times {
			cycle++
			currentLine += (x in (currentLine.length() - 1)..(currentLine.length() + 1)) ? '#' : '.'
			if (cycle == 40) {
				result += currentLine + "\n"
				currentLine = ''
				cycle = 0
			}
		}
		if (line.contains('addx')) {
			x += (line - 'addx ') as int
		}
	}
	return result
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
