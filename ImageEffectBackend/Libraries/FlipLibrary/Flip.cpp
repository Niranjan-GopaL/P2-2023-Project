#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include "libraryInterfaces_FlipInterface.h"
#include "Flip.h"
#include "../Pixel.h"
using namespace std;

// Function to change the flip of an image based on specified horizontal and vertical flip values
vector< vector<Pixel> > changeFlip(vector< vector<Pixel> > imageVector, int horizontalFlipValue, int verticalFlipValue) {
    // Create a copy of the input image to avoid modifying the original image
    vector< vector<Pixel> > inputImage = imageVector;

    // Get the dimensions of the image (rows and columns)
    int row = inputImage.size();
    int col = inputImage[0].size();

    // Check if horizontal flip is requested
    if (horizontalFlipValue == 1) {
        // Loop through each row and swap pixels horizontally
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                // Swap pixels along the horizontal axis
                Pixel p = inputImage[i][j];
                inputImage[i][j] = inputImage[i][inputImage[0].size() - j - 1];
                inputImage[i][inputImage[0].size() - j - 1] = p;
            }
        }
    }

    // Check if vertical flip is requested
    if (verticalFlipValue == 1) {
        // Loop through each column and swap pixels vertically
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                // Swap pixels along the vertical axis
                Pixel p = inputImage[i][j];
                inputImage[i][j] = inputImage[inputImage.size() - i - 1][j];
                inputImage[inputImage.size() - i - 1][j] = p;
            }
        }
    }

    // Return the modified image
    return inputImage;
}
