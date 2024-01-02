package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.ContrastInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class ContrastEffect extends ContrastInterface implements SingleValueParameterizableEffect
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
            loggingService.addLog(fileName, "ContrastEffect",String.valueOf(amount));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return applyContrast(image,amount/10);

    }

}