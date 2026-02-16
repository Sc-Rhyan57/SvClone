plugins {
    id("com.aliucord.gradle")
    id("com.android.library")
    kotlin("android")
}

version = "1.0.0"
description = "Clona servidores Discord direto do celular. Baseado em https://bettercloner.vercel.app"

aliucord {
    author("rhyan57")
    updateUrl.set("https://raw.githubusercontent.com/rhyan57/SvClone/builds/updater.json")
    buildUrl.set("https://raw.githubusercontent.com/rhyan57/SvClone/builds/%s.zip")
    changeLog.set("""
        v1.0.0 - Lancamento inicial
        - Clonar cargos, canais, emojis, stickers, icone e banner
        - Comando /clone-server
        - Botao Clone Guild na aba do servidor
        - Salvar midia como ZIP
        - Salvar progresso automaticamente
    """.trimIndent())
    deploy.set(true)
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
}
