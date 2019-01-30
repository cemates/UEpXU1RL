/**
 * @author Hüseyin Cem Ateş
 * */

/*
The button placed in the window changes the colors of your background as a result of clicks. Determine any color sequence, after it has been exhausted, start with the first 
 */

package Task9;

import groovy.swing.SwingBuilder

import java.awt.Color

import javax.swing.JFrame

def colors = [
	Color.red,
	Color.CYAN,
	Color.yellow,
	Color.blue,
	Color.orange
]
def lastColor = 0;

new SwingBuilder().edt{
	frame(title:"colorChanger", visible:true, pack:true, defaultCloseOperation:JFrame.EXIT_ON_CLOSE, locationRelativeTo:null){
		button(text:"Click Me!", actionPerformed:{e ->
			if(lastColor == colors.size){
				lastColor = 0
			}
			e.source.background = colors[lastColor++];
		})
	}
}
