package backtTracking;

public class ReachDestination {
	 // Optimized approach using reverse simulation
    // Instead of moving from (sx, sy) to (dx, dy),
    // work backwards from destination to source.
    //
    // Reverse of:
    // (a, b) -> (a + b, b)
    // (a, b) -> (a, a + b)
    //
    // is:
    // if dx > dy, then dx = dx % dy
    // else dy = dy % dx
    //
    // This reduces the numbers very quickly and avoids TLE.

    public static boolean canReach(int sx, int sy, int dx, int dy) {

        while (dx >= sx && dy >= sy) {

            // Reached source
            if (dx == sx && dy == sy) {
                return true;
            }

            // If one coordinate already matches source,
            // the other must be reachable by repeated additions.
            if (dx == sx) {
                return (dy - sy) % sx == 0;
            }

            if (dy == sy) {
                return (dx - sx) % sy == 0;
            }

            // Reduce the larger coordinate
            if (dx > dy) {
                dx = dx % dy;
            } else {
                dy = dy % dx;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int sx = 1, sy = 1;
        int dx = 3, dy = 5;

        System.out.println(canReach(sx, sy, dx, dy)); // true
    }

}
