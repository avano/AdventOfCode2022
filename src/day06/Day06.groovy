package day06

import util.Input
import util.Inputs

Inputs.load(this)

boolean isMarker(FixedSizeQueue<String> queue, int size) {
	if (queue.size() < size) {
		return false
	}

	def seen = ''

	for (int i = 0; i < queue.size(); i++) {
		if (seen.contains(queue[i] as String)) {
			return false
		}
		seen += queue[i]
	}
	return true
}

int solve(Input input, int markerSize) {
	def queue = new FixedSizeQueue<String>(size: markerSize)
	for (int i = 0; i < input.asElements().size(); i++) {
		queue.add(input.asString().trim()[i])
		if (isMarker(queue, markerSize)) {
			return i + 1
		}
	}
	return -1
}

int part1(Input input = Inputs.input1) {
	return solve(input, 4)
}

int part2(Input input = Inputs.input2) {
	return solve(input, 14)
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
