import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.merrylab.example"
version = "1.0-SNAPSHOT"

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.10"
    var springBootVersion: String by extra
    springBootVersion = "2.0.0.RELEASE"
    repositories {
        mavenCentral()
    }
    
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath(kotlinModule("gradle-plugin", kotlin_version))
        classpath(kotlinModule("allopen", kotlin_version))
    }
    
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
    plugin("idea")
}

val kotlin_version: String by extra
val springBootVersion: String by extra

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlinModule("stdlib-jdk8", kotlin_version))
    compile("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    testCompile("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

