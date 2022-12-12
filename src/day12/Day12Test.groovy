package day12

import org.junit.jupiter.api.Test

import util.DayTest

class Day12Test extends DayTest {
	@Override
	String input() {
		return """Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 31
	}

	@Test
	void test2() {
		assert script.part2(input) == 29
	}
}
