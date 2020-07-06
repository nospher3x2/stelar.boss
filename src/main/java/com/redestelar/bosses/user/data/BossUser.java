package com.redestelar.bosses.user.data;

import com.redestelar.bosses.database.table.TableRow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author oNospher
 **/
@AllArgsConstructor
@Getter @Setter
public class BossUser {

    private final UUID uniqueId;
    private long killedBoss;

    public static BossUser newUser(String uniqueId) {
        return new BossUser(
                UUID.fromString(uniqueId),
                0
        );
    }

    public static BossUser toUser(TableRow tableRow) {
        return new BossUser(
                UUID.fromString(tableRow.getString("unique_id")),
                tableRow.getLong("killed_boss")
        );
    }

}
