package com.will.asgard.algo.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;
import com.will.asgard.common.util.GsonUtil;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2021-07-28 10:25 上午
 * @Version 1.0
 **/
public class GameUtil {

    private static boolean printStatus = false;
    private static final List<Mark> allMarks = new ArrayList<>();
    private static final Map<String, Mark> nameToMark = new HashMap<>();
    private static final Map<String, Hero> nameToHero = new HashMap<>();
    private static final Map<String, List<Hero>> markToHeroes = new HashMap<>();

    static {
        doInitAllMarks();
        doInitMarkToHeroes();
    }

    public static Mark getMarkByName(String name) {
        for (Mark mark : allMarks) {
            if (mark.getName().equals(name)) {
                return mark;
            }
        }
        throw new IllegalArgumentException("没有对应的印记");
    }

    public static Hero getHeroByName(String heroName) {
        if (nameToHero.containsKey(heroName)) {
            return nameToHero.get(heroName);
        } else {
            throw new IllegalArgumentException("没有对应的式神");
        }
    }

    public static List<Hero> getHeroesByMark(String markName) {
        if (markToHeroes.containsKey(markName)) {
            return markToHeroes.get(markName);
        } else {
            throw new IllegalArgumentException("没有对应的印记的式神");
        }
    }

    public static Set<String> getHeroesByMarks(String[] markNames) {
        if (markNames.length != 2) {
            throw new IllegalArgumentException("只支持2个印记的查询");
        }

        for (String markName : markNames) {
            if (!markToHeroes.containsKey(markName)) {
                throw new IllegalArgumentException("印记" + markName + "不存在");
            }
        }

        Set<Hero> heroes1 = new HashSet<>(markToHeroes.get(markNames[0]));
        Set<Hero> heroes2 = new HashSet<>(markToHeroes.get(markNames[1]));
        Set<Hero> heroes = new HashSet<>(heroes1);
        heroes.retainAll(heroes2);

        Set<String> ans = heroes.stream()
                .map(Hero::getName)
                .collect(Collectors.toSet());

        for (Hero hero : heroes1) {
            if (hero.isEqualMarks()) {
                ans.add(hero.getName() + ": " + hero.getMarks().get(0));
            }
        }
        for (Hero hero : heroes2) {
            if (hero.isEqualMarks()) {
                ans.add(hero.getName() + ": " + hero.getMarks().get(0));
            }
        }

        return ans;
    }

