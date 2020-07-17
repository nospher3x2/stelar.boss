package com.redestelar.boss.plugin.boss.storage.loader;

import com.google.common.collect.Maps;
import com.kirelcodes.miniaturepets.mob.MobContainer;
import lombok.Getter;

import java.util.Map;

/**
 * @author oNospher
 **/
public class BossLoader {

    @Getter
    private static final Map<String, MobContainer> containers = Maps.newHashMap();

    public BossLoader() {

    }

    public static MobContainer get(String name) {
        return containers.get(name);
    }
}
