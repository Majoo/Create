package se.chalmers.tda367.group25.resumate.experiment3;

import se.chalmers.tda367.group25.resumate.controllers.IOController;
import se.chalmers.tda367.group25.resumate.utils.Labels;

public class MeinExperimentum {

	public static void main(String[] args){
		IOController ioc = new IOController();
		ioc.chooseFunction(Labels.OPEN_DOC, null, null);
	}
}
