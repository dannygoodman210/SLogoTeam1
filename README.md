SLogoTeam1
==========

Members & Mentor
----------------
Francesco Agosti (fra5@duke.edu)  
Danny Goodman (pdg7@duke.edu)  
Challen Herzberg-Brovold (crh39@duke.edu)  
David Le (dl103@duke.edu)  
Joe Ryu (er40@duke.edu)  
Mentors: Andrew Patterson (arp25@duke.edu)  
  
**Date Started** February 15, 2013  **Date Ended** March 26, 2013

Estimated Time
--------------
* Francesco Agosti: 40 hours
	* References: 
		* http://www.mkyong.com/java/how-to-read-file-in-java-fileinputstream/
		* http://tutorials.jenkov.com/java-reflection/index.html
* Danny Goodman: 50 hours
		* docs.oracle.com/

Required Data
-------------
The project requires: 
* a Language.properties file to load functions.
* a frontEnd.properties file so the frontEnd can heave readable features in multiple languages.
* a Exceptions.properties file that contains the list of exception displays. 
* a Shapes.properties file so that the user can toggle turtle images. 
	* Program would also require corresponding images. 
* a help.html page so that the user can have access to instructions. This is not required to run however. 
All of these files are provided in the project folder under the resources and images packages.  

Files Used To Start  
-------------------
Image files in images package. Language.properties file for loading functions.

Unique Features
---------------
The program meets all of the design requirements specified by the description. 
Quirks to save/load:
* variables and user defined functions do not maintain their uniqueness to a specific workspace once they are written. If you have declared various variables in multiple workspaces, they will all get written to one file. 
* similarly, if you load from a properties file, all the variables and user functions defined in that file will get loaded in your current workspace, but will not be accessible in other workspaces. 
I am proud of my util classes: WarpWall, Trail, WarpTrail, and Palette.
(not so much the ShapePalette. its fine. it's just unable to set new images like the color Palette could with new colors).
Also proud of my decorator pattern for the TurtleDrawers. Leads to possible extension.

Bugs
----
As of right now the program cannot crash.
small bug: shape index 3 and 4 have trouble displaying right away. I think it is
a problem with the image file, not the design. all other images show up right away.
The shapes appear the next time the screen is repainted ex) fd 0.

*last minute change:* We had forgotten to use the resource bundle for an exception in MapResourceModel. We changed it, and to see what was changed you can see the last commit. 

Extra Features
--------------
The resource file comes with a Italian.properties file so that the program can be run using Italian commands. However, this has to be toggled in the source code. If we had time, we would have added a "change language" feature to the frontend. 
You can toggle warp individually for each turtle. if a turtle is off the screen, toggle warp will move it onto the screen and calculate all trails.

Improvements
------------
The assignment was good but painful. Would have less "easy" commands and the same amount of "hard" commmands in the future because changing 40+ commands after a design change is not fun. 

