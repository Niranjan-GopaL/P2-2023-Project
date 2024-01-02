package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.InvertInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;

public class InvertEffect extends InvertInterface implements PhotoEffect
{
    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {
        //Logs
        try {
            loggingService.addLog(fileName, "InvertEffect","NIL");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return applyInvert(image);
    }

}