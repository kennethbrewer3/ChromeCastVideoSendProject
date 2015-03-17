package com.mobileappscompany.training.chromecastpresentationproject;

import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import com.google.android.gms.cast.CastDevice;

/**
 * Created by Android1 on 3/17/2015.
 */
public class MyMediaRouterCallback extends Callback {
    private  CastDevice mSelectedDevice;

    @Override
    public void onRouteSelected(MediaRouter router, RouteInfo info) {
        mSelectedDevice = CastDevice.getFromBundle(info.getExtras());
        String routeId = info.getId();
    }

    @Override
    public void onRouteUnselected(MediaRouter router, RouteInfo info) {
//        teardown();
        mSelectedDevice = null;
    }


}
