# XLog

![Platform](https://img.shields.io/badge/platform-Android-blue.svg)  ![Release](https://img.shields.io/badge/release-1.0-blue.svg)  ![Gradle](https://img.shields.io/badge/gradle-3.5.3-blue.svg)
=====

Description
=====
A simple Android Log library

Usage
=====

Step 1.Add the JitPack repository to your build file, add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
	}
}
```
Step 2. Add the dependency

```
dependencies {
	implementation 'com.github.YangKangLi:XLog:1.0'
}
```
Step 3. Initial XLog in onCreate method of Application, like below:
```
public class XXXApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initXLog();
    }


    /**
     * Initial XLog
     */
    private void initXLog() {

        // Create a console strategy
        BaseLogStrategy consoleStrategy = new DefaultLogStrategy.Builder().setShowThreadName(true).build();
        ILogAdapter consoleAdapter = new ConsoleAdapter.Builder().setLoggable(BuildConfig.DEBUG).setLogStrategy(consoleStrategy).build();

        // Create a disk strategy
        BaseLogStrategy diskStrategy = new DefaultLogStrategy.Builder().setShowThreadName(true).build();
        File logsPath = getExternalFilesDir("Logs");
        ILogAdapter diskAdapter = new DiskAdapter.Builder().setLoggable(BuildConfig.DEBUG).setLogFilePath(logsPath)
                .setLogStrategy(diskStrategy).build();

        // Initial XLog
        XLog.init(consoleAdapter, diskAdapter);
    }
}
```
Step 4. Call XLog methods to print logs, there some ways :
1) XLog.i/d/w/e/a("some text you want to print");
2) XLog.json() 
3) XLog.xml()