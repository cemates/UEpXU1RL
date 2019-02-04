/**
*
*  @author Hüseyin Cem Ateþ S13869  Group 11C
*
*  PJWSTK**  The first big assignment: Labyrinth**  Related Teacher: Michal R. Przybylek*
*
*/


#include <stdio.h>
#include "stdafx.h"
#include <fstream>
#include <string>
#include <iostream>
#include <chrono>
#include <thread>
#include <stack>
#include <vector>

#define FALSE 0
#define TRUE 1

int NROWS;
int MCONS;
using namespace std;

vector<string> maze;
stack <string> path;

void disp_maze(void);
int find_path( int x, int y);

void disp_maze(void)
{
	int i;

	printf("MAZE:\n");
	for ( i = 0; i < NROWS; i++ )
			cout<< maze[i] << endl;
	printf("\n");

	return;
}



int find_path( int x, int y)
{
	// If x,y is outside maze, return false.
	if ( x < 0 || x > MCONS - 1 || y < 0 || y > NROWS - 1 ) return FALSE;

	// If x,y is the goal, return true.
	if ( maze[y][x] == '$' ) return TRUE;

	// If x,y is not open, return false.
	if ( maze[y][x] != ' ' && maze[y][x] != '@' ) return FALSE;

	// Mark x,y part of solution path.
	maze[y][x] = '+';

	// If find_path Up of x,y is true, return true.
	if ( find_path(x, y - 1) == TRUE )
	{
		//std::cout << "U";
		path.push("U");
		return TRUE;
	}

	// If find_path Right of x,y is true, return true.
	if ( find_path(x + 1, y) == TRUE ) 
	{ 	//std::cout << "R";
		path.push("R");
		return TRUE;
	}

	// If find_path Down of x,y is true, return true.
	if ( find_path(x, y + 1) == TRUE )
		{	//std::cout << "D";
			path.push("D");
			return TRUE;
	}

	// If find_path Left of x,y is true, return true.
	if ( find_path(x - 1, y) == TRUE )
		{	//std::cout << "L";
			path.push("L");
			return TRUE;
	}

	// Unmark x,y as part of solution path.
	maze[y][x] = 'x';

	return FALSE;
}
// find_path()

int _tmain(int argc, _TCHAR* argv[])
{
	//  problem — the name of a file that describes a labyrinth
	//  solution — the name of a file to store a solution
	std::string inputfile, outputfile;
	std::cout << "Enter the path of the maze file(example: 'c:/problem1.txt'): ";
	std::cin >> inputfile;
	std::cout << "Enter the path of the maze file(example: 'c:/solution1.txt'): ";
	std::cin >> outputfile;
	std::ifstream file(inputfile);
	//---------------------------------------------------------------------------
	std::string str= "###"; 
    std::getline(file, str);

	std::string l;
	l = str[0];
	NROWS = std::stoi(l);
	
    std::string c;
	c = str[2];
	MCONS = std::stoi(c);
	
	std::cout <<"Maze of " << NROWS << " Rows and " << MCONS << " Columns" << endl;
	//----------------------------------------------------------------------
	while (std::getline(file, str))
    {
		maze.push_back(str);
    }
	//-----------------------------------------------------------------------
	int xstart = 0,ystart = 0;
	for(int i=0; i<NROWS; i++)
		for (int j=0;j<MCONS; j++)
		{
			if (maze[i][j] == '@')
			{
				xstart = i;
				ystart = j;
			}
		}
		std::cout <<"Monkey position (" << xstart << "," << ystart << ")\n" << endl;
	//----------------------------------------------------------------------
	disp_maze();

	if ( find_path(ystart, xstart) == TRUE )
	{
		printf("\nSuccess!\n\n");
		printf("Solution is:\n");
	}

	else
		printf("\nE\n");
    disp_maze();
	//-------------------------------------------------------------------
	ofstream outputf;
    outputf.open (outputfile);
  	printf("\nPath is: ");
	while( !path.empty() ) {
     cout << path.top();
	 outputf << path.top();
     path.pop();
     } 
	outputf.close();
	//--------------------------------------------------------------------
	printf("\n\nPress any key to quit the maze...");
	std::cin.get();
	std::cin.get();
	return 0;
}

