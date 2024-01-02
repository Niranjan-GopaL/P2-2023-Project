package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.GaussianBlurInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class GaussianBlurEffect extends GaussianBlurInterface implements SingleValueParameterizableEffect
{
    float radius;

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException
    {
        radius = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {

        Pixel[][] modifiedImage =  applyGaussianBlur(image,radius/10);

        //Logs
        try {
            loggingService.addLog(fileName, "GaussianBlur",String.valueOf(radius));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  modifiedImage;
    }

}