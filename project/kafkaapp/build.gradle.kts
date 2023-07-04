import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
}

group = "com.kanekotic.kafkaapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.apache.kafka:kafka-streams:3.5.0")
    implementation("org.apache.kafka:kafka-streams-test-utils:3.5.0")
    implementation("com.nfeld.jsonpathkt:jsonpathkt:2.0.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("com.kanekotic.kafkaapp.MainKt")
}