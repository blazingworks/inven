package works.blazing.inven.components;

import org.bukkit.inventory.ItemStack;
import works.blazing.inven.builders.StyleBuilder;
import works.blazing.inven.event.ButtonClickEventCallback;

import java.util.ArrayList;
import java.util.List;

public class Button extends Node {
    private final List<ButtonClickEventCallback> clickHandlers = new ArrayList<>();

    /**
     * @param style The style of the node as an ItemStack
     */
    public Button(ItemStack style) {
        super(style);
    }

    /**
     * @param style The style of the node as a StyleBuilder object
     */
    public Button(StyleBuilder style) {
        super(style);
    }

    public void onClick(ButtonClickEventCallback callback) {
        clickHandlers.add(callback);
    }

    public List<ButtonClickEventCallback> getClickHandlers() {
        return clickHandlers;
    }
}
