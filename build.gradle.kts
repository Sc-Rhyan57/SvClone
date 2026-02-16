import com.aliucord.gradle.AliucordExtension
import com.android.build.gradle.BaseExtension

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/snapshots")
        maven("https://maven.aliucord.com/releases")
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("com.aliucord:gradle:main-SNAPSHOT")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/snapshots")
        maven("https://maven.aliucord.com/releases")
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
        updateUrl.set("https://raw.githubusercontent.com/Sc-rhyan57/SvClone/builds/updater.json")
        buildUrl.set("https://raw.githubusercontent.com/Sc-rhyan57/SvClone/builds/%s.zip")
        author("Sc-rhyan57")
        deploy.set(true)
        changeLog.set("""
            v1.0.0 - Lancamento inicial
            - Clonar cargos, canais, emojis, stickers, icone e banner
            - Comando /clone-server
            - Botao Clone Guild na aba do servidor
            - Salvar midia como ZIP
            - Salvar progresso automaticamente
        """.trimIndent())
    }

    android {
        compileSdkVersion(33)
        defaultConfig {
            minSdk = 24
            targetSdk = 33
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }

    repositories {
        google()
        mavenCentral()
        maven("https://maven.aliucord.com/snapshots")
        maven("https://jitpack.io")
    }

    dependencies {
        val discord by configurations
        val compileOnly by configurations

        discord("com.discord:discord:aliucord-SNAPSHOT")
        compileOnly("com.aliucord:Aliucord:main-SNAPSHOT")
    }
}
