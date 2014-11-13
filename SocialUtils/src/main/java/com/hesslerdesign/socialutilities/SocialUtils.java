package com.hesslerdesign.socialutilities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;

import java.util.List;

public class SocialUtils {

    private static SocialUtils mSocialUtils;

    private SocialUtils() {
        super();
    }

    public static synchronized SocialUtils getInstance() {
        if (mSocialUtils == null) {
            mSocialUtils = new SocialUtils();
        }
        return mSocialUtils;
    }

    /**
     * Method to return an Intent for a given Activity and SocialProvider. This method will inspect
     * all of the passed-in Activity's intent activities, and use it to create an Intent specific to
     * the SocialProvider provided. The Intent will attempt to use the native social app (if found).
     * If the native app is not found, the Intent used will be a simple Intent.ACTION_VIEW, passing
     * the specified data from the SocialProvider object provided.
     *
     * @param activity The Activity requesting the Intent
     * @param socialProvider A SocialProvider object to use in building out the Intent.
     * @return Intent built with SocialProvider-specific data and settings.
     * @link http://stackoverflow.com/questions/7545254/android-and-facebook-share-intent/21189010#21189010
     * @link http://stackoverflow.com/questions/21088250/android-launch-twitter-intent/21088285#21088285
     */
    public Intent getSocialShareIntent(Activity activity, SocialProvider socialProvider) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        // See if official FB app installed and found
        boolean fbAppFound = false;
        boolean twitterAppFound = false;
        List<ResolveInfo> matches = activity.getPackageManager().queryIntentActivities(intent, 0);
        for (ResolveInfo info : matches) {

            // Facebook
            if (info.activityInfo.packageName.toLowerCase().startsWith(socialProvider.getProviderPackageName())) {
                intent.putExtra(Intent.EXTRA_TEXT, socialProvider.getShareIntentUrl());
                intent.setPackage(info.activityInfo.packageName);
                fbAppFound = true;
            }

            // Twitter
            if (info.activityInfo.packageName.toLowerCase().startsWith(socialProvider.getProviderPackageName())) {
                intent.putExtra(Intent.EXTRA_TEXT, socialProvider.getShareIntentExtraText());
                intent.setClassName(info.activityInfo.packageName, info.activityInfo.name);
                twitterAppFound = true;
            }
        }

        // As fallback, launch backup URL in browser via Intent.ACTION_VIEW
        if (socialProvider.getProvider().equals(SocialProvider.FACEBOOK) && !fbAppFound) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(socialProvider.getShareIntentBackupUrl()));
        } else if (socialProvider.getProvider().equals(SocialProvider.TWITTER) && !twitterAppFound) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(socialProvider.getShareIntentBackupUrl()));
        }

        return intent;

    }

}