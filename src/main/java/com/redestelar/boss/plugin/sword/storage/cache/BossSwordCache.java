package com.redestelar.boss.plugin.sword.storage.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.redestelar.boss.framework.util.storage.cache.NspCache;
import com.redestelar.boss.plugin.sword.data.BossSword;
import org.bukkit.inventory.ItemStack;

/**
 * @author oNospher
 **/
public class BossSwordCache extends NspCache<String, BossSword> {

    public BossSwordCache() {
        super(Caffeine
                .newBuilder()
                .build()
        );
    }

    public BossSword fetch(ItemStack itemStack) {
        return super.fetch(bossSword -> bossSword.getItem().equals(itemStack));
    }

}
