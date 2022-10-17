package maestro194.bomberman.testing.objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Position up(int speed) {
        return new Position(x, y - speed);
    }

    public Position down(int speed) {
        return new Position(x, y + speed);
    }

    public Position left(int speed) {
        return new Position(x - speed, y);
    }

    public Position right(int speed) {
        return new Position(x + speed, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        Position tmp = (Position) obj;
        if(getX() != tmp.getX()) {
            return false;
        }
        if(getY() != tmp.getY()) {
            return false;
        }
        return true;
    }
}
