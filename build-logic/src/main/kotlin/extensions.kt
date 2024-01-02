import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.publish.maven.MavenPomDeveloperSpec
import org.gradle.kotlin.dsl.the

// set by GitHub Actions
val Project.ci: Provider<Boolean>
    get() = providers.environmentVariable("CI")
        .map { it.toBoolean() }
        .orElse(false)

val Project.compileExamples: Boolean
    get() = providers.gradleProperty("compile-examples")
        .isPresent

val Project.libs: LibrariesForLibs
    get() = the()

fun MavenPomDeveloperSpec.city() {
    developer {
        id.set("Sauilitired")
        name.set("Alexander Söderberg")
        url.set("https://alexander-soderberg.com")
        email.set("contact@alexander-soderberg.com")
    }
}

fun MavenPomDeveloperSpec.jmp() {
    developer {
        id.set("jmp")
        name.set("Jason Penilla")
        url.set("https://github.com/jpenilla")
    }
}
