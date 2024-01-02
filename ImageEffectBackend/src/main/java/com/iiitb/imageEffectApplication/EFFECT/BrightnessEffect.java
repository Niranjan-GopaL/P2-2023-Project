package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.BrightnessInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class BrightnessEffect extends BrightnessInterface implements SingleValueParameterizableEffect
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
        //Logs
        try {
            loggingService.addLog(fileName, "BrightnessEffect",String.valueOf(amount));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applyBrightness(image,amount);
    }
}