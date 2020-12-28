import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.swinds"
ThisBuild / organizationName := "swinds"

val http4sVersion = "0.21.14"

lazy val root = (project in file("."))
  .settings(
    name := "redditsentiments",
    resolvers += Resolver.sonatypeRepo("releases"),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.1.1",
      "org.typelevel" %% "cats-effect" % "2.3.1",
      "org.typelevel" %% "cats-effect-laws" % "2.3.1" % "test",
      "com.softwaremill.sttp.client3" %% "async-http-client-backend-cats" % "3.0.0-RC13",
      "org.tpolecat" %% "doobie-core"      % "0.9.0",
      "org.tpolecat" %% "doobie-specs2"    % "0.9.0" % "test",
      "org.tpolecat" %% "doobie-scalatest" % "0.9.0" % "test",
      "org.tpolecat" %% "doobie-postgres"  % "0.9.0",
      "com.softwaremill.sttp.client3" %% "core" % "3.0.0-RC13",
      "com.softwaremill.sttp.client3" %% "circe" % "3.0.0-RC13",
      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.http4s" %% "http4s-blaze-server" % http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % http4sVersion
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
