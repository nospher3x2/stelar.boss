package com.redestelar.bosses.boss.storage.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.redestelar.bosses.boss.data.Boss;
import com.redestelar.bosses.util.storage.cache.NspCaffeineCache;

/**
 * @author oNospher
 **/
public class BossCache extends NspCaffeineCache<String, Boss> {
    

    public BossCache() {
        super(Caffeine
                .newBuilder()
                .build()
        );
    }

}
