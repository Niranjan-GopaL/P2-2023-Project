#include "Brightness.h"  // Include the header file for declarations

// Function to apply brightness to an image represented as a 2D vector of Pixel objects
void apply_brightness(vector<vector<Pixel>> &imageVector, float amount)
{
    // Calculate the amount to add to each color channel based on the specified brightness level
    int add_to_color = static_cast<int>((amount * 255) / 200);

    // Get the dimensions of the image (rows and columns)
    int r_size = imageVector.size();
    int c_size = imageVector[0].size();

    // Loop through each pixel in the image
    for (int i = 0; i < r_size; i++)
    {
        for (int j = 0; j < c_size; j++)
        {
            // Reference to the current Pixel object
            Pixel &element = imageVector[i][j];

            // Add the calculated amount to each color channel
            element.r += add_to_color;
            element.g += add_to_color;
            element.b += add_to_color;

            // Ensure that the color values are capped at 255 to prevent overflow
            element.r = min(255, element.r);
            element.g = min(255, element.g);
            element.b = min(255, element.b);
        }
    }
}
