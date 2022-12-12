package util

class AOCMap<T> {
	List<List<T>> map = []

	AOCMap(List<String> lines) {
		lines.each { line ->
			List<T> row = []
			line.each { ch -> row.add(ch as T) }
			map.add(row)
		}
	}

	AOCMap(List<String> lines, Closure transform) {
		for (int y = 0; y < lines.size(); y++) {
			List<T> row = []
			for (int x = 0; x < lines[y].size(); x++) {
				row.add(transform.call(x, y, lines[y][x] as char) as T)
			}
			map.add(row)
		}
	}

	T get(int x, int y) {
		return map[y][x]
	}

	void each(Closure compute) {
		for (int y = 0; y < map.size(); y++) {
			for (int x = 0; x < map[y].size(); x++) {
				compute(x, y)
			}
		}
	}

	String toString() {
		String result = ''
		for (List<T> row : map) {
			for (T el : row) {
				result += el
			}
			result += '\n'
		}
		return result
	}

	List<List<T>> toEdges(int x, int y) {
		List<List<T>> result = [[]]
		def vectors = [[-1, 0], [1, 0], [0, -1], [0, 1]]
		for (Tuple vector : vectors) {
			int xx = x + (vector.first() as int)
			int yy = y + (vector.last() as int)
			while (xx >= 0 && xx < map[0].size() && yy >= 0 && yy < map.size()) {
				result.last().add(get(xx, yy))
				xx += (vector.first() as int)
				yy += (vector.last() as int)
			}
			result.add([])
		}

		return result.dropRight(1)
	}

	List<T> surround4(int x, int y) {
		List<T> result = []
		if (x - 1 >= 0) {
			result.add(get(x - 1, y))
		}
		if (x + 1 < map[0].size()) {
			result.add(get(x + 1, y))
		}
		if (y - 1 >= 0) {
			result.add(get(x, y - 1))
		}
		if (y + 1 < map.size()) {
			result.add(get(x, y + 1))
		}
		return result
	}

	boolean isCorner(int x, int y) {
		return x == 0 || y == 0 || x == map[0].size() - 1 || y == map.size() - 1
	}
}
