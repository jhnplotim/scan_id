package com.jcode.scanid;

import android.app.Application;

import com.microblink.MicroblinkSDK;
import com.microblink.intent.IntentDataTransferMode;

/**
 * Created by otimj on 8/16/2019.
 */
public class ScanApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();

		// obtain your licence at http://microblink.com/login or
		// contact us at http://help.microblink.com
		MicroblinkSDK.setLicenseFile("com.jcode.scanid.mblic", this);


		//TODO: Implement picking of license file from the internet and storing it on phone on start up

		// use optimised way for transferring RecognizerBundle between activities, while ensuring
		// data does not get lost when Android restarts the scanning activity
		MicroblinkSDK.setIntentDataTransferMode(IntentDataTransferMode.PERSISTED_OPTIMISED);
	}
}
