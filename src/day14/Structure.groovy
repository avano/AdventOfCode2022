package day14

import util.Coordinate

class Structure extends Coordinate {
	String value = '.'

	Structure(x, y) {
		super(x, y)
	}

	String toString() {
		return value
	}
}
