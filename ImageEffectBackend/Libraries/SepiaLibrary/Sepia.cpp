#include <vector>
#include "../Pixel.h"
#include "Sepia.h"
#include "libraryInterfaces_SepiaInterface.h"

using namespace std;

// Function to clamp a floating-point value to the range [0, 255]
int clamp(float v){
    // If the value is greater than 255, set it to 255
    if(v > 255){
        v = 255;
    }
    return v;
}

// Function to apply Sepia filter to an image
vector<vector<Pixel>> applySepia(vector<vector <Pixel> > image){
    // Create a copy of the input image to avoid modifying the original image
    vector<vector<Pixel>> inputImage = image;

    // Loop through each pixel in the image
    for(int i = 0; i < image.size(); ++i){
        for(int j = 0; j < image[0].size(); ++j){
            // Apply the Sepia formula to each color channel of the current pixel
            inputImage[i][j].r = clamp((image[i][j].r * 0.393) + (image[i][j].g * 0.769) + (image[i][j].b * 0.189));
            inputImage[i][j].g = clamp((image[i][j].r  * 0.349) + (image[i][j].g * 0.686) + (image[i][j].b * 0.168));
            inputImage[i][j].b = clamp((image[i][j].r * 0.272) + (image[i][j].g * 0.534) + (image[i][j].b * 0.131));
        }
    }

    // Return the modified image
    return inputImage;
}
