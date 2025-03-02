# ktx01water

A [libGDX](https://libgdx.com/) project generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff).

This project was generated with a template that includes Kotlin application launchers and an empty `ApplicationAdapter` implemented in Kotlin.

## 项目来源

[A Simple Game - libGDX](https://libgdx.com/wiki/start/a-simple-game)

## timeline



### 2025-03-02 14:13:12

- [ ] 快速阅读一下 [Quillraven/SimpleKtxGame](https://github.com/Quillraven/SimpleKtxGame)

### 2025-03-02 13:57:02

参考这个项目 [sample](https://github.com/libktx/ktx-sample-project)，基本结构如此：



```kotlin
class Main : KtxGame<KtxScreen>() {
    override fun create() {
        KtxAsync.initiate()

        addScreen(FirstScreen())
        setScreen<FirstScreen>()
    }
}
```



### 2025-03-02 11:20:49

从 [KTX](https://libktx.github.io/#dependencies-section) 复制在 `core/build/gradle` 下面添加依赖



```groovy
dependencies {
  api "com.badlogicgames.gdx:gdx:$gdxVersion"
  api "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
  // !!! ktx-app:
  api group: 'io.github.libktx', name: 'ktx-app', version: '1.13.1-rc1'
  
  if(enableGraalNative == 'true') {
    implementation "io.github.berstanio:gdx-svmhelper-annotations:$graalHelperVersion"
  }
}
```

根据 gdx-liftoff自带生成发现，可以在 gradle.properties 里面定义变量



```properties
ktxVersion=1.13.1-rc1
```

然后再改为



```groovy
dependencies {
  api "com.badlogicgames.gdx:gdx:$gdxVersion"
  api "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
  // !!! ktx-app:
  api group: 'io.github.libktx', name: 'ktx-app', version: '$ktxVersion'

  if(enableGraalNative == 'true') {
    implementation "io.github.berstanio:gdx-svmhelper-annotations:$graalHelperVersion"
  }
}
```

运行的时候发现要重启项目才会生效，后面发现可以点击重构

<img title="" src="docs/assets/2025-03-02-14-03-55-image.png" alt="" data-align="center" width="332">



### 2025-03-01 21:40:32

项目来源 [A Simple Game - libGDX](https://libgdx.com/wiki/start/a-simple-game)

采用 [gdx-liftoff](https://github.com/libgdx/gdx-liftoff) 生成，模板选择 kotlin，其他为空

环境 intellij

碰到的问题是 openJDK 17 有问题，设置了 java_home 为 ij 里面的jdk

运行桌面版的方式如下

<img title="" src="docs/assets/2025-03-01-21-49-56-image.png" alt="" width="287" data-align="center">~~~~

## Platforms

- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3; was called 'desktop' in older docs.
- `android`: Android mobile platform. Needs Android SDK.

## Gradle

This project uses [Gradle](https://gradle.org/) to manage dependencies.
The Gradle wrapper was included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.
Useful Gradle tasks and flags:

- `--continue`: when using this flag, errors will not stop the tasks from running.
- `--daemon`: thanks to this flag, Gradle daemon will be used to run chosen tasks.
- `--offline`: when using this flag, cached dependency archives will be used.
- `--refresh-dependencies`: this flag forces validation of all dependencies. Useful for snapshot versions.
- `android:lint`: performs Android project validation.
- `build`: builds sources and archives of every project.
- `cleanEclipse`: removes Eclipse project data.
- `cleanIdea`: removes IntelliJ project data.
- `clean`: removes `build` folders, which store compiled classes and built archives.
- `eclipse`: generates Eclipse project data.
- `idea`: generates IntelliJ project data.
- `lwjgl3:jar`: builds application's runnable jar, which can be found at `lwjgl3/build/libs`.
- `lwjgl3:run`: starts the application.
- `test`: runs unit tests (if any).

Note that most tasks that are not specific to a single project can be run with `name:` prefix, where the `name` should be replaced with the ID of a specific project.
For example, `core:clean` removes `build` folder only from the `core` project.
