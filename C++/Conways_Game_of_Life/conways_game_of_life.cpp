#include <iostream>
#include <string>
#include <cstdlib>
#include <errno.h>
#include <fstream>
#include <vector>
#include <cmath>

using namespace std;

struct cell{
	char state;
	int x,y;
	cell(){
		
	}
	cell(cell& toCopy){
		x=toCopy.x;
		y=toCopy.y;
		state = toCopy.state;
	}
};
cell* getCell(int y,int x, vector<cell*>* subBoard){
	for (int i = 0; i < subBoard->size(); i += 1){
		if((*subBoard)[i]->x == x && (*subBoard)[i]->y == y)
			return (*subBoard)[i];
	}
	cell * newDeadCell = new cell;
	newDeadCell->x=x;
	newDeadCell->y=y;
	newDeadCell->state=' ';
	return newDeadCell;
}

void simulate(int iterations, int& l, int& r, int& t, int& b, vector<cell*>*& subBoard){
	
	for (int z = 0; z < iterations; z += 1){
		vector<cell *>* newSubBoard = new vector<cell *>;
		for (int y = t-1; y <= b+1; y += 1){
			for (int x = l-1; x <= r+1; x += 1){
				cell* currCell = getCell(y,x,subBoard);
				int aliveNeighbours=0;
				
				for (int i = 0; i < subBoard->size(); i += 1){
					if(abs((*subBoard)[i]->x - currCell->x) <= 1 && abs((*subBoard)[i]->y - currCell->y) <= 1 && (*subBoard)[i]->state == '#' && !(currCell->x == (*subBoard)[i]->x && currCell->y == (*subBoard)[i]->y)) // if neighbour 
					aliveNeighbours++;
				}



				
				cell * newCell = new cell(*currCell);
				if(newCell->state == '#'){	// Alive cell
					
					if(aliveNeighbours < 2){
						newCell->state = ' '; // dies
					}
					else if(aliveNeighbours > 3){
						newCell->state = ' '; // dies
					}
					newSubBoard->push_back(newCell);
				}
				else if(newCell->state == ' '){	// Dead cell
					if(aliveNeighbours == 3){
						newCell->state = '#';
							
						newSubBoard->push_back(newCell);
					}
					else{
						if(newCell->x > r || newCell->x < l || newCell->y < t || newCell->y > b){
							delete currCell; // useless dead cell exists outside subBoard
							delete newCell;
						}
						else
							newSubBoard->push_back(newCell);
					}
				}
			}
		}
//		for (int i = 0; i < subBoard->size(); i += 1){
//			delete (*subBoard)[i];
//		}
		delete subBoard;
		subBoard = newSubBoard;
		
		
		bool check = false;
		for (int i = 0; i < subBoard->size(); i += 1){
			if((*subBoard)[i]->state == '#'){
				if(!check){
					l = (*subBoard)[i]->x;
					r = (*subBoard)[i]->x;
					t = (*subBoard)[i]->y;
					b = (*subBoard)[i]->y;
					check=true;
				}
				else{
					if(l > (*subBoard)[i]->x)
						l = (*subBoard)[i]->x;
					if(r < (*subBoard)[i]->x)
						r = (*subBoard)[i]->x;
					if(t > (*subBoard)[i]->y)
						t = (*subBoard)[i]->y;
					if(b < (*subBoard)[i]->y)
						b = (*subBoard)[i]->y;
				}
			}
			
		}
		if(check == false){
			for (int i = 0; i < subBoard->size(); i += 1){
				delete (*subBoard)[i];
			}
			while(!subBoard->empty())
				subBoard->erase(subBoard->begin());
		}
		else{
			for (int i = 0; i < subBoard->size(); i += 1){
				if((*subBoard)[i]->state != '#' && ((*subBoard)[i]->x > r || (*subBoard)[i]->x < l || (*subBoard)[i]->y < t || (*subBoard)[i]->y > b))
				delete (*subBoard)[i];
			}
		}
	
		
		
		
	}
}

int main (int argc, char *argv[])
{
system ("clear");
	if(argc < 3){
		cout<<"Argument missing\n";	// requires number of turns, init state file, result file as arguments
		exit(EXIT_FAILURE);
	}
	
	// Opening file to read initial state:
		ifstream readInitState; //input stream object
		readInitState.open(argv[2]);
	if(!readInitState.is_open()){
		cout<<"Failed to open file\n";
		exit(EXIT_FAILURE);
	}
	int l,r,t,b; // left,right,bottom,top /// these integers define the sub board
	readInitState >> l >> r >> t >> b;
	readInitState.ignore();
	//cout<<l<<" "<<r<<" "<<t<<" "<<b<<"\n";
	
	vector<struct cell*>* subBoard = new vector<struct cell*>;
	// Reading charachter by charachter:
	for (int y = 0; !readInitState.eof() && y < (b-t+1); y += 1){
		for (int x = 0; !readInitState.eof() && readInitState.peek()!='\n' && x < (r-l+1); x += 1){
			cell * newCell = new cell;
			newCell->state = readInitState.get();
			newCell->x = x+l;
			newCell->y = y+t;
			subBoard->push_back(newCell);
		}
		readInitState.ignore();
	}
	
//	for (int y = t; y <= b; y += 1){
//		for (int x = l; x <= r; x += 1){
//			cout<<getCell(y,x,subBoard);
//		}
//		cout<<"\n";
//	}

	readInitState.close();
	
	// Now Simulating:
		simulate(atoi(argv[1]),l,r,t,b,subBoard);
		
	// Open File to write:
		ofstream result;
		result.open(argv[3]);
		if(!result.is_open()){
			cout<<"Error writing to file\n";
			exit(EXIT_FAILURE);
		}
	
	if(subBoard->size() == 0)
		result << "E";
	else{	
		result<<l<<" "<<r<<" "<<t<<" "<<b<<"\n";
		for (int y = t; y <= b; y += 1){
			for (int x = l; x <= r; x += 1){
				result<<getCell(y,x,subBoard)->state;
			}
			result<<"\n";
		}
	}
	result.close();

cout<<endl;
return 0;
}











