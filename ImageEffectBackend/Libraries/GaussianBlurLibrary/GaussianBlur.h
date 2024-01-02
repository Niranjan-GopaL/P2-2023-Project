#ifndef GAUSSIAN_BLUR_H
#define GAUSSIAN_BLUR_H
#include<vector>
#include "../Pixel.h"

using namespace std;

vector< vector<Pixel> > applyGaussianBlur(vector< vector<Pixel> > image, float gaussianblurRadius);

#endif