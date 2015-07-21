name := """play-spring-axon"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies += "org.springframework" % "spring-context" % "4.1.4.RELEASE"

libraryDependencies += "org.axonframework" % "axon-core" % "2.4.2"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

lazy val common = (project in file ("modules/common")).enablePlugins(PlayScala).settings(scalaVersion := "2.11.6")

lazy val aroot = (project in file(".")).enablePlugins(PlayScala).aggregate(common).dependsOn(common)