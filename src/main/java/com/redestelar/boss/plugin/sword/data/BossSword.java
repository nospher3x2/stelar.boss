package com.redestelar.boss.plugin.sword.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.inventory.ItemStack;

/**
 * @author oNospher
 **/
@RequiredArgsConstructor
@Getter
public class BossSword {

    private final ItemStack item;
    private final Double damage;

}
