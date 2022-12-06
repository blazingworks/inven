package works.blazing.inven.builders;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class StyleBuilder {
    private Material material;
    private int amount = 1;
    private String displayName;
    private List<Component> lore;
    private Enchantment[] enchantments;

    public StyleBuilder() {

    }

    public StyleBuilder material(Material material) {
        this.material = material;
        return this;
    }

    public StyleBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public StyleBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public StyleBuilder lore(Component... lore) {
        this.lore = List.of(lore);
        return this;
    }

    public StyleBuilder lore(List<Component> lore) {
        this.lore = lore;
        return this;
    }

    public StyleBuilder lore(String... lore) {
        this.lore = new ArrayList<>();
        for (String line : lore) {
            this.lore.add(Component.text(line));
        }
        return this;
    }

    public StyleBuilder enchantments(Enchantment... enchantments) {
        this.enchantments = enchantments;
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(material, amount);
        if (displayName != null) {
            item.editMeta(meta -> meta.displayName(Component.text(displayName)));
        }
        if (lore != null) {
            item.editMeta(meta -> meta.lore(lore));
        }
        if (enchantments != null) {
            for (Enchantment enchantment : enchantments) {
                item.addUnsafeEnchantment(enchantment, 1);
            }
        }
        return item;
    }
}
