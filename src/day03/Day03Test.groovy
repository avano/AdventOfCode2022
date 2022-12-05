package day03

import org.junit.jupiter.api.Test

import util.DayTest

class Day03Test extends DayTest {
	@Override
	String input() {
		return """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 157
	}

	@Test
	void test2() {
		assert script.part2(input) == 70
	}
}
