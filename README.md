# Hytale Plugin Template

A ready-to-use starting point for creating Hytale server plugins with Java, _or Kotlin_. If you've
been using the Asset Editor and want to start writing server-side logic — custom commands, event
handling, gameplay systems — this is the simplest place to begin.

This template uses the [Hytale Gradle Plugin](https://github.com/AzureDoom/Hytale-Gradle-Plugin),
a Gradle plugin maintained by AzureDoom for Hytale mod/plugin development. It handles the repetitive
project setup work for you, including manifest generation, validation, local server runs, IDE source
setup, and optional hosted Hytale Javadoc injection.

## How to start

1. Copy the template by downloading it or using the **Use this template** button.
2. [Configure or install the Java SDK](https://hytalemodding.dev/en/docs/guides/plugin/setting-up-env)
   to use Java 25. JetBrains Runtime is recommended for the best hot-reload/debugging experience.
3. Open the project in your favorite IDE. We recommend
   [IntelliJ IDEA](https://www.jetbrains.com/idea/download).
4. Update the project values in `gradle.properties`:
    - `rootProject.name` in `settings.gradle.kts`
    - `group`
    - `manifest_group`
    - `mod_name`
    - `mod_id`
    - `main_class`
    - `mod_author`
    - `mod_description`
    - `mod_url`
5. Optionally run `./gradlew` if your IDE does not automatically sync the project.
6. Prepare the Hytale development environment:

   ```bash
   ./gradlew setupHytaleDev
   ```

7. Run the local development server:

   ```bash
   ./gradlew runServer
   ```

> On Windows, use `./gradlew.bat` or `gradlew.bat` instead of `./gradlew`. The Gradle wrapper is
> included so you do not need to install Gradle separately; only Java is required.

When the server starts, the output may prompt you to authorize your Hytale server. After that, you
can begin developing your plugin while the server handles local development runs.

From here, the [HytaleModding guides](https://hytalemodding.dev/en/docs/guides/plugin/build-and-test)
cover more details.

## Hytale Gradle Plugin

This template is built around AzureDoom's `com.azuredoom.hytale-tools` Gradle plugin.

The plugin is configured in `build.gradle.kts`:

```kotlin
plugins {
    idea
    java
    id("com.azuredoom.hytale-tools") version "1.+"
}
```

The AzureDoom Maven repository is configured in `settings.gradle.kts`:

```kotlin
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven {
            name = "AzureDoom Maven"
            url = uri("https://maven.azuredoom.com/mods")
        }
    }
}
```

Most plugin-specific settings are controlled from `gradle.properties` and passed into the
`hytaleTools` block in `build.gradle.kts`. This keeps common project metadata in one easy-to-edit
place.

For full plugin documentation, configuration options, tasks, and multi-project setup, visit the
[Hytale Gradle Plugin repository](https://github.com/AzureDoom/Hytale-Gradle-Plugin).

## Useful commands

```bash
# Sync/setup the local Hytale development environment
./gradlew setupHytaleDev

# Run the local Hytale server
./gradlew runServer

# Run the server with debugging and hot swap enabled
./gradlew runServer -Ddebug=true -Dhotswap=true

# Check your JVM and hot swap setup
./gradlew hytaleJvmDoctor

# Build the plugin
./gradlew build

# Refresh dependencies if something fails to resolve
./gradlew build --refresh-dependencies
```

## Project structure

```text
src/main/java/        Plugin source code
src/main/resources/   Plugin resources, including manifest.json
gradle.properties     Main template configuration
build.gradle.kts      Gradle build and Hytale Gradle Plugin configuration
settings.gradle.kts   Plugin repositories and project name
```

## Manifest configuration

The generated `manifest.json` is driven by the values in `gradle.properties`, including:

- `manifest_group`
- `mod_id`
- `version`
- `mod_description`
- `mod_author`
- `mod_url`
- `main_class`
- `manifest_dependencies`
- `manifest_opt_dependencies`
- `manifestServerVersion`

After changing these values, run:

```bash
./gradlew updatePluginManifest
```

## Troubleshooting

- **Gradle sync fails in IntelliJ** — Check that Java 25 is installed and configured under
  **File → Project Structure → SDKs**.
- **The Hytale Gradle Plugin does not resolve** — Make sure `settings.gradle.kts` includes the
  AzureDoom Maven repository at `https://maven.azuredoom.com/mods`.
- **Build fails with missing dependencies** — Run `./gradlew build --refresh-dependencies` and make
  sure you have internet access.
- **Permission denied on `./gradlew`** — Run `chmod +x gradlew` on macOS/Linux.
- **Hot reload or enhanced class redefinition does not work** — Use JetBrains Runtime and try
  `./gradlew hytaleJvmDoctor` to verify your JVM setup.

## Resources

- [Hytale Gradle Plugin](https://github.com/AzureDoom/Hytale-Gradle-Plugin)
- [Hytale Modding Guides](https://hytalemodding.dev)
- [Hytale Modding Discord](https://discord.gg/hytalemodding)

## License

Add your own license after copying the template. We recommend MIT, BSD, or Apache to keep the
modding community open.
