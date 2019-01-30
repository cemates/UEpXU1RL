/**
 * @author Hüseyin Cem Ateş
 * */


/*
Five buttons with the inscriptions "Button 1" - "Button 5" show in the window using different distribution managers. 
The distribution is to be selected at the start of the application - e.g. in the input dialog. 
 */
 
package Task9;

import groovy.swing.SwingBuilder

import java.awt.BorderLayout
import java.awt.Button;
import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.LayoutManager
import java.awt.event.ActionEvent

import javax.swing.WindowConstants


def buttonNames = ["FlowLayout.RIGHT", "FlowLayout.LEFT", "FlowLayout.CENTER", "BorderLayout", "GridLayout 2x2"]


new SwingBuilder().edt{

	frame(title:"layouts", pack:true, visible:true, defaultCloseOperation:WindowConstants.EXIT_ON_CLOSE, layout:new GridLayout(2,2)){
		for(def b : buttonNames){
			button(text:b, actionPerformed: {e -> actionHandler(e)})
		}
	}
}

def actionHandler(ActionEvent e){
	def actionCmd = e.actionCommand;

	switch(actionCmd){
		case "FlowLayout.RIGHT":
			def layout = new FlowLayout(FlowLayout.RIGHT);
			makeFrame(layout, actionCmd)
			break;

		case "FlowLayout.LEFT":
			def layout = new FlowLayout(FlowLayout.LEFT);
			makeFrame(layout, actionCmd)
			break;

		case "FlowLayout.CENTER":
			def layout = new FlowLayout(FlowLayout.CENTER);
			makeFrame(layout, actionCmd)
			break;

		case "BorderLayout":
			def layout = new BorderLayout();
			new SwingBuilder().edt {
				frame(title:actionCmd, layout:layout, pack:true, visible:true){
					button(text:"b1")
					button(text:"b2", constraints:BorderLayout.WEST)
					button(text:"b3", constraints:BorderLayout.EAST)
					button(text:"b4", constraints:BorderLayout.NORTH)
					button(text:"b5", constraints:BorderLayout.SOUTH)
				}
			}
			break;

		case "GridLayout 2x2":
			def layout = new GridLayout(2, 2);
			makeFrame(layout, actionCmd)
			break;
	}
}


def makeFrame(LayoutManager layout, String name){
	new SwingBuilder().edt {
		frame(title:name, visible:true, pack:true, layout:layout){
			1.upto(5) {
				button(text:"b" + it)
			}
		}
	}
}


