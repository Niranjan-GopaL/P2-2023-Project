#ifndef DOMINANTCOLOUR_H
#define DOMINANTCOLOUR_H
#include<vector>
#include "../Pixel.h"
#include "libraryInterfaces_DominantColourInterface.h"
using namespace std;
vector < vector<Pixel> > applyDominantColour(vector < vector<Pixel> > image);
#endif