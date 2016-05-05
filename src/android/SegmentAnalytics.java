package org.apache.cordova.plugin;

import android.content.Context;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




/**
 * This class echoes a string called from JavaScript.
 */
public class SegmentAnalytics extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context=this.cordova.getActivity().getApplicationContext();

        if (action.equals("save")) {
            this.identify(args, callbackContext, context);
            return true;
        }
        return false;
    }


    private void save(JSONArray args, CallbackContext callbackContext, Context context) throws JSONException {
        String message = args.getString(0);
        JSONObject jsonProps = args.getJSONObject(1);

        if (message != null && message.length() > 0) {


            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}