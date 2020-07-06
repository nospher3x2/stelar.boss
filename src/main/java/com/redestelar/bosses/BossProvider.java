package com.redestelar.bosses;

import com.redestelar.bosses.user.storage.cache.BossUserCache;
import com.redestelar.bosses.user.storage.repository.BossUserRepository;

/**
 * @author oNospher
 **/
public class BossProvider {

    public static class Repository {
        public static final BossUserRepository BOSS_USER_REPOSITORY = new BossUserRepository();
    }

    public static class Cache {
        public static final BossUserCache BOSS_USER_CACHE = new BossUserCache();
    }

}
