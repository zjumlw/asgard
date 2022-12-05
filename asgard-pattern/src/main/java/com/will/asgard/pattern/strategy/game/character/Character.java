package com.will.asgard.pattern.strategy.game.character;

import com.will.asgard.pattern.strategy.game.weapon.WeaponBehavior;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author willmao
 * @date 2022-11-12 15:45
 **/
@Data
@NoArgsConstructor
public abstract class Character {
    private WeaponBehavior weapon;

    public void fight() {
        weapon.useWeapon();
    }
}
