package com.redestelar.boss.plugin.boss.data;

import com.kirelcodes.miniaturepets.mob.Mob;
import com.kirelcodes.miniaturepets.mob.MobContainer;
import com.redestelar.boss.framework.util.inventory.item.ItemBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * @author oNospher
 **/
@RequiredArgsConstructor
@Getter
public class Boss {

    private final String name;
    private final String friendlyName;
    private final Mob mob;
    private final List<Item> items;

    public void summon(Location location, MobContainer mobContainer) {

    }

    public double getHealth() {
        return mob.getNavigator().getHealth();
    }

    public double getMaxHealth() {
        return mob.getNavigator().getMaxHealth();
    }

    public ItemStack getItem() {
        ItemBuilder item = new ItemBuilder(Material.DRAGON_EGG)
                .name("" + friendlyName + " §c(BOSS)")
                .lore("§7",
                        "§7Coloque esse ovo na sua plot para spawnar o boss.",
                        "§7")
                .enchant(Enchantment.WATER_WORKER, 1)
                .hideAttributes();

        return item.build();
    }

    @AllArgsConstructor @Getter
    public static class Item {
        private final ItemStack item;
        private final Double chance;
    }
}
