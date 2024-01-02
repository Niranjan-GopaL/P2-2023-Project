#ifndef CONTRAST_H
#define CONTRAST_H
#include<vector>
#include "../Pixel.h"

using namespace std;

vector< vector<Pixel> > applyContrast(vector< vector<Pixel> > image, float contrastAmount);

#endif