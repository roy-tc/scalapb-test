

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "scalapb-test",
    libraryDependencies += Dependencies.scalaTest,
    PB.targets in Compile := Seq(
      scalapb.gen() -> (sourceManaged in Compile).value / "scalapb"
    ),
    Project.inConfig(Test)(sbtprotoc.ProtocPlugin.protobufConfigSettings),
    PB.targets in Test := Seq(
      scalapb.gen() -> (sourceManaged in Test).value / "scalapb"
    ),
    PB.protoSources in Test := Seq(/*file("src/main/protobuf"), */file("src/test/protobuf"))
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
