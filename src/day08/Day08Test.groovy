package day08

import org.junit.jupiter.api.Test

import util.DayTest

class Day08Test extends DayTest {
	@Override
	String input() {
		return """30373
25512
65332
33549
35390
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 21
	}

	@Test
	void test2() {
		assert script.part2(input) == 8
	}
}
