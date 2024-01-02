package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.SepiaInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class SepiaEffect extends SepiaInterface implements PhotoEffect
{
    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {
        //Logs
        try {
            loggingService.addLog(fileName, "SepiaEffect","NIL");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return applySepia(image);
    }

}