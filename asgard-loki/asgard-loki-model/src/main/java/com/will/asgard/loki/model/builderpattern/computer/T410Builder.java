package com.will.asgard.loki.model.builderpattern.computer;

/**
 * Created by WillMao on 19-5-8
 */
public class T410Builder implements ComputerBuilder {
	private T410 computer = new T410();

	@Override
	public void buildCpu() {
		computer.setCpu("i5-450");
	}

	@Override
	public void buildRam() {
		computer.setRam("8G 1333MHz");
	}

	@Override
	public void buildHardDisk() {
		computer.setHardDisk("500G 7200转");
	}

	@Override
	public void buildGraphicCard() {
		computer.setGraphicCard("Nvidia");
	}

	@Override
	public void buildMonitor() {
		computer.setMonitor("14 inch 1280*800");
	}

	@Override
	public void buildOs() {
		computer.setOs("Windows 7");
	}

	@Override
	public Computer getResult() {
		return computer;
	}
}
