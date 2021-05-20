package Alghorithm.classCodes;

public class ClosestPair {

    class Coordinate {
        private int x;
        private int y;


        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    private Coordinate[] coordinate;

    public ClosestPair() {
        coordinate = new Coordinate[20];
    }

    public Coordinate getClosestPair() {
        return null;
    }

    private Double distance(Coordinate first, Coordinate second) {

        double xPower = (first.getX() - second.getX()) * (first.getX() - second.getX());
        double yPower = (first.getY() - second.getY()) * (first.getY() - second.getY());
        double distance = Math.sqrt(yPower + xPower);

        return distance;
    }

    
}

class Main {

    public static void main(String[] args) {

    }
}
