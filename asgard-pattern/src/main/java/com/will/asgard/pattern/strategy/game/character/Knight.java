package com.will.asgard.pattern.strategy.game.character;

import com.will.asgard.pattern.strategy.game.weapon.impl.BowAndArrowBehavior;

/**
 * @author willmao
 * @date 2022-11-12 15:53
 **/
public class Knight extends Character {
    public Knight() {
        setWeapon(new BowAndArrowBehavior());
    }
}
