package com.will.asgard.common.util;

import com.google.common.base.Strings;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class GsonUtil {

	private GsonUtil() {
		throw new IllegalStateException();
	}

    public static final Type TOKEN_LIST_INT = new TypeToken<List<Integer>>() { }.getType();
    public static final Type TOKEN_LIST_LONG = new TypeToken<List<Long>>() { }.getType();
    public static final Type TOKEN_LIST_STRING = new TypeToken<List<String>>() { }.getType();
    private static final ThreadLocal<Gson> THREAD_LOCAL_GSON = ThreadLocal.withInitial(Gson::new);

	public static String toJson(Object obj) {
		return obj == null ? null : gson().toJson(obj);
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		return fromJson(json, (Type) clazz);
	}

	public static <T> T fromJson(String json, Type typeOfT){
		return gson().fromJson(json, typeOfT);
	}

	public static Gson gson() {
		return THREAD_LOCAL_GSON.get();
	}

	public static Gson newGson() {
		return new GsonBuilder()
				.registerTypeAdapter(AtomicInteger.class, ADAPTER_ATOMIC_INTEGER)
				.registerTypeAdapter(AtomicLong.class, ADAPTER_ATOMIC_LONG)
				.create();
	}

	private static final TypeAdapter<AtomicInteger> ADAPTER_ATOMIC_INTEGER = new TypeAdapter<AtomicInteger>() {
		@Override public AtomicInteger read(JsonReader in) throws IOException {
			try {
				return new AtomicInteger(in.nextInt());
			} catch (IllegalStateException e) {
				//try to explain as origin object
				in.beginObject();
				in.nextName();
				in.peek();
				int value = in.nextInt();
				in.endObject();
				return new AtomicInteger(value);
			}
		}
		@Override public void write(JsonWriter out, AtomicInteger value) throws IOException {
			out.value(value.get());
		}
	}.nullSafe();

	private static final TypeAdapter<AtomicLong> ADAPTER_ATOMIC_LONG = new TypeAdapter<AtomicLong>() {
		@Override public AtomicLong read(JsonReader in) throws IOException {
			try {
				return new AtomicLong(in.nextInt());
			} catch (IllegalStateException e) {
				//try to explain as origin object
				in.beginObject();
				in.nextName();
				in.peek();
				long value = in.nextLong();
				in.endObject();
				return new AtomicLong(value);
			}
		}
		@Override public void write(JsonWriter out, AtomicLong value) throws IOException {
			out.value(value.get());
		}
	}.nullSafe();

	public static List<Integer> getIntegerListFromJson(String json) {
		if (Strings.isNullOrEmpty(json)) {
			return Collections.emptyList();
		}

		return fromJson(json, TOKEN_LIST_INT);
	}

	public static List<Long> getLongListFromJson(String json) {
		if (Strings.isNullOrEmpty(json)) {
			return Collections.emptyList();
		}

		return fromJson(json, TOKEN_LIST_LONG);
	}

	public static List<String> getStringListFromJson(String json) {
		if (Strings.isNullOrEmpty(json)) {
			return Collections.emptyList();
		}

		return fromJson(json, TOKEN_LIST_STRING);
	}
}
