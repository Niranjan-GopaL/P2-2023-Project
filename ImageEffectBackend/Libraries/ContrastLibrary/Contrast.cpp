#include <vector>
#include "../Pixel.h"
#include "Contrast.h"
#include "libraryInterfaces_ContrastInterface.h"

#include <vector>
using namespace std;

// Function to clamp a value within the range [0, 255]
int clamp(float v) {
    // If the value is below 0, set it to 0
    if (v < 0) {
        v = 0;
    }
    // If the value is above 255, set it to 255
    if (v > 255) {
        v = 255;
    }
    // Return the clamped value
    return v;
}

// Function to apply contrast to an image represented as a 2D vector of Pixel objects
vector< vector<Pixel> > applyContrast(vector<vector<Pixel>> image, float contrastValue) {
    // Loop through each row of the image
    for (int i = 0; i < image.size(); i++) {
        // Loop through each column of the image
        for (int j = 0; j < image[i].size(); j++) {
            // Apply contrast formula to each channel of the current pixel
            image[i][j].r = clamp((image[i][j].r - 128) * contrastValue + 128);
            image[i][j].g = clamp((image[i][j].g - 128) * contrastValue + 128);
            image[i][j].b = clamp((image[i][j].b - 128) * contrastValue + 128);
        }
    }
    // Return the modified image
    return image;
}
