/**
 * @author Hüseyin Cem Ateş
 * */
/*
A sequence of numbers is entered in the dialog. Create a list with their double values. Provide the shortest possible code for this task. 

Help: apply spread-dot and collect. 
 */
package Task8;

import javax.swing.JOptionPane


def input = JOptionPane.showInputDialog("Number list:")
def nums = input.tokenize()*.toInteger()*.multiply(2);

println nums