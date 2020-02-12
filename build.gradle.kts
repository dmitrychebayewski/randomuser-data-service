import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
}

group = "com.minskrotterdam.randomuser"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("io.springfox:springfox-swagger2:2.9.2")
	implementation("io.springfox:springfox-swagger-ui:2.9.2")
	testImplementation("io.cucumber:cucumber-java8:5.2.0")
	testImplementation("io.cucumber:cucumber-junit:5.2.0")
	testImplementation("io.cucumber:cucumber-spring:5.2.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

}
extra["slf4j.version"] = "1.7.20"

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
val testImplementation = configurations.getByName("testImplementation")
configurations.create("cucumberRuntime").extendsFrom(testImplementation)

tasks.register("cucumber") {
	dependsOn(":assemble")
	dependsOn(":compileTestJava")
	doLast {
		javaexec {
			main = "io.cucumber.core.cli.Main"
			classpath = configurations.getByName("cucumberRuntime") + sourceSets.named("main").get().output + sourceSets.named("test").get().output
			args = listOf("--plugin", "progress",  "--plugin", "junit:build/cucumber-junit-report/junit.xml", "--plugin", "html:build/cucumber-html-report", "--glue", "com.minskrotterdam.randomuser", "src/test/resources")
		}
	}
}
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
	launchScript()
}

