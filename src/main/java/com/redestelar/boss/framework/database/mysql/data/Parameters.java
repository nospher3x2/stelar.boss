package com.redestelar.boss.framework.database.mysql.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author oNospher
 **/

@AllArgsConstructor
@Getter
public class Parameters<K, V> {

    private K key;
    private V value;

}