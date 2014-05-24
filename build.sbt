name := "heroku_code11to7"

version := "1.0-SNAPSHOT"

resolvers ++= Seq(
    "Sonatype snapshots repository" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= Seq(
    "org.pac4j" % "play-pac4j_scala" % "1.2.1-SNAPSHOT",
    "org.pac4j" % "pac4j-oauth" % "1.5.1",
    "org.reactivemongo" %% "play2-reactivemongo" % "0.10.2",
    "com.google.api-client" % "google-api-client" % "1.18.0-rc"
)

libraryDependencies ++= Seq(
  anorm,
  cache
)     

play.Project.playScalaSettings

coffeescriptOptions := Seq("bare")

requireJs += "main.js"

requireJsShim += "main.js"
