package com.path.actions.common.scan;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

import com.path.bo.common.ConstantsCommon;
import com.path.lib.log.Log;
import com.topaz.sigplus.SigPlus;

public final class SignaturePadConverter
{
    /**
     * private constructor to prevent instantiation of the class
     * since all methods are static
     */
    private SignaturePadConverter()
    {
	Log.getInstance().warning("This Class is utility class cannot be instantiated");
    }
    /*
     *  convertSignature() method Receives String
     * (the signature captured object from the ActiveX)
     * Returns A byte array of the signature in the form of buffered image
     */
    public static byte[] convertSignature(String signString)
    {
	byte[] imgByteArray = null;
	try
	{
	    SigPlus sigObj = new SigPlus();

	    //Define The Signature tablet object
	    sigObj.setTabletModel(ConstantsCommon.SIGN_PAD_MODEL);
	    sigObj.setTabletComPort(ConstantsCommon.SIGN_PAD_PORT);
	    sigObj.setSigCompressionMode(1);
	    sigObj.setSigString(signString);

	    if(sigObj.numberOfTabletPoints() > 0)
	    {
		sigObj.setDisplayJustifyX(10);
		sigObj.setDisplayJustifyY(10);
		sigObj.setDisplayJustifyMode(5);
		sigObj.setImagePenWidth(2);
		sigObj.setImageXSize(300);
		sigObj.setImageYSize(100);
		sigObj.setImageJustifyX(10);
		sigObj.setImageJustifyY(10);
		sigObj.setImageJustifyMode(5);
		
		BufferedImage sigImage = sigObj.sigImage();
		int w = sigImage.getWidth(null);
		int h = sigImage.getHeight(null);
		int[] pixels = new int[(w * h) * 2];

		sigImage.setRGB(0, 0, 0, 0, pixels, 0, 0);
		
		//Create a byte array output stream
		ByteArrayOutputStream bais = new ByteArrayOutputStream();

		//encode the signature image into the image encoder as a jpeg image
		ImageIO.write(sigImage, ConstantsCommon.SIGNED_EXT, bais);
		
		//convert the byte array output stream to byte array 
		imgByteArray = bais.toByteArray();
	    }
	}
	catch(Exception ex)
	{
	    return null;
	}
	return imgByteArray;
    }
}
