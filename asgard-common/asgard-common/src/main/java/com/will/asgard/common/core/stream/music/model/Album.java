package com.will.asgard.common.core.stream.music.model;

import java.util.List;

import lombok.Data;

/**
 * Created by WillMao on 19-2-27
 */
@Data
public class Album {
	private String name;
	private List<Track> tracks;
	private List<Artist> musicians;
}
