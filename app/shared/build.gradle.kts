plugins {
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.7.10"
}

kotlin {
    android()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Kotlinx
                with(Dependencies.Kotlinx) {
                    implementation(coroutines)
                }

                // Ktor
                with(Dependencies.Ktor) {
                    implementation(core)
                    implementation(contentNegotiation)
                    implementation(json)
                }

                // Ballast
                with(Dependencies.Ballast) {
                    implementation(core)
                    implementation(navigation)
                }

                // Compose
                with(compose) {
                    implementation(ui)
                    implementation(foundation)
                    implementation(material)
                    implementation(runtime)
                    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                    implementation(components.resources)
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                // Ktor
                with(Dependencies.Ktor) {
                    implementation(cio)
                }

                // Coil
                with(Dependencies.Coil) {
                    implementation(compose)
                }
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                // Ktor
                with(Dependencies.Ktor) {
                    implementation(darwin)
                }
            }

            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

// MARK: - Android -

android {
    namespace = "io.github.tscholze.cmpsample"
    compileSdk = 33
    defaultConfig {
        minSdk = 29
        targetSdk = 33
    }

    sourceSets["main"].resources.setSrcDirs(
        listOf(
            "src/androidMain/resources",
            "src/commonMain/resources"
        )
    )
}

// MARK: - Dependencies -

/**
 * Contains all gradle dependencies.
 *
 * Usage:
 * ```
 *     with(Dependencies.Kotlinx) {
 *         implement(coroutines)
 *     }
 * ```
 */
object Dependencies {
    object Kotlinx {
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.kotlinxVersion}"
    }

    object Ktor {
        const val core = "io.ktor:ktor-client-core:${Versions.Ktor.ktorVersion}"
        const val cio = "io.ktor:ktor-client-cio:${Versions.Ktor.ktorVersion}"
        const val contentNegotiation =
            "io.ktor:ktor-client-content-negotiation:${Versions.Ktor.ktorVersion}"
        const val json = "io.ktor:ktor-serialization-kotlinx-json:${Versions.Ktor.ktorVersion}"
        const val darwin = "io.ktor:ktor-client-darwin:${Versions.Ktor.ktorVersion}"
    }

    object Ballast {
        const val core = "io.github.copper-leaf:ballast-core:${Versions.Ballast.ballastVersion}"
        const val navigation =
            "io.github.copper-leaf:ballast-navigation:${Versions.Ballast.ballastVersion}"
    }

    object Coil {
        const val compose = "io.coil-kt:coil-compose:${Versions.Coil.coilVersion}"
    }

    // MARK: - Versions -
    private object Versions {
        object Ktor {
            const val ktorVersion = "2.1.3"
        }

        object Kotlinx {
            const val kotlinxVersion = "1.6.4"
        }

        object Ballast {
            const val ballastVersion = "2.3.0"
        }

        object Coil {
            const val coilVersion = "2.2.2"
        }
    }
}

