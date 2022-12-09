package util

class Coordinate {
	int x, y

	Coordinate(x, y) {
		this.x = x
		this.y = y
	}

	void plus(Coordinate other) {
		x += other.x
		y += other.y
	}

	boolean isAdjacent(Coordinate other) {
		return Math.abs(x - other.x) <= 1 && Math.abs(y - other.y) <= 1
	}

	String toString() {
		return "[$x, $y]"
	}

	boolean equals(o) {
		if (this.is(o)) return true
		if (o == null || getClass() != o.class) return false

		Coordinate that = (Coordinate) o

		if (x != that.x) return false
		if (y != that.y) return false

		return true
	}

	int hashCode() {
		int result
		result = 23 * x
		result = 31 * result + y
		return result
	}
}
