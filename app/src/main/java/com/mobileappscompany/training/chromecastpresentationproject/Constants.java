package com.mobileappscompany.training.chromecastpresentationproject;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Android1 on 3/12/2015.
 */
public class Constants {
    public static final int TEXT_SEND_RECEIVE_RESULT_CODE = 1000;
    public static final int CAST_VIDEO_RESULT_CODE        = 2000;
    public static final int CAST_MP3_RESULT_CODE          = 3000;

    public static void showNotYetImplementedToast(Context context) {
        Toast.makeText(context,
                context.getString(R.string.not_yet_implemented),
                Toast.LENGTH_SHORT).show();
    }
}
