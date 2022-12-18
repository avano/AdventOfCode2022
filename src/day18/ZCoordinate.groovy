package day18

import util.Coordinate

class ZCoordinate extends Coordinate {
    int z

    ZCoordinate(x, y, z) {
        super(x, y)
        this.z = z
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.class) return false
        if (!super.equals(o)) return false

        ZCoordinate that = (ZCoordinate) o

        if (z != that.z) return false

        return true
    }

    int hashCode() {
        int result = super.hashCode()
        result = 31 * result + z
        return result
    }

    String toString() {
        return "[$x,$y,$z]"
    }
}
