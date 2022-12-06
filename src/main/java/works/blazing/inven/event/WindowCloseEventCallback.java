package works.blazing.inven.event;

import org.bukkit.event.inventory.InventoryCloseEvent;

public interface WindowCloseEventCallback {
    void onClose(InventoryCloseEvent inventoryCloseEvent);
}
