package day03

import util.Input
import util.Inputs

Inputs.load(this)

int priority(char c) {
	return ((int) c) - (Character.isLowerCase(c) ? 96 : 38)
}

int part1(Input input = Inputs.input1) {
	return input.asLines().inject(0) { result, line ->
		int half = line.length().intdiv(2)
		result += priority(line.substring(half).find { ch -> (ch as char) in line.toCharArray()[0..half - 1] } as char)
	}
}

int part2(Input input = Inputs.input2) {
	int result = 0
	List<String> lines = input.asLines()
	for (int i = 0; i < lines.size(); i += 3) {
		List<String> sublist = lines.subList(i, i + 3).toSorted { it.length() }
		result += priority(sublist.removeLast().find { ch -> sublist.every { el -> el.contains(ch) } } as char)
	}
	return result
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
