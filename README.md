# Android-Social-Utils

## Overview
This project contains the module [SocialUtils](SocialUtils), which is an Android Library. This module contains classes helpful for interfacing with a variety of social providers via their native apps, with fallback options in the absence of a native app.

## Usage
If you’d like to use this library, you can simply include the file [SocialUtils AAR File](SocialUtils/build/outputs/aar) in your app’s `lib` directory, and update your `build.gradle` file with the following dependency:

`compile 'com.hesslerdesign.socialutilities:SocialUtils:1.0@aar'`

You’ll also want to include the following items in your `repositories` tag of your `build.gradle` file to ensure the compile directive above is correctly located:

```
repositories {
    mavenCentral()
    flatDir {
        dirs 'libs'
    }
}
```