    public static String getMarksByHeroes(String[] heroesNames) {
        Map<String, Integer> markCount = new HashMap<>();
        for (String name : heroesNames) {
            if (!nameToHero.containsKey(name)) {
                throw new IllegalArgumentException("不存在式神" + name);
            }
            Hero hero = nameToHero.get(name);
            List<String> marks = hero.getMarks();
            for (String mark : marks) {
                int count = markCount.getOrDefault(mark, 0);
                markCount.put(mark, count + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> e : markCount.entrySet()) {
            if (e.getValue() >= 2) {
                int count = e.getValue();
                Mark mark = nameToMark.get(e.getKey());
                Map<Integer, String> map = mark.getPointToEffect();
                String effect = map.get(count);
                sb.append(e.getKey()).append(" 等级: ").append(count).append(": ").append(effect).append("\n");
            }
        }
        return sb.toString();
    }

    private static void doInitAllMarks() {
        Mark guizu = new Mark("鬼族");
        guizu.setBasicDesc("鬼系伤害提高，2级生效");
        Map<Integer, String> gz = new HashMap<>();
        gz.put(2, "鬼系伤害提高10%");
        gz.put(3, "伤害提高至30%");
        gz.put(4, "伤害提高至50%");
        gz.put(5, "任意单位死亡后将以灵魂姿态继续存在，获得「消耗鬼火减少」和「紧急治疗」的效果");
        guizu.setPointToEffect(gz);
        allMarks.add(guizu);
        nameToMark.put(Mark.guizu, guizu);

        Mark shuixi = new Mark("水系");
        shuixi.setBasicDesc("降低敌方全体暴击");
        Map<Integer, String> sx = new HashMap<>();
        sx.put(2, "降低敌方全体30%的暴击");
        sx.put(3, "降低敌方全体70%的暴击");
        sx.put(4, "敌方全体暴击降低为0");
        sx.put(5, "对敌方造成伤害值的20%将会治疗我方生命值最低的单位，获得「消耗鬼火减少」的效果");
        shuixi.setPointToEffect(sx);
        allMarks.add(shuixi);
        nameToMark.put(Mark.shuixi, shuixi);

        Mark jingdian = new Mark("静电");
        jingdian.setBasicDesc("任意单位行动一定回合后，对敌方造成伤害，2级生效");
        Map<Integer, String> jd = new HashMap<>();
        jd.put(2, "任意单位行动15次后，我方攻击最高单位对敌方全体造成其攻击100%的伤害");
        jd.put(3, "行动次数降低至10");
        jd.put(4, "行动次数降低至5");
        jd.put(5, "造成伤害提升至200%，获得「消耗鬼火减少」和「紧急治疗」的效果");
        jingdian.setPointToEffect(jd);
        allMarks.add(jingdian);
        nameToMark.put(Mark.jingdian, jingdian);

        Mark zhanshu = new Mark("战术");
        zhanshu.setBasicDesc("所有单位获得概率协战，2级生效");
        Map<Integer, String> zs = new HashMap<>();
        zs.put(2, "所有单位获得8%的概率协战");
        zs.put(3, "协战概率提升至20%");
        zs.put(4, "协战概率提升至30%");
        zs.put(5, "协战概率提升至40%，获得「紧急治疗」的效果");
        zhanshu.setPointToEffect(zs);
        allMarks.add(zhanshu);
        nameToMark.put(Mark.zhanshu, zhanshu);

        Mark xiongmeng = new Mark("凶猛");
        xiongmeng.setBasicDesc("对敌方造成伤害后，伤害增加，2级生效");
        Map<Integer, String> xm = new HashMap<>();
        xm.put(2, "对敌方造成伤害后，若未击败敌方，则增加10%的伤害，上限3层");
        xm.put(3, "增加伤害效果提升至20%");
        xm.put(4, "增加伤害效果提升至30%");
        xm.put(5, "增加伤害效果提升至60%，击败敌方后获得3点鬼火和一个全新的回合。获得「消耗鬼火减少」和「紧急治疗」的效果");
        xiongmeng.setPointToEffect(xm);
        allMarks.add(xiongmeng);
        nameToMark.put(Mark.xiongmeng, xiongmeng);

        Mark ruodian = new Mark("弱点");
        ruodian.setBasicDesc("敌方攻击最高的单位受到的伤害增加，2级生效");
        Map<Integer, String> rd = new HashMap<>();
        rd.put(2, "敌方攻击最高的单位收到的伤害增加50%");
        rd.put(3, "伤害增加效果提升至100%");
        rd.put(4, "伤害增加效果提升至300%");
        rd.put(5, "敌方攻击最高的单位行动前收到当前生命值50%的伤害，获得「消耗鬼火减少」和「紧急治疗」的效果");
        ruodian.setPointToEffect(rd);
        allMarks.add(ruodian);
        nameToMark.put(Mark.ruodian, ruodian);

        Mark fanji = new Mark("反击");
        fanji.setBasicDesc("收到伤害时，有概率进行反击，2级生效");
        Map<Integer, String> fj = new HashMap<>();
        fj.put(2, "受到伤害时，有10%的概率进行反击，和狰御魂分开结算");
        fj.put(3, "反击概率提升至25%");
        fj.put(4, "反击概率提升至35%");
        fj.put(5, "任意敌方单位行动后，我方随机1个单位对敌方进行普通攻击，获得「消耗鬼火减少」和「紧急治疗」的效果");
        fanji.setPointToEffect(fj);
        allMarks.add(fanji);
        nameToMark.put(Mark.fanji, fanji);

        Mark chuxing = new Mark("处刑");
        chuxing.setBasicDesc("攻击敌方生命值最低的单位将额外造成额外伤害，2级生效");
        Map<Integer, String> cx = new HashMap<>();
        cx.put(2, "攻击敌方生命值低于10%的单位将额外造成其生命上限300%的伤害");
        cx.put(3, "生命值提升至20%");
        cx.put(4, "生命值提升至30%");
        cx.put(5, "生命值提升至50%，获得「消耗鬼火减少」和「紧急治疗」的效果");
        chuxing.setPointToEffect(cx);
        allMarks.add(chuxing);
        nameToMark.put(Mark.chuxing, chuxing);

        Mark qiaojin = new Mark("巧劲");
        qiaojin.setBasicDesc("普通攻击伤害提高，2级生效");
        Map<Integer, String> qj = new HashMap<>();
        qj.put(2, "普通攻击伤害提高10%");
        qj.put(3, "普通攻击附带10%的真实伤害溅射");
        qj.put(4, "伤害提高至20%");
        qj.put(5, "普通攻击附带30%的真实伤害溅射，获得「紧急治疗」的效果");
        qiaojin.setPointToEffect(qj);
        allMarks.add(qiaojin);
        nameToMark.put(Mark.qiaojin, qiaojin);

        Mark tiantuan = new Mark("天团");
        tiantuan.setBasicDesc("呱太组合增强，2级生效");
        Map<Integer, String> tt = new HashMap<>();
        tt.put(2, "所有己方单位属性增加3%，呱太的伤害提高50%");
        tt.put(3, "全体单位鬼火消耗-2");
        tt.put(4, "当敌方有对应的SSR式神时，偷取其30%的全属性");
        tt.put(5, "召唤胧车作战！");
        tiantuan.setPointToEffect(tt);
        allMarks.add(tiantuan);
        nameToMark.put(Mark.tiantuan, tiantuan);
    }

    private static void doInitMarkToHeroes() {
        initGuizu();
        initShuixi();
        initJingdian();
        initZhanshu();
        initXiongmeng();
        initRuodian();
        initFanji();
        initChuxing();
        initQiaojin();
        initTiantuan();
        updateSpecialHeroMarks();
        verifySpecialHeroes();
    }

    private static void updateSpecialHeroMarks() {
        for (Map.Entry<String, Hero> e : nameToHero.entrySet()) {
            Hero hero = e.getValue();
            List<String> marks = hero.getMarks();
            if (marks.size() != 2) {
                String mark = marks.get(0);
                marks.add(mark);
                hero.setEqualMarks(true);
            }
        }
    }

    private static void verifySpecialHeroes() {
        for (Map.Entry<String, Hero> e : nameToHero.entrySet()) {
            Hero hero = e.getValue();
            if (hero.getMarks().size() != 2) {
                System.out.println(GsonUtil.toJson(hero));
                throw new IllegalStateException("有式神的印记数量不为2");
            }
        }
    }

    private static void initGuizu() {
        String[][] levelNames = new String[][]{
                {HeroName.yybr, HeroName.jtyzq, HeroName.ymbah}, // sp
                {HeroName.ym, HeroName.cmtz, HeroName.mlq, HeroName.gq}, // ssr
                {HeroName.thy, HeroName.gsb, HeroName.gsh, HeroName.mp, HeroName.gn, HeroName.ttgg, HeroName.pg,
                        HeroName.lxf, HeroName.br, HeroName.yecha, HeroName.htz, HeroName.btz, HeroName.yyl,
                        HeroName.xzsn, HeroName.xsw, HeroName.bmg, HeroName.rms, HeroName.yfmm}, // sr
                {HeroName.zftz, HeroName.eg, HeroName.sfg, HeroName.wgs, HeroName.wszl, HeroName.cszn, HeroName.qwcq,
                        HeroName.glh}, // r
                {}, // n
        };

        update(Mark.guizu, levelNames);
    }

    private static void initShuixi() {
        String[][] levelNames = new String[][]{
                {HeroName.lhjyj}, // sp
                {HeroName.yjs, HeroName.jnl}, // ssr
                {HeroName.thy, HeroName.hfz, HeroName.smm, HeroName.qj, HeroName.yecha, HeroName.jyj,
                        HeroName.sw, HeroName.bmg, HeroName.hr, HeroName.xmlqy, HeroName.zw}, // sr
                {HeroName.lyj, HeroName.ht, HeroName.yn, HeroName.dyxs, HeroName.jt, HeroName.sz, HeroName.gc}, // r
                {HeroName.hcg, HeroName.hnjg, HeroName.ymlg}, // n
        };

        update(Mark.shuixi, levelNames);
    }

    private static void initJingdian() {
        String[][] levelNames = new String[][]{
                {HeroName.sydtg, HeroName.dhsyzj, HeroName.xlhczz, HeroName.tjrxgq, HeroName.lmdyw, HeroName.cbxn},
                {HeroName.lmf, HeroName.xln, HeroName.yml, HeroName.hyj, HeroName.bah, HeroName.sf, HeroName.myl,
                        HeroName.yjs, HeroName.qianji},
                {HeroName.xn, HeroName.gn, HeroName.ttgg, HeroName.yh, HeroName.yqs, HeroName.ly, HeroName.yhy,
                        HeroName.xsw, HeroName.xun, HeroName.yi, HeroName.ax, HeroName.zw, HeroName.xxtz},
                {HeroName.jmm, HeroName.tn, HeroName.tongnv, HeroName.yn, HeroName.ttmm, HeroName.by, HeroName.ts,
                        HeroName.shantu, HeroName.hdj, HeroName.st, HeroName.mtjz},
                { HeroName.dtgg, HeroName.jtg, HeroName.ymg, HeroName.lmfg, HeroName.cmg, HeroName.ydjg,
                        HeroName.hyjg, HeroName.bahg},
        };
        update(Mark.jingdian, levelNames);
    }

    private static void initZhanshu() {
        String[][] levelNames = new String[][]{
                {HeroName.dhsyzj, HeroName.gwjttz, HeroName.lhjyj, HeroName.dxghn},
                {HeroName.hnj, HeroName.huang, HeroName.xtz, HeroName.yzj, HeroName.gd, HeroName.bzz, HeroName.bzh,
                        HeroName.dyw, HeroName.lycj, HeroName.ywj, HeroName.gtw, HeroName.zmmdz},
                {HeroName.xn, HeroName.qs, HeroName.ghn, HeroName.wnz, HeroName.yjzt, HeroName.xzsn,
                        HeroName.xun, HeroName.hj, HeroName.jcl},
                {HeroName.lm, HeroName.tn, HeroName.eg, HeroName.ytg, HeroName.cszn, HeroName.hdj, HeroName.tw},
                {HeroName.xlng}
        };
        update(Mark.zhanshu, levelNames);
    }

    private static void initXiongmeng() {
        String[][] levelNames = new String[][]{
                {HeroName.lycmtz, HeroName.cfyml, HeroName.cyydj, HeroName.jtyzq, HeroName.fsqxd, HeroName.clsf,
                        HeroName.ymbah},
                {HeroName.dtg, HeroName.hczz, HeroName.cmtz, HeroName.qxd, HeroName.ydj, HeroName.yml, HeroName.yzq,
                        HeroName.ssw, HeroName.jg, HeroName.bqds, HeroName.llyq},
                {HeroName.kls, HeroName.xxj, HeroName.bl, HeroName.qfz, HeroName.yyl, HeroName.yjzt, HeroName.zys,
                        HeroName.yjc, HeroName.yfmm, HeroName.fl},
                {HeroName.swh, HeroName.jmm, HeroName.wszl, HeroName.ttdd, HeroName.ttmm, HeroName.shouwu,
                        HeroName.cs, HeroName.mtjz},
                {HeroName.qxdg}
        };
        update(Mark.xiongmeng, levelNames);
    }

    private static void initRuodian() {
        String[][] levelNames = new String[][]{
                {HeroName.sydtg, HeroName.fsqxd, HeroName.fgqj},
                {HeroName.lmf, HeroName.xln, HeroName.mlq, HeroName.qyc, HeroName.ssw, HeroName.bqds, HeroName.lycj},
                {HeroName.fhh, HeroName.yqs, HeroName.qj, HeroName.ekn, HeroName.br, HeroName.sw, HeroName.zys,
                        HeroName.yi, HeroName.mzg, HeroName.rms, HeroName.yjc, HeroName.rls, HeroName.xj, HeroName.fl,
                        HeroName.xienv},
                {HeroName.swh, HeroName.zftz, HeroName.lyj, HeroName.sfg, HeroName.ts, HeroName.gh, HeroName.shouwu,
                        HeroName.jue, HeroName.glh, HeroName.xxzs, HeroName.cs},
                {HeroName.hg}
        };
        update(Mark.ruodian, levelNames);
    }

    private static void initFanji() {
        String[][] levelNames = new String[][]{
                {HeroName.dxghn},
                {HeroName.xtz, HeroName.nlls, HeroName.gd, HeroName.qyc, HeroName.hqyh, HeroName.ywj, HeroName.gtw,
                        HeroName.zmtzl},
                {HeroName.qs, HeroName.fhh, HeroName.xxj, HeroName.ghn, HeroName.yhy, HeroName.hbs, HeroName.jyj,
                        HeroName.jiu, HeroName.rhf, HeroName.ax, HeroName.hr, HeroName.xmlqy, HeroName.xxtz},
                {HeroName.lm, HeroName.ytg, HeroName.ttdd, HeroName.by, HeroName.dyxs, HeroName.jt, HeroName.yc,
                        HeroName.st, HeroName.jue, HeroName.tjx},
                {}
        };
        update(Mark.fanji, levelNames);
    }

    private static void initChuxing() {
        String[][] levelNames = new String[][]{
                {HeroName.cfyml, HeroName.cyydj, HeroName.yybr, HeroName.gwjttz, HeroName.lmdyw, HeroName.clsf},
                {HeroName.dtg, HeroName.hczz, HeroName.ym, HeroName.qxd, HeroName.ydj, HeroName.huang, HeroName.bah,
                        HeroName.sf, HeroName.yzq, HeroName.myl, HeroName.gq, HeroName.hqyh, HeroName.llyq,
                        HeroName.jnl, HeroName.qianji},
                {HeroName.gsb, HeroName.gsh, HeroName.gnhy, HeroName.pg, HeroName.yh, HeroName.smm, HeroName.ekn,
                        HeroName.lxf, HeroName.qfz, HeroName.rls, HeroName.xienv},
                {HeroName.wgs, HeroName.shantu, HeroName.qwcq},
                {}
        };
        update(Mark.chuxing, levelNames);
    }

    private static void initQiaojin() {
        String[][] levelNames = new String[][]{
                {HeroName.xlhczz},
                {HeroName.jttz, HeroName.hnj, HeroName.hyj, HeroName.nlls, HeroName.yzj, HeroName.bzz, HeroName.jg,
                        HeroName.bzh, HeroName.dyw, HeroName.zmtzl, HeroName.zmmdz},
                {HeroName.mp, HeroName.kls, HeroName.ly, HeroName.bl, HeroName.hbs, HeroName.jiu, HeroName.rhf,
                        HeroName.mzg, HeroName.hj, HeroName.jcl, HeroName.xj},
                {HeroName.tongnv, HeroName.gh, HeroName.yc, HeroName.tw, HeroName.sz, HeroName.xxzs, HeroName.tjx,
                        HeroName.gc},
                {}
        };
        update(Mark.qiaojin, levelNames);
    }

    private static void initTiantuan() {
        String[][] levelNames = new String[][]{
                {},
                {},
                {},
                {},
                {HeroName.dtgg, HeroName.jtg, HeroName.hcg, HeroName.ymg, HeroName.lmfg, HeroName.xlng, HeroName.cmg,
                        HeroName.qxdg, HeroName.ydjg, HeroName.ymlg, HeroName.hnjg, HeroName.hyjg, HeroName.hg,
                        HeroName.bahg, HeroName.yzqg}
        };
        update(Mark.tiantuan, levelNames);
    }

    private static void update(String mark, String[][] levelNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("<==").append(mark).append(" ==> ");

        for (int i = 0; i < levelNames.length; i++) {
            HeroLevel level = getLevelByIndex(i);
            sb.append("\n").append(level).append("：").append(levelNames[i].length).append("个");

            String[] names = levelNames[i];
            if (names.length != 0) {
                sb.append("\n");
            } else {
                continue;
            }

            int count = 0;
            for (String name : names) {
                count++;
                sb.append(name).append(" ");
                if (count % 4 == 0 && count != names.length && count != 0) {
                    sb.append("\n");
                }
                Hero hero = nameToHero.getOrDefault(name, new Hero(name, level));
                List<String> marks = hero.getMarks();
                if (marks == null) {
                    marks = new ArrayList<>();
                    hero.setMarks(marks);
                }
                marks.add(mark);

                // update hero
                nameToHero.put(name, hero);

                // update mark
                List<Hero> heroes = markToHeroes.getOrDefault(mark, new ArrayList<>());
                heroes.add(nameToHero.get(name));
                markToHeroes.put(mark, heroes);
            }
        }

        if (printStatus) {
            System.out.println(sb);
        }
    }

    private static HeroLevel getLevelByIndex(int index) {
        if (index == 0) {
            return HeroLevel.SP;
        } else if (index == 1) {
            return HeroLevel.SSR;
        } else if (index == 2) {
            return HeroLevel.SR;
        } else if (index == 3) {
            return HeroLevel.R;
        } else if (index == 4) {
            return HeroLevel.N;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
