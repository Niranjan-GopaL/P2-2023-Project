
# Image Processing Application

Image processing application that has provides an intuitive UI to


## Tech Stack and Features



--- 

## Setup and installation


```console
$ git clone project-dir-github-link
```


### Front end set up

```console
$ cd project-dir
$ npm i
$ cd ImageApplicationFrontend/
$ npm i && npm run start
```

### Back end set up

stuff about back end set up

---

## Breif about Logic of Effects

clamp() function is used to clamp a value within a range of 0 - 255   

##### Brightness.cpp  
1. add_to_color : amount to add to each pixel based on the brightness level
2. loops through each pixel of input image and add the calculated value to each of them. 

##### Contrast.cpp  
1. For each pixel, apply the contrast formula to each of r,g,b of current pixel.
> image[i][j].r =  (image[i][j].r - 128 ) * contrast_value + 128

##### Flip.cpp 
1. Flips whichever of  flip_value ( horizontal_flip_value / verticle_flip)  is true by 

2. Horizontal_flip logic :-
```cpp
Pixel p = inputImage[i][j];
                inputImage[i][j] = inputImage[i][inputImage[0].size() - j - 1];
                inputImage[i][inputImage[0].size() - j - 1] = p;
```

3. Verical_flip logic :-
```cpp
Pixel p = inputImage[i][j];
                inputImage[i][j] = inputImage[inputImage.size() - i - 1][j];
                inputImage[inputImage.size() - i - 1][j] = p;
```

##### Gaussian_Blur

1. Generating a Gaussian Matrix of a specified size which depends on the blur radius \
and we are *convolving* this matrix with pixel matrix.

2. Functions used 
    - getKernalSize() :- function is used to get the size of the kernal from the \
    gaussian blur radius
    - generateCoordinate() :- used to write the coordinates of the gaussian matrix in terms of the image matrix   
    - generateKernal() :- this function generates the gaussian blur matrix
    - K() :- used to calculate the each cell
    - calculateConvolution() :- used to convolve the matrices

##### Greyscale.cpp
- For each pixel, apply the grey_scale formula to each of r,g,b of current pixel.
> [!NOTE] 
> float grey_scaled_value = sqrt( ( fR * fR + fG * fG + fB * fB) / 3 )

##### Invert.cpp
- For each pixel, apply the grey_scale formula to each of r,g,b of current pixel.
> [!NOTE] 
> image[i][j].r =  255 -  image[i][j].r 

##### Sepia.cpp
- For each pixel, apply the sepia formula to each of r,g,b of current pixel.
> [!NOTE] 
> image[i][j].r =   image[i][j].r * 0.393 + image[i][j].g * 0.769 + image[i][j].b * 0.189 

## Wrapper classes
- EFFECTS folder Gassian Blur effect implements
    - GaussianBlurEffect implements SingleValueParameterisableEffect
    - InvertEffect implements PhotoEffect 
    - SepiaEffect implements PhotoEffect 
    - GreyScaleEffect implements PhotoEffect 
    - RotationEffect implements SingleValueDiscreteEffect 
    - HueSaturation implements ParameterizableEffect 
    - Flip implements DiscreteEffect
    - SharpenEffect implements SingleValueParameterisableEffect
    - BrightnessEffect implements SingleValueParameterisableEffect
    - ContrastEffect implements SingleValueParameterisableEffect


|All the expections were handled in PhotoEffectsServices |
| --- |

## Logs
- Implemented 
    - Filter by Effects   
    - Filter by date and time 
- Functions used

getAllLogs() :- returns list of all Logs
addLogs() :-  add a log to a text file in Backend
filterByEffect() :-  filter logs by effects given from front end
filterByTimestamp() :-  filter logs by effects given from front end


---

## Contributions

##### Aditya Saraf 
-  addlogs() getlogbyEffect() getAllLog() 
 - front end Date and Time 
 - Wrapper Class 
 - Debugging

##### Yash Sengupta  
- Sharpen
- Gaussian Blur 
- Integrate 
- Exception Handling

##### Niranjan Gopal 
- Inversion 
-  Flip 
- getLogBetween
- Git and README

##### Narayana       
- Dominant Color 
- Sepia 

##### Akash         
- Contrast
-  Rotation

##### Shreyank       
- Greyscale
-  Brightness
