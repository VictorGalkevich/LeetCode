import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Problem1496 {
    public static void main(String[] args) {
        System.out.println(isPathCrossing(new String("NESWW")));
    }

    public static boolean isPathCrossing(String path) {
        Map<Point, Boolean> map = new HashMap<>();
        int xPos = 0;
        int yPos = 0;
        for (int i = 0; i < path.length(); i++) {
            if (map.get(new Point(xPos, yPos)) == null) {
                map.put(new Point(xPos, yPos), true);
            } else {
                return true;
            }
            switch (path.charAt(i)) {
                case 'W' -> xPos--;
                case 'S' -> yPos--;
                case 'N' -> yPos++;
                case 'E' -> xPos++;
            }
        }
        if (map.get(new Point(xPos, yPos)) == null) {
            map.put(new Point(xPos, yPos), true);
        } else {
            return true;
        }
        return false;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
