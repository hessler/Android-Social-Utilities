package com.hesslerdesign.socialutilities;

public class SocialProvider {

    public final static String FACEBOOK = "Facebook";
    public final static String TWITTER = "Twitter";

    public final static String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    public final static String TWITTER_PACKAGE_NAME = "com.twitter.android";

    private String mProvider;
    private String mShareIntentExtraText;
    private String mShareIntentUrl;
    private String mShareIntentBackupUrl;

    public SocialProvider(String provider) {
        setProvider(provider);
    }

    public String getProvider() {
        return mProvider;
    }

    public void setProvider(String provider) {
        mProvider = provider;
    }

    public String getProviderPackageName() {
        if (mProvider.equals(FACEBOOK)) {
            return FACEBOOK_PACKAGE_NAME;
        } else if (mProvider.equals(TWITTER)) {
            return TWITTER_PACKAGE_NAME;
        } else {
            return null;
        }
    }

    public String getShareIntentExtraText() {
        return mShareIntentExtraText;
    }

    public void setShareIntentExtraText(String value) {
        mShareIntentExtraText = value;
    }

    public String getShareIntentUrl() {
        return mShareIntentUrl;
    }

    public void setShareIntentUrl(String url) {
        mShareIntentUrl = url;
    }

    public String getShareIntentBackupUrl() {
        return mShareIntentBackupUrl;
    }

    public void setShareIntentBackupUrl(String url) {
        mShareIntentBackupUrl = url;
    }

    @Override
    public String toString() {
        return "{SocialProvider: provider = " + mProvider + "; providerPackageName = " + getProviderPackageName() + "; shareIntentExtraText = " + mShareIntentExtraText + "; shareIntentUrl = " + mShareIntentUrl + "; shareIntentBackupUrl = " + mShareIntentBackupUrl + "}";
    }

}
