package com.will.asgard.thor.model.soundsystem.trackcounter;

import com.google.common.collect.Maps;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;

@Aspect
public class TrackCounter {
    private Map<Integer, Integer> trackCounts = Maps.newHashMap();

    @Pointcut("execution(* com.will.asgard.thor.model.soundsystem.cd.impl.BlankDisc.playTrack(int))" +
            "&& args(trackNumber)")
    public void trackPlayed(int trackNumber) {}

    @Before("trackPlayed(trackNumber)")
    public void countTrack(int trackNumber) {
        int count = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, count + 1);
    }

    public int getPlayCount(int trackNumber) {
        return trackCounts.getOrDefault(trackNumber, 0);
    }
}
