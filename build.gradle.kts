import java.io.ByteArrayOutputStream

plugins {
    `java-library`
    `maven-publish`
}

val eaglefactionsApiVersion = findProperty("eaglefactions-api.version") as String
val spongeApiVersion = findProperty("sponge-api.version") as String
val finalVersion = "$eaglefactionsApiVersion-API-$spongeApiVersion"

group = "io.github.aquerr"
version = finalVersion

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven")
}

dependencies {
    compileOnly("org.spongepowered:spongeapi:$spongeApiVersion")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_21.majorVersion))

    withSourcesJar()
    withJavadocJar()
}

tasks.jar {
    archiveBaseName.set("EagleFactionsAPI")
    if(System.getenv("JENKINS_HOME") != null) {
        project.version = finalVersion + "_" + System.getenv("BUILD_NUMBER") + "-SNAPSHOT"
        println("Version => " + project.version.toString())
    } else {
        project.version = "$finalVersion-SNAPSHOT"
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

publishing {
    publications {
        create<MavenPublication>("maven") {

            from(components["java"])

            pom {
                name.set("EagleFactionsAPI")
                artifactId = "eaglefactionsapi"
                description.set(project.description)
                url.set("https://github.com/Aquerr/EagleFactionsAPI")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://github.com/Aquerr/EagleFactionsAPI/blob/api-8/LICENSE")
                    }
                }

                developers {
                    developer {
                        id.set("Aquerr")
                        name.set("Bartłomiej Stępień")
                        url.set("https://github.com/Aquerr")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/Aquerr/EagleFactionsAPI.git")
                    developerConnection.set("scm:git:ssh://github.com/Aquerr/EagleFactionsAPI.git")
                    url.set("https://github.com/Aquerr/EagleFactionsAPI")
                }
            }
        }
    }
}