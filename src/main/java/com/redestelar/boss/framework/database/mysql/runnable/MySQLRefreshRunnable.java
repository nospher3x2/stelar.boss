package com.redestelar.boss.framework.database.mysql.runnable;

import com.redestelar.boss.framework.database.mysql.manager.MySQLManager;

/**
 * @author oNospher
 **/
public class MySQLRefreshRunnable implements Runnable {

    @Override
    public void run() {
        new MySQLManager().refresh();
    }
}
