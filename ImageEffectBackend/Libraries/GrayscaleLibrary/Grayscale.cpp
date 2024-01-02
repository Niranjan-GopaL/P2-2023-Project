#include <bits/stdc++.h>
#include "libraryInterfaces_GrayscaleInterface.h"
#include "Grayscale.h"
#include "../Pixel.h"
using namespace std;

// Function to clamp a floating-point value to the range [0, 255]
int clamp(float v)
{
    if (v < 0)
        return 0;
    if (v > 255)
        return 255;
    return static_cast<int>(v);
}

// Function to apply grayscale conversion to an image
vector<vector<Pixel>> applyGrayscale(vector<vector<Pixel>> image)
{
    // Create a copy of the input image to avoid modifying the original image
    vector<vector<Pixel>> inputImage = image;

    // Loop through each pixel in the image
    for (int i = 0; i < image.size(); i++) {
        for (int j = 0; j < image[0].size(); j++) {

            // Extract individual color channels from the current pixel
            int fR = image[i][j].r;
            int fG = image[i][j].g;
            int fB = image[i][j].b;

            // Calculate the weighted average of color channels to obtain the grayscale value
            float fWB = static_cast<float>(sqrt((fR * fR + fG * fG + fB * fB) / 3.0));

            // Set the grayscale value for each channel of the current pixel
            inputImage[i][j].r = fWB;
            inputImage[i][j].g = fWB;
            inputImage[i][j].b = fWB;
        }
    }

    // Return the modified image
    return inputImage;
}
