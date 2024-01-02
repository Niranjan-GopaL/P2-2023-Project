package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.HueSaturationInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class HueSaturationEffect extends HueSaturationInterface implements ParameterizableEffect
{
    float saturationValue;
    float hueValue;

    @Override
    public void setParameter( String paramName, float value) throws IllegalParameterException
    {
        if (paramName.equals("hue"))
        {
            hueValue = value;
        } else if (paramName.equals("saturation")) {
            saturationValue = value;
        }
    }

    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {

        Pixel[][] modifiedImage =  applyHueSaturation(image,saturationValue/10.0f,hueValue/10.0f);

        //Logs
        try {
            loggingService.addLog(fileName, "HueSaturationEffect","SVal:"+String.valueOf(saturationValue/10.0)+"HVal:"+String.valueOf(hueValue/10.0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  modifiedImage;
    }

}