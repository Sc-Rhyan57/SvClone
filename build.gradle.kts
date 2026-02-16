import com.aliucord.gradle.AliucordExtension
import com.android.build.gradle.BaseExtension

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/snapshots")
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.3.0")
        classpath("com.aliucord:gradle:main-SNAPSHOT")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/snapshots")
        maven("https://jitpack.io")
    }
}

fun Project.aliucord(configuration: AliucordExtension.() -> Unit) =
    extensions.getByName<AliucordExtension>("aliucord").configuration()

fun Project.android(configuration: BaseExtension.() -> Unit) =
    extensions.getByName<BaseExtension>("android").configuration()

subprojects {
    apply(plugin = "com.android.library")
    apply(plugin = "com.aliucord.gradle")
    apply(plugin = "kotlin-android")

    aliucord {
        author("Sc-rhyan57", 896604349311115304L)
        updateUrl.set("https://raw.githubusercontent.com/Sc-rhyan57/SvClone/builds/updater.json")
        buildUrl.set("https://raw.githubusercontent.com/Sc-rhyan57/SvClone/builds/%s.zip")
    }

    android {
        compileSdkVersion(34)
        defaultConfig {
            minSdk = 24
            targetSdk = 34
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    dependencies {
        val discord by configurations
        val compileOnly by configurations

        discord("com.discord:discord:aliucord-SNAPSHOT")
        compileOnly("com.aliucord:Aliucord:main-SNAPSHOT")
    }
}
