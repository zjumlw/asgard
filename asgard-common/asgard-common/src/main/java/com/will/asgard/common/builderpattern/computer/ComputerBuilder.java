package com.will.asgard.common.builderpattern.computer;

/**
 * Created by WillMao on 19-5-8
 */
public interface ComputerBuilder {
	//建造CPU
	void buildCpu();
	//建造内存
	void buildRam();
	//建造硬盘
	void buildHardDisk();
	//建造显卡
	void buildGraphicCard();
	//建造显示器
	void buildMonitor();
	//建造操作系统
	void buildOs();

	//得到建造好的计算机
	Computer getResult();
}
