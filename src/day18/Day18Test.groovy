package day18

import org.junit.jupiter.api.Test

import util.DayTest
import util.Input

class Day18Test extends DayTest {
	@Override
	String input() {
		return """2,2,2
1,2,2
3,2,2
2,1,2
2,3,2
2,2,1
2,2,3
2,2,4
2,2,6
1,2,5
3,2,5
2,1,5
2,3,5
"""
	}

	@Test
	void test1() {
		//[[2,1,1], [2,2,2]]
		//[[2,2,1], [2,1,2]]
//		assert script.part1(new Input(input: '1,1,1\n2,1,1')) == 10
//		assert script.part1(new Input(input: """2,2,2
//2,2,1""")) == 10
		// [2,2,2] [3,3,2]
		// [2,2,2] [3,3,2]
//		assert script.part1(new Input(input: """2,2,2
//1,2,2
//3,2,2
//2,1,2
//2,3,2
//2,2,1
//2,2,3""")) == 24
		assert script.part1(input) == 64
	}

	@Test
	void test2() {
		assert script.part2(input) == -1
	}
}
