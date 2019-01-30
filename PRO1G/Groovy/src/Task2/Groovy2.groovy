/**
 * @author Hüseyin Cem Ateş
 * */

/*
Write the function List getInts (), which asks you to enter a series of integers in the input dialog and returns a list of entered numbers (as Integer objects). Do not allow for the entry of defective data (re-dialogue with the amendment). 

Help (possibly showing defective data in the dialogue to the amendment):
public static String showInputDialog (Component parentComponent, 
                                     Object message, 
                                     Object initialSelectionValue)
Shows a question-message dialog requesting input from the user and parented to parentComponent. The input value will be initialized to initialSelectionValue. The dialog is displayed on top of the Componentframe, and is usually positioned below the Component.

parameters:
parentComponent - the parent Componentfor the dialog (we'll give you null)
message - the Objectto display (message)
initialSelectionValue - the value used to initialize the input field (which is shown in the dialog text field)
 */

package Task2

import javax.swing.JOptionPane;


def List getInts(){


	def input;
	boolean isNotOk = true;
	while(isNotOk){
		input = JOptionPane.showInputDialog(null, "Provide number: ", input);

		if(!input)
			return null

		try{
			input = input.tokenize() as int[];
			isNotOk = false;
		}catch(NumberFormatException e){
			isNotOk = true;
		}
	}

	return input
}


println getInts()