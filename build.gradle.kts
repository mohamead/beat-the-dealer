plugins {
    java
}

group = "com.github.mohamead"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // Implementation
    implementation("info.picocli:picocli:4.6.3")
    implementation("org.jetbrains:annotations:20.1.0")
    // Test Implementation
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

/*
 * Executable Jar File Assembly.
 */
val fatJar by tasks.creating(Jar::class) {
    archiveBaseName.set(rootProject.name)
    isZip64 = true
    manifest {
        attributes["Implementation-Title"] = rootProject.name
        attributes["Implementation-Version"] = rootProject.version
        attributes["Main-Class"] = "com.github.mohamead.CliApp"
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    exclude("META-INF/*.SF", "META-INF/*.DSA", "META-INF/*.RSA")
    with(tasks.jar.get() as CopySpec)
    dependsOn(tasks.jar)
}
