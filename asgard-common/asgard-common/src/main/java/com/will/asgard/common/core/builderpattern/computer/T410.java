package com.will.asgard.common.core.builderpattern.computer;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by WillMao on 19-5-8
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class T410 extends Computer {
	//显卡
	private String graphicCard;

	public T410() {
		this.setType("Thinkpad T410");
	}

	@Override
	public String toString() {
		return "型号:\t" + this.getType() + "\nCPU\t" + this.getCpu()
				+ "\n内存\t" + this.getRam() + "\n硬盘\t" + this.getHardDisk()
				+ "\n显卡\t" + this.getGraphicCard() + "\n显示器\t" + this.getMonitor()
				+ "\n操作系统\t" + this.getOs();
	}
}
