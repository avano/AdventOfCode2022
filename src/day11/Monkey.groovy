package day11

class Monkey {
	List<Long> items = []
	int mod
	Closure<Long> operation
	Closure<Integer> test
	int inspectCount = 0

	long inspectItem(long item, Closure<Long> compute) {
		inspectCount++
		return compute.call(this, item);
	}
}
