package works.blazing.inven.event;

import org.bukkit.event.inventory.InventoryClickEvent;

public interface ButtonClickEventCallback {
    void onClick(InventoryClickEvent buttonClickEvent);
}
