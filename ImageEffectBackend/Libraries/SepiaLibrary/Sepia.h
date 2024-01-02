#ifndef SEPIA_H
#define SEPIA_H
#include<vector>
#include "../Pixel.h"
#include "libraryInterfaces_SepiaInterface.h"
using namespace std;
vector<vector<Pixel>> applySepia(vector < vector<Pixel> > image);
#endif