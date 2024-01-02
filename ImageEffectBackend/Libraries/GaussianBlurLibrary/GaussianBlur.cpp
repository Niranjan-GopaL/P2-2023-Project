#include <bits/stdc++.h>
#include "libraryInterfaces_GaussianBlurInterface.h"
#include "GaussianBlur.h"
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

// Function to calculate the size of the Gaussian blur kernel based on the specified radius
int getKernelSize(float gaussianblurRadius)
{
    float standardDeviation = gaussianblurRadius / static_cast<float>(sqrt(2.0));
    int size = 2 * ceil(3 * standardDeviation) + 1;
    return size;
}

// Function to generate the coordinates for the convolution kernel in terms of the Image Matrix
vector<int> generateCoordinate(int i, int j, int i1, int j1, int size)
{
    vector<int> result = {i - size / 2 + i1, j - size / 2 + j1};
    return result;
}

// Function to calculate the Gaussian kernel function value for a given coordinate
float K(float x, float y, float standardDeviation)
{
    float x2 = x * x;
    float y2 = y * y;
    float standardDeviation2 = 2.0 * standardDeviation * standardDeviation;
    float a = std::exp(-(x2 + y2) / standardDeviation2);
    float b = 1.0 / (M_PI * standardDeviation2);

    float result = a * b;

    return result;
}

// Function to generate the Gaussian blur kernel matrix
vector<vector<float>> generateKernel(float standardDeviation, int size)
{
    vector<vector<float>> Kernel;

    Kernel.resize(size);
    for (int i = 0; i < size; i++)
    {
        Kernel[i].resize(size);
    }
    float sum = 0.0;

    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            float temp = K(static_cast<float>(i), static_cast<float>(j), standardDeviation);
            sum += temp;
            Kernel[i][j] = temp;
        }
    }
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            Kernel[i][j] = Kernel[i][j] / sum;
        }
    }
    return Kernel;
}

// Function to check if the given index is valid within the specified size
bool checkvalidIndex(int i, int j, int size)
{
    if (i >= 0 && i < size && j >= 0 && j < size)
    {
        return true;
    }
    else
    {
        return false;
    }
}

// Function to add two Pixel objects, clamping the result
Pixel addPixels(Pixel p1, Pixel p2)
{
    Pixel result;
    result.r = clamp(p1.r + p2.r);
    result.b = clamp(p1.b + p2.b);
    result.g = clamp(p1.g + p2.g);

    return result;
}

// Function to perform convolution on a pixel in the image using the Gaussian blur kernel
Pixel calculateConvolution(int i, int j, vector<vector<Pixel>> imageVector, vector<vector<float>> kernelMatrix)
{
    int size = kernelMatrix.size();
    int size1 = imageVector.size();
    Pixel result = {0, 0, 0};

    for (int i1 = 0; i1 < size; i1++)
    {
        for (int j1 = 0; j1 < size; j1++)
        {
            vector<int> coordinate = generateCoordinate(i, j, i1, j1, size);
            if (checkvalidIndex(coordinate[0], coordinate[1], size1))
            {
                Pixel temp = imageVector[coordinate[0]][coordinate[1]];
                temp.r = clamp(temp.r * kernelMatrix[i1][j1]);
                temp.b = clamp(temp.b * kernelMatrix[i1][j1]);
                temp.g = clamp(temp.g * kernelMatrix[i1][j1]);

                result = addPixels(result, temp);
            }
            else
            {
                Pixel temp = imageVector[i][j];
                temp.r = clamp(temp.r * kernelMatrix[i1][j1]);
                temp.b = clamp(temp.b * kernelMatrix[i1][j1]);
                temp.g = clamp(temp.g * kernelMatrix[i1][j1]);
                result = addPixels(result, temp);
            }
        }
    }

    return result;
}

// Function to apply Gaussian blur to the entire image
vector< vector<Pixel> > applyGaussianBlur(vector< vector<Pixel> > image, float gaussianblurRadius)
{
    // Calculate the size of the Gaussian blur kernel and the standard deviation
    int kernelSize = getKernelSize(gaussianblurRadius);
    float standardDeviation = gaussianblurRadius / static_cast<float>(sqrt(2.0));

    // Generate the Gaussian blur kernel matrix
    vector<vector<float>> kernelMatrix = generateKernel(standardDeviation, kernelSize);

    // Create a copy of the input image to avoid modifying the original image
    vector<vector<Pixel>> inputImage = image;

    // Loop through each pixel in the image and perform convolution using the Gaussian blur kernel
    for (int i = 0; i < image.size(); i++)
    {
        for (int j = 0; j < image[0].size(); j++)
        {
            Pixel x = calculateConvolution(i, j, image, kernelMatrix);
            inputImage[i][j] = x;
        }
    }

    // Return the modified image
    return inputImage;
}
