/**
 * @author Hüseyin Cem Ateş
 * */

/*
Write a script - image viewer from the given directory. 
On the label in the window, images from the catalog selected after starting the program should be shown. 
At the beginning, the first image is shown, pressing the "Next" button shows the next. 

Help: 
a) browse catalogs and get 
file names - we know, b) imageIcon method (file_name) returns icon = image from file (types: png and jpg) 
b) setIcon method allows to set the icon (image) on the label label
 */
 
package Task9;

import groovy.swing.SwingBuilder

import java.awt.BorderLayout
import java.awt.Dimension

import javax.swing.JOptionPane
import javax.swing.WindowConstants


def path = JOptionPane.showInputDialog(null, "Path to dir:", /C:\Users\Domino\eclipse workspaces\groovy_workspace\Groovy\photos/)

if(!path)
	return


def photos = []
def lastPhoto = 1

new File(path).eachFileMatch(~/[^\s]+.[jpeg|jpg|png]/){photos << it}


new SwingBuilder().edt{
	fr = frame(title:"photos", visible:true, defaultCloseOperation:WindowConstants.EXIT_ON_CLOSE , size:new Dimension(600, 600)){
		photoLabel = label(icon:imageIcon(photos[0].path))

		button(text:"next", constraints:BorderLayout.SOUTH, actionPerformed:{e ->
			if(lastPhoto == photos.size){
				lastPhoto = 0
			}

			def photo = imageIcon(photos[lastPhoto++].path)

			photoLabel.size = new Dimension(photo.getImage().getWidth(), photo.getImage().getHeight());

			photoLabel.icon = photo
		})
	}
}



