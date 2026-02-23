plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    embedded(project(":kotlin-allopen-compiler-plugin")) { isTransitive = false }
}

publish {
    // TODO: Should we use Property.replace {} here?
    artifactId = artifactId.get().replace(".", "-")
}

runtimeJar(rewriteDefaultJarDepsToShadedCompiler())
sourcesJarWithSourcesFromEmbedded(
    project(":kotlin-allopen-compiler-plugin").tasks.named<Jar>("sourcesJar")
)
javadocJarWithJavadocFromEmbedded(
    project(":kotlin-allopen-compiler-plugin").tasks.named<Jar>("javadocJar")
)
