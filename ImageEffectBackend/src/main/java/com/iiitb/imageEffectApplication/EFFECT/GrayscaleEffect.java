package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.GrayscaleInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class GrayscaleEffect extends GrayscaleInterface implements PhotoEffect
{
    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {
        //Logs
        try {
            loggingService.addLog(fileName, "GrayScaleEffect","NIL");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return applyGrayscale(image);
    }

}