package com.steven.test;

import com.frwk.core.myConfig;

public class stevnConfig extends myConfig {

	@Override
	public void setInitParam() {

		System.out.println("setInitParam from stevnConfig");
		
	}

	@Override
	public void setRoute() {
		System.out.println("setRoute from stevnConfig");
		routes.put("/house", HouseController.class);
		routes.put("/house2", House2Controller.class);
	}

}
