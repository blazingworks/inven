package works.blazing.inven;

import org.bukkit.event.inventory.InventoryType;

public enum WindowType {
    CHEST1(1, 9, 9),
    CHEST2(2, 9, 18),
    CHEST3(3, 9, 27),
    CHEST4(4, 9, 36),
    CHEST5(5, 9, 45),
    CHEST6(6, 9, 54),
    DROPPER(3, 3, InventoryType.DROPPER),
    HOPPER(1, 5, InventoryType.HOPPER),
    ONEBYNINE(1, 9, 9),
    TWOBYNINE(2, 9, 18),
    THREEBYNINE(3, 9, 27),
    FOURBYNINE(4, 9, 36),
    FIVEBYNINE(5, 9, 45),
    SIXBYNINE(6, 9, 54),
    THREEBYTHREE(3, 3, InventoryType.DROPPER),
    ONEBYFIVE(1, 5, InventoryType.HOPPER);

    private final int height;
    private final int width;
    private InventoryType type;
    private int size;

    WindowType(int height, int width, InventoryType type) {
        this.height = height;
        this.width = width;
        this.type = type;
    }

    WindowType(int height, int width, int size) {
        this.height = height;
        this.width = width;
        this.size = size;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getSize() {
        return this.height * this.width;
    }

    public InventoryType getType() {
        return type;
    }

    public int getRawSize() {
        return size;
    }
}
