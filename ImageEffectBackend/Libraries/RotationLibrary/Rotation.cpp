#include <vector>
#include "../Pixel.h"
#include "Rotation.h"
#include "libraryInterfaces_RotationInterface.h"
using namespace std;

vector<vector<Pixel>> applyRotation( vector<vector<Pixel>> imageVector, int amount) {
    // Make a copy of the input imageVector
    vector<vector<Pixel>> rotatedImage = imageVector;

    // Get the dimensions of the image
    int rows = imageVector.size();
    int cols = imageVector[0].size();

    // Apply rotation 'amount' times
    for (int rotation = 0; rotation < amount; ++rotation) {

        rows = rotatedImage.size();
        cols = rotatedImage[0].size();

        // Create a new vector to store the rotated image
        vector<vector<Pixel>> rotated(cols, vector<Pixel>(rows));

        // Perform the rotation
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                rotated[cols - 1 - j][i] = rotatedImage[i][j];
            }
        }

        // Update the rotatedImage for the next iteration
        rotatedImage = rotated;
    }

    // Return the final rotated image
    return rotatedImage;
}