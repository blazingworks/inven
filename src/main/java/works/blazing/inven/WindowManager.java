package works.blazing.inven;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class WindowManager implements Listener {
    private static WindowManager instance;
    static Plugin plugin;
    private static final HashMap<Player, Window> windows = new HashMap<>();

    public static WindowManager getInstance(Plugin plugin) {
        if (instance == null) {
            instance = new WindowManager();
        }
        WindowManager.plugin = plugin;
        return instance;
    }

    private WindowManager() {
    }

    public static void addWindow(Player player, Window window) {
        windows.put(player, window);
    }

    public static void removeWindow(Player player) {
        windows.remove(player);
    }

    public static Window getWindow(Player player) {
        return windows.get(player);
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        // Loop through all windows
        for (Player player : windows.keySet()) {
            Window window = windows.get(player);
            window.handleInventoryOpenEvent(event);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        // Loop through all windows
        for (Player player : windows.keySet()) {
            Window window = windows.get(player);
            window.handleInventoryCloseEvent(event);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Loop through all windows
        for (Player player : windows.keySet()) {
            Window window = windows.get(player);
            window.handleInventoryClickEvent(event);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        windows.remove(event.getPlayer());
    }

}
