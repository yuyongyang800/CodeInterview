package Interview;

/**
 * Created by yongyangyu on 9/1/15.
 */
public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(x);
        sb.append(", ");
        sb.append(y);
        sb.append(')');
        return sb.toString();
    }

}

