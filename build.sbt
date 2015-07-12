name := """play-spring-axon"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

dependencyOverrides += "org.scala-lang" % "scala-compiler" % scalaVersion.value

libraryDependencies += "org.springframework" % "spring-context" % "4.1.4.RELEASE"

libraryDependencies += "org.axonframework" % "axon-core" % "2.4.2"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)