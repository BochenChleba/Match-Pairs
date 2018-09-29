package com.bochenchleba.match.workers;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapResizer {
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId) {

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inSampleSize = 3;
        options.inTempStorage = new byte[16*1024];

        Bitmap imageBitmap = BitmapFactory.decodeResource(res, resId, options);

        return Bitmap.createScaledBitmap(imageBitmap, 200, 200, true);
    }
}
