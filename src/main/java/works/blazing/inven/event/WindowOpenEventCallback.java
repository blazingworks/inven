package works.blazing.inven.event;

import org.bukkit.event.inventory.InventoryOpenEvent;

public interface WindowOpenEventCallback {
    void onOpen(InventoryOpenEvent inventoryOpenEvent);
}
