package com.will.asgard.algo.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.will.asgard.common.util.GsonUtil;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-30 10:52 下午
 * @Version 1.0
 **/
public class GameUtilTest {

    @Test
    public void testGetMarkByName() {
        Mark mark = GameUtil.getMarkByName(Mark.xiongmeng);
        System.out.println(mark);
    }

    @Test
    public void testGetHeroByName() {
        Hero hero = GameUtil.getHeroByName(HeroName.tjrxgq);
        System.out.println(GsonUtil.toJson(hero));
    }

    @Test
    public void testGetHeroesByMark() {
        List<Hero> heroes = GameUtil.getHeroesByMark(Mark.tiantuan);

        System.out.println(heroes.size());
        Map<HeroLevel, List<String>> levelToHeroes = new LinkedHashMap<>();
        for (Hero hero : heroes) {
            HeroLevel level = hero.getLevel();
            List<String> names = levelToHeroes.getOrDefault(level, new ArrayList<>());
            String name = hero.getName();
            if (hero.isEqualMarks()) {
                name = name + "(2)";
            }
            names.add(name);

            levelToHeroes.put(level, names);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<HeroLevel, List<String>> e : levelToHeroes.entrySet()) {
            HeroLevel level = e.getKey();
            sb.append(level).append(": ");
            int count = 0;
            List<String> l = e.getValue();
            for (String name : l) {
                sb.append(name).append(" ");
                count++;
                if (count % 20 == 0) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    @Test
    public void testGetHeroesByMarks() {
        String[] marks = new String[]{Mark.shuixi, Mark.jingdian};
        Set<String> heroes = GameUtil.getHeroesByMarks(marks);
        System.out.println(heroes.size());
        for (String hero : heroes) {
            System.out.println(hero);
        }
    }

    @Test
    public void testGetMarksByHeroes() {
        String[] heroes = new String[]{HeroName.ht, HeroName.yn, HeroName.yjs, HeroName.tjrxgq, HeroName.zw};
        String marks = GameUtil.getMarksByHeroes(heroes);
        System.out.println(marks);
    }
}