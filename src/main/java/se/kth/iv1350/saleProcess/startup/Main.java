package se.kth.iv1350.saleProcess.startup;


import se.kth.iv1350.saleProcess.Integration.Printer;
import se.kth.iv1350.saleProcess.Integration.SystemCreator;
import se.kth.iv1350.saleProcess.controller.Controller;
import se.kth.iv1350.saleProcess.view.View;

/**
 * Starts the application. Has the main method which initiates the run.
 */
public class Main {

	/**
	 * The method to start the application
	 *
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		SystemCreator creator = new SystemCreator();
		Printer printer = new Printer();
		Controller contr = new Controller(creator, printer);
		new View(contr).sampleExecution();
	}

}
