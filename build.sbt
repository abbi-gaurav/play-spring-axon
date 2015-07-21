name := """play-spring-axon"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies += Common.springCoreDependency

libraryDependencies += Common.axonCoreDependency

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

lazy val common = (project in file ("modules/common")).enablePlugins(PlayScala).settings(scalaVersion := "2.11.6")

lazy val aroot = (project in file(".")).enablePlugins(PlayScala).aggregate(common).dependsOn(common)