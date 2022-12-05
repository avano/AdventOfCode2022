package day05

import util.Input
import util.Inputs

Inputs.load(this)

void ensureStack(List<Stack<String>> stackList, int index) {
	if (stackList.size() - 1 < index) {
		(index - (stackList.size() - 1)).times { stackList.add(new Stack<String>()) }
	}
}

void parseStackLine(String line, List<Stack<String>> stackList) {
	int stackIndex = 0
	int i = 1
	while (i < line.length()) {
		if (line[i].trim()) {
			ensureStack(stackList, stackIndex)
			stackList.get(stackIndex).push(line[i])
		}
		stackIndex++
		i += 4
	}
}

void reverseStacks(List<Stack<String>> stacks) {
	stacks.each { s ->
		List<String> reversed = s.reverse()
		s.clear()
		s.addAll(reversed)
	}
}

List<Stack<String>> parseStacks(List<String> lines) {
	def stacks = []
	lines.findAll { line -> line.contains('[') }.each { line -> parseStackLine(line, stacks) }
	reverseStacks(stacks)
	return stacks
}

String solve(Input input, Closure move) {
	List<Stack<String>> stacks = parseStacks(input.asLines())
	input.asLines().findAll { line -> line.contains('move') }.each { line ->
		def (count, from, to) = (line - "move " - "from " - "to ").split(' ')
		move.call(stacks, from as int - 1, to as int - 1, count as int)
	}
	return stacks.collect { s -> s.pop() }.join('')
}

String part1(Input input = Inputs.input1) {
	return solve(input, { stacks, from, to, count ->
		count.times { stacks.get(to).push(stacks.get(from).pop()) }
	})
}

String part2(Input input = Inputs.input2) {
	return solve(input, { stacks, from, to, count ->
		def elements = []
		count.times { elements.add(stacks.get(from).pop()) }
		stacks.get(to).addAll(elements.reverse())
	})
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
