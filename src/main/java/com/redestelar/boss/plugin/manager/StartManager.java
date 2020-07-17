package com.redestelar.boss.plugin.manager;

import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.framework.database.mysql.manager.MySQLManager;
import com.redestelar.boss.framework.database.mysql.runnable.MySQLRefreshRunnable;
import com.redestelar.boss.framework.util.ClassGetter;
import com.redestelar.boss.framework.util.inventory.InventoryBuilder;
import com.redestelar.boss.plugin.BossPlugin;
import com.redestelar.boss.plugin.boss.storage.loader.BossLoader;
import com.redestelar.boss.plugin.sword.storage.loader.BossSwordLoader;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.event.Listener;

/**
 * @author oNospher
 **/
public class StartManager {

    public StartManager() {
        new ListenerManager();
        new MySQLManager();
        new CommandManager();
        new LoaderManager();
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(BossPlugin.getInstance(), new MySQLRefreshRunnable(), 0L, 20L * 60);
        BossProvider.Repository.BOSS_USER_REPOSITORY.createTable();
    }

}

class LoaderManager {
    public LoaderManager() {
        new BossLoader();
        new BossSwordLoader();
    }
}


class ListenerManager {
    /**
     * Registering all listeners on call constructor of this class
     */
    ListenerManager() {
        ClassGetter.getClassesForPackage(BossPlugin.getInstance(), "com.redestelar").forEach(clazz -> {
            if (Listener.class.isAssignableFrom(clazz) && !clazz.equals(InventoryBuilder.class)) {
                try {
                    Listener listener = (Listener) clazz.newInstance();
                    Bukkit.getPluginManager().registerEvents(listener, BossPlugin.getInstance());
                } catch (InstantiationException | IllegalAccessException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}

class CommandManager {
    /**
     * Registering all commands on call constructor of this class
     */
    CommandManager() {
        ClassGetter.getClassesForPackage(BossPlugin.getInstance(), "com.redestelar").forEach(clazz -> {
            if (Command.class.isAssignableFrom(clazz) && !clazz.equals(Command.class)) {
                try {
                    Command command = (Command) clazz.newInstance();

                    ((CraftServer) Bukkit.getServer()).getCommandMap().register(command.getName(), command);
                } catch (InstantiationException | IllegalAccessException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}

