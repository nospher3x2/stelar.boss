package com.redestelar.boss.plugin.user.storage.repository;

import com.redestelar.boss.plugin.BossProvider;
import com.redestelar.boss.framework.database.mysql.data.Parameters;
import com.redestelar.boss.plugin.user.data.BossUser;
import com.redestelar.boss.framework.util.storage.repository.NspRepository;
import com.redestelar.boss.framework.database.table.TableColumn;
import com.redestelar.boss.framework.database.table.TableRow;

import java.sql.SQLException;
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
        Parameters<K[], V[]> kvParameters = super.getParameters(parameters);

        Integer rowAffected = table.update(kvParameters.getKey()).values((V) kvParameters.getValue())
                .where("unique_id", element.getUniqueId())
                .execute();

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
