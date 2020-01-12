package com.will.asgard.loki.model.builderpattern.computer;

/**
 * Created by WillMao on 19-5-8
 */
public class X201Builder implements ComputerBuilder {
	private X201 computer = new X201();

	@Override
	public void buildCpu() {
		computer.setCpu("i3-350");
	}

	@Override
	public void buildRam() {
		computer.setRam("4G 1333M");
	}

	@Override
	public void buildHardDisk() {
		computer.setHardDisk("250G 5400转");
	}

	@Override
	public void buildGraphicCard() {
		// do nothing
	}

	@Override
	public void buildMonitor() {
		computer.setMonitor("12 inch 1280*800");
	}

	@Override
	public void buildOs() {
		computer.setOs("Windows7 Home版");
	}

	@Override
	public Computer getResult() {
		return computer;
	}
}
