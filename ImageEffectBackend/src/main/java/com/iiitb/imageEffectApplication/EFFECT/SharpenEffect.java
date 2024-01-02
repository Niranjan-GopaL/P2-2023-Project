package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.SharpenInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class SharpenEffect extends SharpenInterface implements SingleValueParameterizableEffect
{
    float amount;

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException
    {
        amount = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {

        Pixel[][] modifiedImage =  applySharpen(image,amount/10);

        //Logs
        try {
            loggingService.addLog(fileName, "SharpenEffect",String.valueOf(amount));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  modifiedImage;
    }

}