package com.redestelar.bosses.user.storage.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.redestelar.bosses.user.data.BossUser;
import com.redestelar.bosses.util.storage.cache.NspCaffeineCache;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author oNospher
 **/
public class BossUserCache extends NspCaffeineCache<UUID, BossUser> {

    public BossUserCache() {
        super(Caffeine
                .newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .build()
        );
    }

    public void insert(BossUser bossUser) {
        super.insert(bossUser.getUniqueId(), bossUser);
    }
}
