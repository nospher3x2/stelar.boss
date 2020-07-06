package com.redestelar.bosses;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author oNospher
 **/
public class BossPlugin extends JavaPlugin {

    @Getter
    private static BossPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
    }
}
