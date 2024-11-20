package com.will.asgard.pattern.strategy.game.character;

import com.will.asgard.pattern.strategy.game.weapon.impl.SwordBehavior;

/**
 * @author willmao
 * @date 2022-11-12 15:47
 **/
public class King extends Character {
    public King() {
        setWeapon(new SwordBehavior());
    }
}
