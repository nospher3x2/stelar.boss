package com.redestelar.boss.plugin.ranking.inventory;

import com.redestelar.boss.framework.util.inventory.InventoryBuilder;
import com.redestelar.boss.framework.util.inventory.item.ItemBuilder;
import com.redestelar.boss.plugin.ranking.manager.RankingBossUserManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author oNospher
 **/
public class RankingBossUserInventory {

    public static InventoryBuilder getInventory() {
        InventoryBuilder inventory= new InventoryBuilder(5, "Ranking (Boss)");

        AtomicInteger i = new AtomicInteger();
        RankingBossUserManager.RANKING.forEach(bossUser -> {
            Player player = bossUser.getPlayer();
            i.getAndIncrement();

            ItemBuilder item = new ItemBuilder(Material.SKULL_ITEM)
                    .name("§7(" + i + ") §a" + player.getName())
                    .owner(player.getName())
                    .lore("§7",
                            "§7O jogador §a" + player.getName() +" §7 matou um total de §c" + bossUser.getKilledBoss() + "§7 bosses.",
                            "§7"
                    );

            inventory.addItem(item);
        });

        inventory.setDesign("XXXXXXXXX", "XXOXOOOXX", "XXOOOOOOXX", "XXXXXXXXX", "XXXXXXXXX");
        inventory.setCancel(true);
        return inventory;
    }
}
