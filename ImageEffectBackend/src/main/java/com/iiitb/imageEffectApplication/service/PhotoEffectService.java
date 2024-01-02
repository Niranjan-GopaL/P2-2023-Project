package com.iiitb.imageEffectApplication.service;

import com.iiitb.imageEffectApplication.EFFECT.*;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.utils.ProcessingUtils;

import libraryInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class PhotoEffectService {

    @Autowired
    private ProcessingUtils processingUtils;

    @Autowired
    private LoggingService loggingService;

    public ResponseEntity<byte[]> applyHueSaturationEffect(float hueAmount, float saturationAmount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the HueSaturationEffect Class created in the EFFECTS folder to create
            // a HueSaturation object.

            HueSaturationEffect HueSaturation = new HueSaturationEffect();

            // Passing the parameter values

            HueSaturation.setParameter("hue",hueAmount);
            HueSaturation.setParameter("saturation",saturationAmount);

            Pixel[][] modifiedImage = HueSaturation.apply(inputImage,imageName,loggingService);

            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException  | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyBrightnessEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();

            // ACTUAL WORK STARTS HERE

            // TODO
            // Using the BrightnessEffect Class created in the EFFECTS folder to create
            // a Brightness object.

            BrightnessEffect Brightness = new BrightnessEffect();
            Brightness.setParameterValue(amount);
            Pixel[][] modifiedImage = Brightness.apply(inputImage,imageName,loggingService);


            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyContrastEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();



            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the ContrastEffect Class created in the EFFECTS folder to create
            // a Contrast object.

            ContrastEffect Contrast = new ContrastEffect();
            Contrast.setParameterValue(amount);
            Pixel[][] modifiedImage = Contrast.apply(inputImage,imageName,loggingService);
            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyFlipEffect(MultipartFile imageFile, int horizontalFlipValue, int verticalFlipValue) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();



            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the FlipEffect Class created in the EFFECTS folder to create
            // a Flip object.

            FlipEffect Flip = new FlipEffect();
            Flip.selectOptionValue("horizontal",horizontalFlipValue);
            Flip.selectOptionValue("vertical",verticalFlipValue);
            Pixel[][] modifiedImage = Flip.apply(inputImage,imageName,loggingService);

            // ACTUAL WORK ENDS HERE




            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGaussianBlurEffect(float radius, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            //System.out.println(radius);
            LoggingService ls = new LoggingService();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the GaussianBlurEffect Class created in the EFFECTS folder to create
            // a GaussianBlur object.

            GaussianBlurEffect GaussianBlur = new GaussianBlurEffect();
            GaussianBlur.setParameterValue(radius);
            Pixel[][] modifiedImage = GaussianBlur.apply(inputImage,imageName,loggingService);

            // ACTUAL WORK ENDS HERE



            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException | IllegalParameterException e  ) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyGrayscaleEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the GrayscaleEffect Class created in the EFFECTS folder to create
            // a Grayscale object.

            GrayscaleEffect Grayscale = new GrayscaleEffect(); // Replace this with actual modified image
            Pixel[][] modifiedImage = Grayscale.apply(inputImage,imageName,loggingService);

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyInvertEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the InvertEffect Class created in the EFFECTS folder to create
            // an Invert object.

            InvertEffect Invert = new InvertEffect(); // Replace this with actual modified image
            Pixel[][] modifiedImage = Invert.apply(inputImage,imageName,loggingService);

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applyRotationEffect(int value, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();



            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the RotationEffect Class created in the EFFECTS folder to create
            // a Rotate object.

            RotateEffect Rotate = new RotateEffect();
            Rotate.setParameterValue(value);
            Pixel[][] modifiedImage = Rotate.apply(inputImage,imageName,loggingService);

            // ACTUAL WORK ENDS HERE


            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySepiaEffect(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();


            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the SepiaEffect Class created in the EFFECTS folder to create
            // a Sepia object.

            SepiaEffect Sepia = new SepiaEffect(); // Replace this with actual modified image
            Pixel[][] modifiedImage = Sepia.apply(inputImage,imageName,loggingService);

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> applySharpenEffect(float amount, MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();

            // ACTUAL WORK STARTS HERE

            // TODO

            // Using the SharpenEffect Class created in the EFFECTS folder to create
            // a Sharpen object.

            SharpenEffect Sharpen = new SharpenEffect();
            Sharpen.setParameterValue(amount);
            Pixel[][] modifiedImage = Sharpen.apply(inputImage,imageName,loggingService);



            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        }
        // Handling the Exceptions
        catch (IOException | IllegalParameterException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<byte[]> getDominantColour(MultipartFile imageFile) {
        try {
            Pixel[][] inputImage = processingUtils.preprocessing(imageFile);
            String imageName = imageFile.getOriginalFilename();
            LoggingService ls = new LoggingService();

            // ACTUAL WORK STARTS HERE

            // TODO
            //Pixel[][] modifiedImage = DominantColourInterface.applyDominantColour(inputImage); // Replace this with actual modified image
            Pixel[][] modifiedImage  = inputImage;

            // ACTUAL WORK ENDS HERE

            return processingUtils.postProcessing(modifiedImage);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
