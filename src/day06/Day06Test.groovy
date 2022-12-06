package day06

import org.junit.jupiter.api.Test

import util.DayTest
import util.Input

class Day06Test extends DayTest {
	@Override
	String input() {
		return ""
	}

	@Test
	void test1() {
		def tests = [
				'mjqjpqmgbljsphdztnvjfqwrcgsmlb'   : 7,
				'bvwbjplbgvbhsrlpgdmjqwftvncz'     : 5,
				'nppdvjthqldpwncqszvftbrmjlhg'     : 6,
				'nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg': 10,
				'zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw' : 11
		]

		tests.each { assert script.part1(new Input(input: it.key)) == it.value }
	}

	@Test
	void test2() {
		def tests = [
				'mjqjpqmgbljsphdztnvjfqwrcgsmlb'   : 19,
				'bvwbjplbgvbhsrlpgdmjqwftvncz'     : 23,
				'nppdvjthqldpwncqszvftbrmjlhg'     : 23,
				'nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg': 29,
				'zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw' : 26
		]

		tests.each { assert script.part2(new Input(input: it.key)) == it.value }
	}
}
