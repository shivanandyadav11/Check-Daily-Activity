This is a Kotlin Multiplatform project targeting Android, iOS, Web, Desktop, Server.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/server` is for the Ktor server application.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html),
[Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/#compose-multiplatform),
[Kotlin/Wasm](https://kotl.in/wasm/)…

**Note:** Compose/Web is Experimental and may be changed at any time. Use it only for evaluation purposes.
We would appreciate your feedback on Compose/Web and Kotlin/Wasm in the public Slack channel [#compose-web](https://slack-chats.kotlinlang.org/c/compose-web).
If you face any issues, please report them on [GitHub](https://github.com/JetBrains/compose-multiplatform/issues).

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.

# My Application

Welcome to the landing page of My Application.

## Screenshots

| Android | iOS | Desktop |
|:---:|:---:|:---:|
|<img width="398" alt="android_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/d10d82f7-9c03-4a30-95ff-20bd2cbb7943">|<img width="419" alt="iOS_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/d40f1471-22cf-4186-a9ad-7799526390e0">|<img width="627" alt="desktop_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/65a4b707-b4aa-4696-8343-639170f3b2d0">|


| Web |
|:---:|
|<img width="1728" alt="web_landing_page" src="https://github.com/shivanandyadav11/Check-Daily-Activity/assets/26367466/5329365d-1beb-43aa-8846-422b95dbf3bf">|


