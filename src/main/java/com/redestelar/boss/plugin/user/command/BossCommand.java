package com.redestelar.boss.plugin.user.command;

import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.plugin.user.data.BossUser;
import com.redestelar.boss.plugin.user.inventory.BossUserProfileInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author oNospher
 **/
public class BossCommand extends Command {

    public BossCommand() {
        super("boss");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        BossUser bossUser = BossProvider.Cache.BOSS_USER_CACHE.fetch(player.getUniqueId());
        BossUserProfileInventory.getInventory(bossUser).open(player);
        return true;
    }
}
