package com.redestelar.boss.plugin.sword.storage.loader;

import com.redestelar.boss.framework.util.inventory.item.ItemBuilder;
import com.redestelar.boss.plugin.BossPlugin;
import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.plugin.sword.data.BossSword;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;

import java.util.List;

/**
 * @author oNospher
 **/
public class BossSwordLoader {

    public BossSwordLoader() {
        FileConfiguration configuration = BossPlugin.getInstance().getConfig();
        configuration.getConfigurationSection("settings.swords").getKeys(false).forEach(key -> {
            ConfigurationSection section = configuration.getConfigurationSection("settings.ranks." + key);

            String name = section.getString("name");
            Double damage = section.getDouble("damage");

            String friendlyItemName = section.getString("item.friendly-name");
            Material material = Material.valueOf(section.getString("item.material"));
            List<String> lore = section.getStringList("item.lore");
            boolean glow = section.getBoolean("item.glow");

            ItemBuilder itemBuilder = new ItemBuilder(material).name(friendlyItemName).lore(lore);

            if(glow) itemBuilder.enchant(Enchantment.WATER_WORKER, 1).hideAttributes();;

            BossSword bossSword = new BossSword(
                    itemBuilder.build(),
                    damage
            );

            BossProvider.Cache.BOSS_SWORD_CACHE.insert(name, bossSword);
        });
    }
}
