
package me.pengwei.phonegap.plugins;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class OpenInBrowser extends CordovaPlugin {
    
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        
        final JSONObject options = args.getJSONObject(0);
        
        if (action.equals("showQQBrowser")) {
            final String url = options.getString("url");
            showQQBrowser(url);
            return true;
        }
        
        if (action.equals("showUCBrowser")) {
            final String url = options.getString("url");
            showUCBrowser(url);
            return true;
        }


        if (action.equals("isClientAvailable")) {
            final String packageName = options.getString("packageName");
            final boolean res = isClientAvailable(this.cordova.getActivity(), packageName);
            return res;
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
        this.cordova.getActivity().startActivity(intent);
    }
    
    /** 直接启动UC，用于验证测试。 */
    private void showUCBrowser(String url) {
        Intent intent = new Intent();
        intent.setClassName("com.UCMobile", "com.UCMobile.main.UCMobile");
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse(url));
        //startActivity(intent);
        this.cordova.getActivity().startActivity(intent);

    }

    /** 判断安装包是否可用*/
    private boolean isClientAvailable(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
