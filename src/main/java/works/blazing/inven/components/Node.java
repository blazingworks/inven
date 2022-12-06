package works.blazing.inven.components;

import org.bukkit.inventory.ItemStack;
import works.blazing.inven.builders.StyleBuilder;
import works.blazing.inven.utils.NodePosition;

import java.util.UUID;

public abstract class Node {
    private ItemStack style;
    private NodePosition position = new NodePosition(0, 0);
    private UUID uuid;

    /**
     * @param style The style of the node as an ItemStack
     */
    public Node(ItemStack style) {
        this.style = style;
        this.uuid = UUID.randomUUID();
    }

    /**
     * @param style The style of the node as a StyleBuilder object
     */
    public Node(StyleBuilder style) {
        this(style.build());
    }

    /**
     * Regenerate the UUID of the node
     */
    public void regenerateUUID() {
        this.uuid = UUID.randomUUID();
    }

    /**
     * @return The UUID of the Node
     */
    public UUID getUUID() {
        return uuid;
    }

    /**
     * Sets the style of the node through an ItemStack
     */
    public void setStyle(ItemStack style) {
        this.style = style;
    }

    /**
     * Sets the style of the node through a StyleBuilder object
     */
    public void setStyle(StyleBuilder style) {
        this.style = style.build();
    }

    /**
     * @return The style of the node as an ItemStack
     */
    public ItemStack getStyle() {
        return style;
    }

    /**
     * Sets the position of the node
     */
    public void setPosition(NodePosition position) {
        this.position = position;
    }

    /**
     * Sets the position of the node through x and y values
     */
    public void setPosition(int x, int y) {
        this.position = new NodePosition(x, y);
    }

    /**
     * @return The position of the node as a NodePosition object
     */
    public NodePosition getPosition() {
        return position;
    }

    /**
     * @return The x position of the node
     */
    public int getX() {
        return position.x();
    }

    /**
     * @return The y position of the node
     */
    public int getY() {
        return position.y();
    }

    /**
     * @param x The x position of the node
     * @param y The y position of the node
     * @return Whether the node exists at the given position
     */
    public boolean existsAt(int x, int y) {
        return position.x() == x && position.y() == y;
    }

    /**
     * @param position
     * @return Whether the node exists at the given position
     */
    public boolean existsAt(NodePosition position) {
        return existsAt(position.x(), position.y());
    }

}
