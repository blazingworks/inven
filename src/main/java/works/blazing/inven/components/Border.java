package works.blazing.inven.components;

import org.bukkit.inventory.ItemStack;
import works.blazing.inven.builders.StyleBuilder;

import java.util.ArrayList;
import java.util.List;

public class Border {
    private final ItemStack style;
    private final int thickness;

    /**
     * @param style The style of the border as an ItemStack
     */
    public Border(ItemStack style) {
        this(style, 1);
    }

    /**
     * @param style The style of the border as an ItemStack
     * @param thickness The thickness of the border
     */
    public Border(ItemStack style, int thickness) {
        this.style = style;
        this.thickness = thickness;
    }

    /**
     * @param style The style of the border as a StyleBuilder object
     */
    public Border(StyleBuilder style) {
        this(style.build());
    }

    /**
     * @param style The style of the border as a StyleBuilder object
     * @param thickness The thickness of the border
     */
    public Border(StyleBuilder style, int thickness) {
        this(style.build(), thickness);
    }

    /**
     * @return The style of the border as an ItemStack
     */
    public ItemStack getStyle() {
        return style;
    }

    /**
     * @return The thickness of the border
     */
    public int getThickness() {
        return thickness;
    }

    /**
     * @return A list of nodes that make up the border
     */
    public List<Node> getNodes() {
        return new ArrayList<>();
    }
}
