package day13

import org.junit.jupiter.api.Test

import util.DayTest

class Day13Test extends DayTest {
	@Override
	String input() {
		return """[1,1,3,1,1]
[1,1,5,1,1]

[[1],[2,3,4]]
[[1],4]

[9]
[[8,7,6]]

[[4,4],4,4]
[[4,4],4,4,4]

[7,7,7,7]
[7,7,7]

[]
[3]

[[[]]]
[[]]

[1,[2,[3,[4,[5,6,7]]]],8,9]
[1,[2,[3,[4,[5,6,0]]]],8,9]
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 13
	}

	@Test
	void test2() {
		assert script.part2(input) == 140
	}
}
