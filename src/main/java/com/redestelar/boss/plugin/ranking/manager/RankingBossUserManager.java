package com.redestelar.boss.plugin.ranking.manager;

import com.google.common.collect.Sets;
import com.redestelar.boss.plugin.user.data.BossUser;

import java.util.Set;

/**
 * @author oNospher
 **/
public class RankingBossUserManager {

    public static Set<BossUser> RANKING = Sets.newHashSetWithExpectedSize(10);

    public RankingBossUserManager() {

    }

}
