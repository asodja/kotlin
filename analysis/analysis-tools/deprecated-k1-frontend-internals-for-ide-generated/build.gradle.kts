plugins {
    java
}

dependencies {
    implementation(intellijRuntimeAnnotations())
}

project.configureJvmToolchain(JdkMajorVersion.JDK_17_0)

tasks.withType<JavaCompile> {
    // deprecating a package is a `@Deprecated annotation has no effect on packages` warning in Java,
    // but we need to deprecate it for a 3rd party plugin compatibility checker
    val compilerArgs = options.compilerArgs.get().toMutableList()
    compilerArgs.remove("-Werror")
    options.compilerArgs = compilerArgs
    targetCompatibility = "1.8"
    sourceCompatibility = "1.8"
}


sourceSets {
    "main" { generatedDir() }
    "test" { none() }
}
