description = "Kotlin DSL Script Importing support"

plugins {
    kotlin("jvm")
    id("jps-compatible")
}

jvmTarget = "1.6"

dependencies {
    implementation(kotlinStdlib())
    implementation(project(":idea"))
    implementation(project(":compiler:psi"))
    implementation(project(":idea:idea-core"))
    implementation(project(":idea:idea-jvm"))
    implementation(project(":idea:idea-native"))
    implementation(project(":idea:kotlin-gradle-tooling"))

    implementation(project(":core:util.runtime"))

    compileOnly(intellijDep())
    compileOnly(intellijPluginDep("gradle"))
    compileOnly(intellijCoreDep()) { includeJars("intellij-core", rootProject = rootProject) }

    Platform[193].orLower {
        implementation(project(":idea:idea-gradle-tooling-api"))
    }

    Platform[192].orHigher {
        compileOnly(intellijPluginDep("java"))
    }

}

sourceSets {
    "main" { projectDefault() }
    "test" { }
}