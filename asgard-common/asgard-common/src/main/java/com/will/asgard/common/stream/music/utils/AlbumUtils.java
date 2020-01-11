package com.will.asgard.common.stream.music.utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;
import com.will.asgard.common.stream.music.model.Album;
import com.will.asgard.common.stream.music.model.Track;

/**
 * Created by WillMao on 19-2-27
 */
public class AlbumUtils {

	public static Set<String> findLongTracks(List<Album> albums) {
		Set<String> trackNames = Sets.newHashSet();
		for (Album album : albums) {
			for (Track track : album.getTracks()) {
				if (track.getLength() > 60) {
					trackNames.add(track.getName());
				}
			}
		}
		return trackNames;
	}

	public static Set<String> findLongTracksV2(List<Album> albums) {
		Set<String> trackNames = Sets.newHashSet();
		albums.stream().forEach(album -> {
			album.getTracks().forEach(track -> {
				if (track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			});
		});

		return trackNames;
	}

	public static Set<String> findLongTracksV3(List<Album> albums) {
		Set<String> trackNames = Sets.newHashSet();
		albums.stream().forEach(album -> {
			album.getTracks().stream().filter(track -> track.getLength() > 60).map(track -> track.getName())
					.forEach(name -> trackNames.add(name));
		});
		return trackNames;
	}

	public static Set<String> findLongTracksV4(List<Album> albums) {
		Set<String> trackNames = Sets.newHashSet();
		albums.stream().flatMap(album -> album.getTracks().stream()).filter(track -> track.getLength() > 60)
				.map(track -> track.getName()).forEach(name -> trackNames.add(name));
		return trackNames;
	}

	public static Set<String> findLongTracksV5(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTracks().stream()).filter(track -> track.getLength() > 60)
				.map(track -> track.getName()).collect(Collectors.toSet());
	}

}
