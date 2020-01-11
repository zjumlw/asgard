package com.will.asgard.common.core.builderpattern.computer;

/**
 * Created by WillMao on 19-5-8
 */
public class X201 extends Computer {
	public X201() {
		this.setType("Thinkpad X201");
	}

	@Override
	public String toString() {
		return "型号:\t" + this.getType() + "\nCPU\t" + this.getCpu()
				+ "\n内存\t" + this.getRam() + "\n硬盘\t" + this.getHardDisk()
				+ "\n显示器\t" + this.getMonitor() + "\n操作系统\t" + this.getOs();
	}
}
