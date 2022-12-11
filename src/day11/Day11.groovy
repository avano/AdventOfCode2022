package day11

import util.Input
import util.Inputs

Inputs.load(this)

List<Monkey> loadMonkeys(List<String> input) {
	def monkeys = []

	for (int i = 1; i < input.size(); i += 7) {
		Monkey m = new Monkey()
		m.items = (input[i] - 'Starting items: ').trim().split(', ').collect { it as long }
		m.operation = new GroovyShell().evaluate("{ old -> " + (input[i + 1] - 'Operation: new = ').trim() + "}") as Closure
		m.mod = (input[i + 2] - 'Test: divisible by ').trim() as int
		int ifTrue = (input[i + 3] - 'If true: throw to monkey ').trim() as int
		int ifFalse = (input[i + 4] - 'If false: throw to monkey ').trim() as int
		m.test = { item -> item % m.mod == 0 ? ifTrue : ifFalse }
		monkeys.add(m)
	}

	return monkeys
}

long solve(List<Monkey> monkeys, int count, Closure compute) {
	count.times {
		for (m in monkeys) {
			def currentItems = m.items.collect()
			for (int i = 0; i < currentItems.size(); i++) {
				long item = m.items.pop()
				item = m.inspectItem(item, compute)
				monkeys[m.test.call(item)].items.add(item)
			}
		}
	}

	return monkeys.sort { m -> m.inspectCount }.takeRight(2).inject(1L) { result, monkey -> result *= monkey.inspectCount }
}

long part1(Input input = Inputs.input1) {
	return solve(loadMonkeys(input.asLines()), 20) { Monkey monkey, Long item ->
		Math.floor((monkey.operation.call(item)) / 3.0)
	}
}

long part2(Input input = Inputs.input2) {
	def monkeys = loadMonkeys(input.asLines())
	long mod = monkeys.collect { m -> m.mod }.stream().reduce { a, b -> lcm(a, b) }.get()

	return solve(monkeys, 10000) { Monkey monkey, Long item ->
		return monkey.operation.call(item) % mod
	}
}

long lcm(a, b) {
	return (a * b) / gcf(a, b)
}

long gcf(a, b) {
	return b == 0 ? a : gcf(b, a % b)
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
