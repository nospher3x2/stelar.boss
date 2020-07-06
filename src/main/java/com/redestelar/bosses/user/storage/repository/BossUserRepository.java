package com.redestelar.bosses.user.storage.repository;

import com.redestelar.bosses.BossProvider;
import com.redestelar.bosses.database.mysql.data.Parameters;
import com.redestelar.bosses.database.table.TableColumn;
import com.redestelar.bosses.database.table.TableRow;
import com.redestelar.bosses.user.data.BossUser;
import com.redestelar.bosses.util.storage.repository.NspRepository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author oNospher
 **/
public class BossUserRepository extends NspRepository<BossUser> {

    @Override
    public String getDatabaseName() {
        return "general";
    }

    @Override
    public String getTableName() {
        return "server_boss_user";
    }

    @Override
    public void createTable() {
        table.addColumn("unique_id", TableColumn.UUID);
        table.addColumn("bosses_killed", TableColumn.LONG);
        table.create();
    }

    @Override
    public BossUser insert(BossUser element) throws SQLException {
        table.insert(
                "unique_id",
                "bosses_killed"
        ).one(
                element.getUniqueId(),
                element.getKilledBoss()
        );

        return element;
    }

    @Override
    public <K extends String, V> void update(List<Parameters<K, V>> parameters, BossUser element) throws SQLException {
        K[] fields = (K[]) new String[parameters.size()];
        V[] values = (V[]) new Object[parameters.size()];

        parameters.forEach(kvParameters -> {
            Arrays.asList(fields).add(kvParameters.getKey());
            Arrays.asList(values).add(kvParameters.getValue());
        });

        Integer rowAffected = table.update(fields).values((V) values).where("unique_id", element.getUniqueId()).execute();
        if(rowAffected <= 0) this.insert(element);
    }

    @Override
    public <K, V> BossUser fetch(K key, V value) {
        TableRow tableRow = table.query().where((String) key, value).first();

        if(tableRow == null) {
            BossUser bossUser = BossUser.newUser((String) value);
            BossProvider.Cache.BOSS_USER_CACHE.insert(bossUser);
            return bossUser;
        }

        BossUser bossUser = BossUser.toUser(tableRow);
        BossProvider.Cache.BOSS_USER_CACHE.insert(bossUser);
        return bossUser;
    }
}
