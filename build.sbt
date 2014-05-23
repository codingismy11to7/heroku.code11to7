name := "heroku_code11to7"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
    "org.reactivemongo" %% "reactivemongo" % "0.10.0"
)

libraryDependencies ++= Seq(
  anorm,
  cache
)     

play.Project.playScalaSettings
