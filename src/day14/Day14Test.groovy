package day14

import org.junit.jupiter.api.Test

import util.DayTest

class Day14Test extends DayTest {
	@Override
	String input() {
		return """498,4 -> 498,6 -> 496,6
503,4 -> 502,4 -> 502,9 -> 494,9
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 24
	}

	@Test
	void test2() {
		assert script.part2(input) == 93
	}
}
