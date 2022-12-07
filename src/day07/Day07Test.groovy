package day07

import org.junit.jupiter.api.Test

import util.DayTest

class Day07Test extends DayTest {
	@Override
	String input() {
		return """\$ cd /
\$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
\$ cd a
\$ ls
dir e
29116 f
2557 g
62596 h.lst
\$ cd e
\$ ls
584 i
\$ cd ..
\$ cd ..
\$ cd d
\$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k
"""
	}

	@Test
	void test1() {
		assert script.part1(input) == 95437
	}

	@Test
	void test2() {
		assert script.part2(input) == 24933642
	}
}
