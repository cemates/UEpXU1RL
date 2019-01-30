/**
 * @author Hüseyin Cem Ateş
 * */

/*
Create a frame window with the title "Simple editor" containing the textArea component (multi-line edit field). Provide the ability to set the type and size of the script as well as background and letter colors at the beginning of the program . 
 */

package Task9;

import groovy.swing.SwingBuilder

import java.awt.Color
import java.awt.Font
import java.awt.GraphicsEnvironment

import javax.swing.JColorChooser
import javax.swing.JFrame

def getAvailableFontNames(){
	GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames()
}

new SwingBuilder().edt{
	frame(title: "Simple editor", pack:true, visible:true, defaultCloseOperation:JFrame.EXIT_ON_CLOSE, locationRelativeTo:null){
		scrollPane(){
			area = textArea(rows:15, columns:15)
		}

		menuBar(){
			menu("options"){
				menuItem("font", actionPerformed:{e -> menuItemClicked(e)})

				menuItem("colors", actionPerformed:{e -> menuItemClicked(e)})
			}
		}
	}
}


def menuItemClicked(e){

	if(e.source.text == "font"){

		new SwingBuilder().edt {
			dialog(title:"font", visible:true, pack:true){
				panel(){

					vbox(){
						label(text:"choose font")
						def fontComboBox = comboBox(items:getAvailableFontNames())

						label(text:"choose font style")
						def styleComboBox = comboBox(items:["Plain", "Bold", "Italic"])

						label(text:"choose font size")
						def sizeTextField = textField()

						button(text:"Ok", actionPerformed: {a ->

							def style = styleComboBox.selectedIndex


							def selectedFont = new Font(fontComboBox.selectedItem, style, sizeTextField.text as int)

							area.font = selectedFont
							dispose()
						})
					}
				}
			}
		}
	} else if(e.source.text == "colors"){
		JColorChooser chooser = new JColorChooser();

		Color fontColor, backColor;

		while ((fontColor = chooser.showDialog(null, "Choose font color", null)) == null){}

		while((backColor = chooser.showDialog(null, "Choose background color", null)) == null){}


		area.background = backColor
		area.foreground = fontColor
	}
}
