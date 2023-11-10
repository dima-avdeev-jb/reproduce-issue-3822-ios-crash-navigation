reproduce issue https://github.com/JetBrains/compose-multiplatform/issues/3822
You need to click multiple times to reproduce this bug

Now problem is fixed with Skiko version 0.7.88 

Take a look at this code block in file [build.gradle.kts](shared%2Fbuild.gradle.kts)
```Kotlin
configurations.all {
    resolutionStrategy {
        force("org.jetbrains.skiko:skiko:0.7.88")
    }
}
```
