package com.will.asgard.loki.model.design.command.impl;

import com.will.asgard.loki.model.design.command.Command;
import com.will.asgard.loki.model.design.command.Light;

/**
 * @ClassName LightOnCommand
 * @Description TODO
 * @Author maolingwei
 * @Date 2020-04-27 03:28
 * @Version 1.0
 **/
public class LightOnCommand implements Command {
	private Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();

	}
}
