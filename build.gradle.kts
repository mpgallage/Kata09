plugins {
    id("java")
}

group = "com.malakagallage"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.xerial:sqlite-jdbc:3.41.2.2")
}

tasks.test {
    useJUnitPlatform()
}