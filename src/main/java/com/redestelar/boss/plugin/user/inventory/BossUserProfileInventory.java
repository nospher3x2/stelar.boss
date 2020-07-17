package com.redestelar.boss.plugin.user.inventory;

import com.redestelar.boss.plugin.user.data.BossUser;
import com.redestelar.boss.framework.util.inventory.InventoryBuilder;
import com.redestelar.boss.framework.util.inventory.item.ItemBuilder;
import com.redestelar.boss.plugin.ranking.inventory.RankingBossUserInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * @author oNospher
 **/
public class BossUserProfileInventory {

    public static InventoryBuilder getInventory(BossUser bossUser) {
        InventoryBuilder inventory = new InventoryBuilder(4, bossUser.getPlayer().getName());

        ItemBuilder profile = new ItemBuilder(Material.SKULL_ITEM)
                .durability(3)
                .owner(bossUser.getPlayer().getName())
                .name("§a" + bossUser.getPlayer().getName())
                .lore("§7",
                        "§7Você matou um total de §a" + bossUser.getKilledBoss() + " §7boss.",
                        "§7");

        ItemBuilder ranking = new ItemBuilder(Material.ARMOR_STAND)
                .name("§aRanking §7(Atualizado a cada 5 minutos)")
                .lore("§7",
                        "§7Veja os 10 jogadores que mais mataram boss",
                        "§7"
                ).setConsumer(event -> RankingBossUserInventory.getInventory().open((Player) event.getWhoClicked()));

        inventory.setItem((3*9)-3, profile);
        inventory.setItem((3*9)-5, ranking);
        inventory.setCancel(true);
        return inventory;
    }
}
