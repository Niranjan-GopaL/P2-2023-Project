package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.RotationInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class RotateEffect extends RotationInterface implements SingleValueDiscreteEffect
{
    int value;

    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException
    {
        value = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {
        //Logs
        try {
            loggingService.addLog(fileName, "RotateEffect",String.valueOf(value));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return applyRotation(image,value);

    }

}