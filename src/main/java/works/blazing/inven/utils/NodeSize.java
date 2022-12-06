package works.blazing.inven.utils;

public class NodeSize {
    private final int width;
    private final int height;

    public NodeSize() {
        this(1, 1);
    }

    public NodeSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
