package works.blazing.inven.components;

import org.bukkit.inventory.ItemStack;
import works.blazing.inven.builders.StyleBuilder;

import java.util.ArrayList;
import java.util.List;

public class Background {
    private final ItemStack style;

    /**
     * @param style The style of the background as an ItemStack
     */
    public Background(ItemStack style) {
        this.style = style;
    }

    /**
     * @param style The style of the background as a StyleBuilder object
     */
    public Background(StyleBuilder style) {
        this(style.build());
    }

    /**
     * @return The style of the background as an ItemStack
     */
    public ItemStack getStyle() {
        return style;
    }

    /**
     * @return A list of nodes that make up the background
     */
    public List<Node> getNodes() {
        return new ArrayList<>();
    }
}
