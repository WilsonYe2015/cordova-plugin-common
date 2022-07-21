package com.castrol.common;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageManager;

/**
 * This class echoes a string called from JavaScript.
 */
public class Common extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getVersionNumber")) {
            this.getVersionNumber(callbackContext);
            return true;
        }
        return false;
    }

    private void getVersionNumber(CallbackContext callbackContext) {
        try
        {
        	 PackageManager packageManager = this.cordova.getActivity().getPackageManager();
             callbackContext.success(packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0).versionName);
             
        }
        catch(Exception err){
        	callbackContext.success("");
        }
    }
}
