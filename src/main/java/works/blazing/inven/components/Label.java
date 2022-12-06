package works.blazing.inven.components;

import org.bukkit.inventory.ItemStack;
import works.blazing.inven.builders.StyleBuilder;

public class Label extends Node {

    /**
     * @param style The style of the node as an ItemStack
     */
    public Label(ItemStack style) {
        super(style);
    }

    /**
     * @param style The style of the node as a StyleBuilder object
     */
    public Label(StyleBuilder style) {
        super(style);
    }
}
