package com.redestelar.boss.plugin.sword.command;

import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.plugin.sword.data.BossSword;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author oNospher
 **/
public class GiveSwordCommand extends Command {

    public GiveSwordCommand() {
        super("givesword");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!sender.hasPermission("stelar.boss.sword.command")){
            sender.sendMessage("§cVocê não tem permissão para executar esse comando.");
            return true;
        }

        if(args.length != 2) {
            sender.sendMessage("§cUtilize /givesword <player> <sword>");
            return true;
        }

        String prePlayer = args[0];
        String preSword = args[1];

        Player player = Bukkit.getPlayerExact(prePlayer);
        if(player == null || !player.isOnline()) {
            sender.sendMessage("§cEsse jogador não está online.");
            return true;
        }

        BossSword bossSword = BossProvider.Cache.BOSS_SWORD_CACHE.fetch(preSword);
        if(bossSword == null) {
            sender.sendMessage("§cEsse espada não existe.");
            return true;
        }

        player.getInventory().addItem(bossSword.getItem());
        return true;
    }
}
