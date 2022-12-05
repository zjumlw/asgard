package com.will.asgard.pattern.strategy.game.character;

import com.will.asgard.pattern.strategy.game.weapon.impl.AxeBehavior;

/**
 * @author willmao
 * @date 2022-11-12 15:53
 **/
public class Troll extends Character {
    public Troll() {
        setWeapon(new AxeBehavior());
    }
}
