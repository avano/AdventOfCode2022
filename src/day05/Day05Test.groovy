package day05

import org.junit.jupiter.api.Test

import util.DayTest

class Day05Test extends DayTest {
	@Override
	String input() {
		return """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 'CMZ'
	}

	@Test
	void test2() {
		assert script.part2(input) == 'MCD'
	}
}
