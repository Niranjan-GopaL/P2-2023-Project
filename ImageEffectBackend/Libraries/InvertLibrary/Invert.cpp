#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include "libraryInterfaces_InvertInterface.h"
#include "Invert.h"
#include "../Pixel.h"
using namespace std;

// Function to invert the colors of an image
vector< vector<Pixel> > changeInvert(vector< vector<Pixel> > imageVector ){
    // Create a copy of the input image to avoid modifying the original image
    vector< vector<Pixel> > inputImage = imageVector;

    // Get the dimensions of the image (rows and columns)
    int row = inputImage.size();
    int col = inputImage[0].size();

    // Loop through each pixel in the image
    for(int i = 0 ; i < row ; i++){
        for(int j = 0 ; j < col ; j++){
            // Invert the color values by subtracting each channel value from 255
            inputImage[i][j].g = (255 - inputImage[i][j].g);
            inputImage[i][j].r = (255 - inputImage[i][j].r);
            inputImage[i][j].b = (255 - inputImage[i][j].b);
        }
    }

    // Return the modified image
    return inputImage;
}
