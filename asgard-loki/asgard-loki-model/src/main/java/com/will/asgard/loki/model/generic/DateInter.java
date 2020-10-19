package com.will.asgard.loki.model.generic;

import java.util.Date;

/**
 * @Description rt
 * @Author maolingwei
 * @Date 2020-10-19 9:46 下午
 * @Version 1.0
 */
class DateInter extends Pair<Date> {

    @Override
    public Date getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    public static void main(String[] args) {
        DateInter dateInter = new DateInter();
        dateInter.setValue(new Date());
//        dateInter.setValue(new Object());
    }
}
