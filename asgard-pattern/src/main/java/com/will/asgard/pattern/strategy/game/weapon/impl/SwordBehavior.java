package com.will.asgard.pattern.strategy.game.weapon.impl;

import com.will.asgard.pattern.strategy.game.weapon.WeaponBehavior;

/**
 * @author willmao
 * @date 2022-11-12 15:47
 **/
public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("I'm using sword.");
    }
}
