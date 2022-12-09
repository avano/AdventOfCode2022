package day09

import org.junit.jupiter.api.Test

import util.DayTest
import util.Input

class Day09Test extends DayTest {
	@Override
	String input() {
		return """R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 13
	}

	@Test
	void test2() {
		assert script.part2(input) == 1
		assert script.part2(new Input(input: """R 5
U 8
L 8
D 3
R 17
D 10
L 25
U 20""")) == 36
	}
}
