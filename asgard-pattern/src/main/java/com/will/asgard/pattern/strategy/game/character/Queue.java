package com.will.asgard.pattern.strategy.game.character;

import com.will.asgard.pattern.strategy.game.weapon.impl.KnifeBehavior;

/**
 * @author willmao
 * @date 2022-11-12 15:50
 **/
public class Queue extends Character {

    public Queue() {
        setWeapon(new KnifeBehavior());
    }
}
