package com.iiitb.imageEffectApplication.EFFECT;

import com.iiitb.imageEffectApplication.baseEffects.*;
import libraryInterfaces.FlipInterface;
import libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public class FlipEffect extends FlipInterface implements DiscreteEffect
{
    int horizontalFlipValue;
    int verticalFlipValue;

    @Override
    public void selectOptionValue( String paramName, int value) throws IllegalParameterException
    {
        if (paramName.equals("horizontal"))
        {
            horizontalFlipValue = value;
        } else if (paramName.equals("vertical")) {
            verticalFlipValue = value;
        }
    }

    @Override
    public Pixel[][] apply(Pixel[][] image,String fileName,LoggingService loggingService)
    {

        Pixel[][] modifiedImage =  applyFlip(image,horizontalFlipValue,verticalFlipValue);

        //Logs
        try {
            loggingService.addLog(fileName, "FlipEffect","H_Val:"+String.valueOf(horizontalFlipValue)+"V_Val:"+String.valueOf(verticalFlipValue));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  modifiedImage;
    }

}