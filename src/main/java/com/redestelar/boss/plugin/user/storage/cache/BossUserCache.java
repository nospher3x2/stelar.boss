package com.redestelar.boss.plugin.user.storage.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.plugin.user.data.BossUser;
import com.redestelar.boss.framework.util.storage.cache.NspCache;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author oNospher
 **/
public class BossUserCache extends NspCache<UUID, BossUser> {

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

    public BossUser fetch(UUID uniqueId) {
        BossUser bossUser = super.fetch(bossUser1 -> bossUser1.getUniqueId().equals(uniqueId));
        return (bossUser == null ? BossProvider.Repository.BOSS_USER_REPOSITORY.fetch("unique_id", uniqueId) : bossUser);
    }
}
