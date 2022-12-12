package day12

import util.Coordinate

class Hill extends Coordinate {
	char value
	boolean visited = false
	int distance = 0

	Hill(x, y, value) {
		super(x, y)
		this.value = value
	}

	int getHeight() {
		return switch (value) {
			case 'S' -> (int) ('a' as char)
			case 'E' -> (int) ('z' as char)
			default -> (int) value
		}
	}
}
