package com.will.asgard.loki.model.jvm.jmm;

/**
 * @ClassName MySharedObject
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-05-03 02:24
 * @Version 1.0
 **/
public class MySharedObject {
	public static final MySharedObject sharedInstance = new MySharedObject();

	public Integer object2 = new Integer(22);
	public Integer object4 = new Integer(44);

	public long member1 = 12345;
	public long member2 = 67890;
}
