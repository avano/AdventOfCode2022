package day13

import util.Input
import util.Inputs

Inputs.load(this)

List parseList(String line) {
	def list = []
	Stack<List> nestedLists = [list] as Stack

	for (int i = 1; i < line.length() - 1; i++) {
		if (line[i] == '[') {
			nestedLists.push([])
		} else if (line[i] == ']') {
			List pop = nestedLists.pop()
			nestedLists.peek().add(pop)
		} else if (line[i] != ',') {
			def str = line[i]
			if (line[i + 1] in '0'..'9') {
				str += line[i + 1]
				i++
			}
			nestedLists.peek().add(str as int)
		}
	}
	return list
}

Result compare(left, right) {
	if (left == null && right == null) {
		return Result.MAYBE
	}

	if (left != null && right == null) {
		return Result.NO
	}

	if (left == null && right != null) {
		return Result.YES
	}

	if (left instanceof Integer && right instanceof Integer) {
		return left == right ? Result.MAYBE : left > right ? Result.NO : Result.YES
	}

	if (!(left instanceof List)) {
		left = [left]
	}
	if (!(right instanceof List)) {
		right = [right]
	}

	List nextLeft = left.size() > 1 ? left.subList(1, left.size()) : null
	List nextRight = right.size() > 1 ? right.subList(1, right.size()) : null

	return compare(left[0], right[0]) & (compare(nextLeft, nextRight))
}

List<List> parsePackets(List<String> lines) {
	def packets = []
	for (int i = 0; i < lines.size(); i += 3) {
		packets.add(parseList(lines[i]))
		packets.add(parseList(lines[i + 1]))
	}
	return packets
}

int part1(Input input = Inputs.input1) {
	def packets = parsePackets(input.asLines())
	def result = 0
	for (int i = 0; i < packets.size() - 1; i += 2) {
		List left = packets[i]
		List right = packets[i + 1]
		if (compare(left, right) == Result.YES) {
			result += i / 2 + 1
		}
	}

	return result
}

int part2(Input input = Inputs.input2) {
	def packets = parsePackets(input.asLines())
	List div1 = [[2]]
	List div2 = [[6]]
	packets.add(div1)
	packets.add(div2)

	packets.sort {left, right ->
		switch (compare(left, right)) {
			case Result.NO -> 1
			case Result.MAYBE -> 0
			case Result.YES -> -1
		}
	}

	return (packets.indexOf(div1) + 1) * (packets.indexOf(div2) + 1)
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
