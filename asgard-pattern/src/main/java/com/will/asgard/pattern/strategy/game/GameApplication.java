package com.will.asgard.pattern.strategy.game;

import com.will.asgard.pattern.strategy.game.character.Character;
import com.will.asgard.pattern.strategy.game.character.King;
import com.will.asgard.pattern.strategy.game.character.Queue;

/**
 * @author willmao
 * @date 2022-11-12 15:54
 **/
public class GameApplication {

    public static void main(String[] args) {
        Character king = new King();
        king.fight();

        Character queue = new Queue();
        queue.fight();
    }
}
