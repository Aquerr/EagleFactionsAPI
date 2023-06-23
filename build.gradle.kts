import net.minecraftforge.gradle.userdev.UserDevExtension
import java.io.ByteArrayOutputStream

plugins {
    java
    id("net.minecraftforge.gradle") version "5.1.+"
}

val eaglefactionsApiVersion = findProperty("eaglefactions-api.version") as String
val minecraftVersion = findProperty("minecraft.version") as String
val forgeVersion = findProperty("forge.version") as String

group = "io.github.aquerr"
version = "$eaglefactionsApiVersion-API-$minecraftVersion"

repositories {
    mavenCentral()
}

dependencies {
    minecraft("net.minecraftforge:forge:${forgeVersion}")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

tasks.withType(Jar::class).configureEach {
    if(System.getenv("JENKINS_HOME") != null) {
        archiveVersion.set(project.version.toString() + "_" + System.getenv("BUILD_NUMBER") + "-SNAPSHOT")
        println("Version => " + project.version.toString())
    } else {
        archiveVersion.set(project.version.toString() + "-SNAPSHOT")
    }
}

tasks.withType(JavaCompile::class).configureEach {
    options.apply {
        encoding = "utf-8" // Consistent source file encoding
    }
}

val getGitCommitDesc by tasks.registering(Exec::class) {
    commandLine("git", "log", "-1", "--pretty=%B")
    standardOutput = ByteArrayOutputStream()
    doLast {
        project.extra["gitCommitDesc"] = standardOutput.toString()
    }
}

tasks.register("printEnvironment") {
    doLast {
        System.getenv().forEach { key, value ->
            println("$key -> $value")
        }
    }
}

tasks.register("publishBuildOnDiscord") {
    dependsOn(getGitCommitDesc)
    group = "Publishing"
    description = "Task for publishing the jar file to discord's jenkins channel"
    doLast {
        val jarFiles: List<String> = groovy.ant.FileNameFinder().getFileNames(project.buildDir.path, "**/*.jar")

        if(jarFiles.size > 0) {
            println("Found jar files: " + jarFiles)

            var lastCommitDescription = project.extra["gitCommitDesc"]
            if(lastCommitDescription == null || lastCommitDescription == "") {
                lastCommitDescription = "No changelog provided"
            }

            exec {
                commandLine("java", "-jar", ".." + File.separator + "jenkinsdiscordbot-1.0.jar", "EagleFactionsAPI", jarFiles[0], lastCommitDescription)
            }
        }
    }
}

configure<UserDevExtension> {
    mappings("official", minecraftVersion)
}