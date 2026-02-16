#!/bin/sh
APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`
APP_HOME=`dirname "$0"`
APP_HOME=`cd "$APP_HOME" && pwd`
CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

JAVA_OPTS=""
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

set_up_local_gradle_wrapper () {
    GRADLE_WRAPPER_JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
    if [ ! -f "$GRADLE_WRAPPER_JAR" ]; then
        echo "Downloading gradle-wrapper.jar..."
        curl -sL "https://raw.githubusercontent.com/gradle/gradle/v8.2.0/gradle/wrapper/gradle-wrapper.jar" -o "$GRADLE_WRAPPER_JAR"
    fi
}

set_up_local_gradle_wrapper

exec java $JAVA_OPTS $DEFAULT_JVM_OPTS -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
