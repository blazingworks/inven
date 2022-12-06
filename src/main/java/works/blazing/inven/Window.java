package works.blazing.inven;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import works.blazing.inven.components.Background;
import works.blazing.inven.components.Border;
import works.blazing.inven.components.Button;
import works.blazing.inven.components.Node;
import works.blazing.inven.event.WindowCloseEventCallback;
import works.blazing.inven.event.WindowOpenEventCallback;
import works.blazing.inven.utils.NodePosition;

import java.util.ArrayList;
import java.util.List;

public class Window {
    private final Inventory inventory;
    private final Player owner;
    private final List<Node> nodes = new ArrayList<>();
    private Background background;
    private Border border;
    private final WindowType type;
    private final List<WindowCloseEventCallback> closeHandlers = new ArrayList<>();
    private final List<WindowOpenEventCallback> openHandlers = new ArrayList<>();
    private boolean closable = true;

    public Window(WindowType type, Player owner, String title) {
        this(type, owner, Component.text(title));
    }

    public Window(WindowType type, Player owner, Component title) {
        if(type.getType() != null) {
            this.inventory = Bukkit.createInventory(owner, type.getType(), title);
        } else {
            this.inventory = Bukkit.createInventory(owner, type.getRawSize(), title);
        }
        this.owner = owner;
        this.type = type;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getOwner() {
        return owner;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Background getBackground() {
        return background;
    }

    public Border getBorder() {
        return border;
    }

    public WindowType getType() {
        return type;
    }

    public int getHeight() {
        return type.getHeight();
    }

    public int getWidth() {
        return type.getWidth();
    }

    public void open() {
        this.populate();
        owner.openInventory(inventory);
        WindowManager.addWindow(owner, this);
    }

    public void close() {
        owner.closeInventory();
        WindowManager.removeWindow(owner);
    }

    public boolean isClosable() {
        return closable;
    }

    public void setClosable(boolean closable) {
        this.closable = closable;
    }

    public void add(Node node) {
        nodes.add(node);
    }

    public void populate() {
        if (background != null) {
            for (Node node : background.getNodes()) {
                this.inventory.setItem(node.getX() + node.getY() * 9, node.getStyle());
            }
        }
        if (border != null) {
            for (Node node : border.getNodes()) {
                this.inventory.setItem(node.getX() + node.getY() * 9, node.getStyle());
            }
        }
        for (Node node : this.nodes) {
            this.inventory.setItem(node.getX() + node.getY() * 9, node.getStyle());
        }
    }

    public void onClose(WindowCloseEventCallback callback) {
        closeHandlers.add(callback);
    }

    public void onOpen(WindowOpenEventCallback callback) {
        openHandlers.add(callback);
    }

    public List<WindowCloseEventCallback> getCloseHandlers() {
        return closeHandlers;
    }

    protected void handleInventoryClickEvent(InventoryClickEvent event) {
        // Make sure the Inventory clicked is the this Window
        if (event.getClickedInventory() != this.inventory) return;

        // Make sure the player is the owner of the Window
        if (event.getWhoClicked() != this.owner) return;

        // Make sure the player is not clicking outside the inventory
        if (event.getSlot() == -999) return;

        event.setCancelled(true);

        for (Node node : this.nodes) {
            if(node.existsAt(NodePosition.fromIndex(event.getSlot(), this.type))) {
                if(node instanceof Button button) {
                    button.getClickHandlers().forEach(callback -> callback.onClick(event));
                }
            }
        }
    }

    protected void handleInventoryCloseEvent(InventoryCloseEvent event) {
        // Make sure the Inventory closed is this Window
        if(!event.getInventory().equals(this.inventory)) return;

        // Call the callbacks
        this.closeHandlers.forEach(callback -> callback.onClose(event));

        InventoryCloseEvent.Reason reason = event.getReason();

        // Cancel if the window is not closable
        if(!this.closable && (reason == InventoryCloseEvent.Reason.PLAYER || reason == InventoryCloseEvent.Reason.UNKNOWN || reason == InventoryCloseEvent.Reason.TELEPORT || reason == InventoryCloseEvent.Reason.CANT_USE || reason == InventoryCloseEvent.Reason.DEATH || reason == InventoryCloseEvent.Reason.OPEN_NEW || reason == InventoryCloseEvent.Reason.UNLOADED)) {
            (new BukkitRunnable() {
                public void run() {
                    Window.this.open();
                }
            }).runTaskLater(WindowManager.plugin, 2L);
        } else {
            WindowManager.removeWindow(this.owner);
        }
    }

    protected void handleInventoryOpenEvent(InventoryOpenEvent event) {
        // Make sure the Inventory opened is this Window
        if(!event.getInventory().equals(this.inventory)) return;

        // Call the callbacks
        this.openHandlers.forEach(callback -> callback.onOpen(event));
    }

}
