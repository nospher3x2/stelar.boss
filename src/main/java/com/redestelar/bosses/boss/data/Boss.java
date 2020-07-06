package com.redestelar.bosses.boss.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author oNospher
 **/
@RequiredArgsConstructor
@Getter
public class Boss {

    private final String name;
    private final String friendlyName;
    private final Double health;

    public void summon() {

    }


}
