package com.redestelar.boss.plugin.boss.listeners;

import com.redestelar.boss.plugin.boss.data.Boss;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * @author oNospher
 **/
public class PlayerDamageBossListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if(!(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity)) return;
        LivingEntity entity = (LivingEntity) event.getEntity();
        if(entity.hasMetadata("boss")) return;
        Boss boss = (Boss) entity.getMetadata("boss").get(0);
        
    }
}
