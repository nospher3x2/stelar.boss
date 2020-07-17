package com.redestelar.boss.plugin.user.data;

import com.google.common.collect.Sets;
import com.redestelar.boss.framework.database.table.TableRow;
import com.redestelar.boss.plugin.boss.data.Boss;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

/**
 * @author oNospher
 **/
@AllArgsConstructor
@Getter @Setter
public class BossUser {

    private final UUID uniqueId;
    private long killedBoss;
    private Set<Boss> bossesSpawned;

    public Player getPlayer() {
        return Bukkit.getPlayer(this.uniqueId);
    }

    public static BossUser newUser(String uniqueId) {
        return new BossUser(
                UUID.fromString(uniqueId),
                0,
                Sets.newHashSet()
        );
    }

    public static BossUser toUser(TableRow tableRow) {
        return new BossUser(
                UUID.fromString(tableRow.getString("unique_id")),
                tableRow.getLong("killed_boss"),
                Sets.newHashSet()
        );
    }

}
