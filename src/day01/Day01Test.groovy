package day01

import org.junit.jupiter.api.Test

import util.DayTest

class Day01Test extends DayTest {
	@Override
	String input() {
		return """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 24000
	}

	@Test
	void test2() {
		assert script.part2(input) == 45000
	}
}
