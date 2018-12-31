import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `kotlin-dsl`
    `maven-publish`
    kotlin("jvm") version "1.3.10"
    id("com.github.johnrengelman.shadow") version "4.0.3"
}

gradlePlugin {
    plugins {
        register("greet-plugin") {
            id = "greet"
            implementationClass = "GreetPlugin"
        }
    }

    dependencies {
        api("io.ktor:ktor-client-okhttp:1.0.1")
    }
}

val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets.main.get().allSource)
}

val shadowJar: ShadowJar by tasks
shadowJar.apply {
    baseName = "test"
    classifier = ""
    minimize()
}

publishing {

    publications {
        register("mavenJava", MavenPublication::class) {
            artifactId = "test"
            groupId = "com.cdsap"
            version = "0.8"
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}

repositories {
    jcenter()
}
