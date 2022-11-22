package day01

import org.junit.jupiter.api.Test

import util.Input

class Day01Test {
	def script = new GroovyShell().parse(new File("src/day01/Day01.groovy"))
	def input = """
1000
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

	@Test
	void test1() {
		assert script.part1(new Input(input: input)) == 24000
	}

	@Test
	void test2() {
		assert script.part2(new Input(input: input)) == 45000
	}
}
