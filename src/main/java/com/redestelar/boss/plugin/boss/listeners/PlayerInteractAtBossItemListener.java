package com.redestelar.boss.plugin.boss.listeners;

import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.plugin.boss.data.Boss;
import com.redestelar.boss.plugin.boss.storage.loader.BossLoader;
import com.redestelar.boss.plugin.user.data.BossUser;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author oNospher
 **/
public class PlayerInteractAtBossItemListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.isCancelled()) return;
        Player player = event.getPlayer();
        ItemStack item = player.getItemInHand();
        if(item == null || item.getType() == Material.AIR) return;
        Boss boss = BossProvider.Cache.BOSS_CACHE.fetch(item);
        if(boss == null) return;
        if(!player.getWorld().getName().equalsIgnoreCase("plotworld")) return;

        boss.summon(player.getLocation(), BossLoader.get(boss.getName()));
    }
}
