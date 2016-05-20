
package me.pengwei.phonegap.plugins;

import android.content.Intent;
import android.net.Uri;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenInBrowser extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        
        final JSONObject options = args.getJSONObject(0);
        final String url = options.getString("url");
        
        if (action.equals("showQQBrowser")) {
            showQQBrowser(url);
            return true;
        }
        
        if (action.equals("showUCBrowser")) {
            showUCBrowser(url);
            return true;
        }
        
        return true;
    }
    
    /** 直接启动QQ，用于验证测试。 */
    private void showQQBrowser(String url) {
        Intent intent = new Intent();
        intent.setClassName("com.tencent.mtt", "com.tencent.mtt.SplashActivity");
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse(url));
        //startActivity(intent);
        cordova.getActivity().startActivity(intent);
    }
    
    /** 直接启动UC，用于验证测试。 */
    private void showUCBrowser(String url) {
        Intent intent = new Intent();
        intent.setClassName("com.UCMobile", "com.UCMobile.main.UCMobile");
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse(url));
        //startActivity(intent);
        cordova.getActivity().startActivity(intent);
    }
    
}
