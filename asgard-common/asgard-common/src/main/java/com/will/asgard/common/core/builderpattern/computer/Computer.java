package com.will.asgard.common.core.builderpattern.computer;

import lombok.Data;

/**
 * Created by WillMao on 19-5-8
 */
@Data
class Computer {
	//型号
	private String type;
	//CPU
	private String cpu;
	//内存
	private String ram;
	//硬盘
	private String hardDisk;
	//显示器
	private String monitor;
	//操作系统
	private String os;
}
