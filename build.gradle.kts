import java.io.ByteArrayOutputStream

plugins {
    java
}

val eaglefactionsApiVersion = findProperty("eaglefactions-api.version") as String
val spongeApiVersion = findProperty("sponge-api.version") as String

group = "io.github.aquerr"
version = "$eaglefactionsApiVersion-API-$spongeApiVersion"

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven")
}

dependencies {
    compileOnly("org.spongepowered:spongeapi:$spongeApiVersion")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
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