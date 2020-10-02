package com.will.asgard.loki.model.concurrency.chapter4;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/**
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-10-01 7:28 下午
 * @Version 1.0
 */
@ThreadSafe
class PersonSet {

    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("mao");

        PersonSet personSet = new PersonSet();
        personSet.addPerson(person);
        boolean b = personSet.containsPerson(person);
        System.out.println(b);
    }
}
