package works.blazing.inven.utils;

import works.blazing.inven.Window;
import works.blazing.inven.WindowType;

public record NodePosition(int x, int y) {

    public static NodePosition fromIndex(int index, Window window) {
        int x = index % window.getWidth();
        int y = index / window.getWidth();
        return new NodePosition(x, y);
    }

    public static NodePosition fromIndex(int index, WindowType windowType) {
        int x = index % windowType.getWidth();
        int y = index / windowType.getWidth();
        return new NodePosition(x, y);
    }
}
