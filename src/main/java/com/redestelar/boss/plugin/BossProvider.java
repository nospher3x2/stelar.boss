package com.redestelar.boss.plugin;

import com.redestelar.boss.plugin.sword.storage.cache.BossSwordCache;
import com.redestelar.boss.plugin.user.storage.cache.BossUserCache;
import com.redestelar.boss.plugin.boss.storage.cache.BossCache;
import com.redestelar.boss.plugin.user.storage.repository.BossUserRepository;

/**
 * @author oNospher
 **/
public class BossProvider {

    public static class Repository {
        public static final BossUserRepository BOSS_USER_REPOSITORY = new BossUserRepository();
    }

    public static class Cache {
        public static final BossCache BOSS_CACHE = new BossCache();
        public static final BossUserCache BOSS_USER_CACHE = new BossUserCache();
        public static final BossSwordCache BOSS_SWORD_CACHE = new BossSwordCache();
    }

}
