package com.redestelar.boss.plugin.boss.storage.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.redestelar.boss.framework.util.storage.cache.NspCache;
import com.redestelar.boss.plugin.boss.data.Boss;
import org.bukkit.inventory.ItemStack;

/**
 * @author oNospher
 **/
public class BossCache extends NspCache<String, Boss> {

    public BossCache() {
        super(Caffeine
                .newBuilder()
                .build()
        );
    }

    public Boss fetch(String name) {
        Boss bossFetched = super.fetch(name);
        return (bossFetched == null ? this.fetch(boss -> boss.getFriendlyName().equalsIgnoreCase(name)) : bossFetched);
    }

    public Boss fetch(ItemStack itemStack) {
        return this.fetch(boss -> boss.getItem().isSimilar(itemStack));
    }
}
