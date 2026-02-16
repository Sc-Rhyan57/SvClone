pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.aliucord.com/snapshots")
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliucord.com/snapshots")
        google()
        mavenCentral()
    }
}

rootProject.name = "SvClone"
include(":SvClone")
