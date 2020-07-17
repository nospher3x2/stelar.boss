package com.redestelar.boss.plugin.boss.command;

import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.plugin.boss.data.Boss;
import com.redestelar.boss.plugin.sword.data.BossSword;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author oNospher
 **/
public class GiveBossCommand extends Command {

    public GiveBossCommand() {
        super("giveboss");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!sender.hasPermission("stelar.boss.sword.command")){
            sender.sendMessage("§cVocê não tem permissão para executar esse comando.");
            return true;
        }

        if(args.length != 2) {
            sender.sendMessage("§cUtilize /giveboss <player> <boss>");
            return true;
        }

        String prePlayer = args[0];
        String preBoss = args[1];

        Player player = Bukkit.getPlayerExact(prePlayer);
        if(player == null || !player.isOnline()) {
            sender.sendMessage("§cEsse jogador não está online.");
            return true;
        }

        Boss boss = BossProvider.Cache.BOSS_CACHE.fetch(preBoss);
        if(boss == null) {
            sender.sendMessage("§cEsse boss não existe.");
            return true;
        }

        player.getInventory().addItem(boss.getItem());
        return true;
    }
}
