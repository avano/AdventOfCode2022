package day02

import org.junit.jupiter.api.Test

import util.DayTest

class Day02Test extends DayTest {
	@Override
	String input() {
		return """
A Y
B X
C Z
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 15
	}

	@Test
	void test2() {
		assert script.part2(input) == 12
	}
}
