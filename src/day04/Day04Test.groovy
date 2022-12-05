package day04

import org.junit.jupiter.api.Test

import util.DayTest

class Day04Test extends DayTest {
	@Override
	String input() {
		return """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 2
	}

	@Test
	void test2() {
		assert script.part2(input) == 4
	}
}
