import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

object Dependencies {
  val versionOfScala = "2.12.4"

  // Udash
  val udashVersion = "0.6.1"
  val udashJQueryVersion = "1.1.0"

  // Backend
  val avsystemCommonsVersion = "1.25.6"
  val jettyVersion = "9.4.8.v20171121"
  val springVersion = "4.3.13.RELEASE"
  val logbackVersion = "1.2.3"

  // JS dependencies
  val bootstrapVersion = "3.3.7-1"
  val highchartsVersion = "5.0.10"

  // Testing
  val scalatestVersion = "3.0.4"
  val scalamockVersion = "3.6.0"

  // Dependencies for both frontend and backend
  // Those have to be cross-compilable
  val crossDeps = Def.setting(Seq(
    "io.udash" %%% "udash-core-shared" % udashVersion,
    "io.udash" %%% "udash-rpc-shared" % udashVersion,
    "io.udash" %%% "udash-rest-shared" % udashVersion,
    "io.udash" %%% "udash-i18n-shared" % udashVersion,
    "io.udash" %%% "udash-css-shared" % udashVersion,
    "io.udash" %%% "udash-auth-shared" % udashVersion,
  ))

  // Dependencies compiled to JavaScript code
  val frontendDeps = Def.setting(Seq(
    "io.udash" %%% "udash-core-frontend" % udashVersion,
    "io.udash" %%% "udash-rpc-frontend" % udashVersion,
    "io.udash" %%% "udash-i18n-frontend" % udashVersion,
    "io.udash" %%% "udash-css-frontend" % udashVersion,
    "io.udash" %%% "udash-auth-frontend" % udashVersion,

    // type-safe wrapper for Twitter Bootstrap
    "io.udash" %%% "udash-bootstrap" % udashVersion,
    // type-safe wrapper for Highcharts
    "io.udash" %%% "udash-charts" % udashVersion,
    // type-safe wrapper for jQuery
    "io.udash" %%% "udash-jquery" % udashJQueryVersion,

    // Trying scalajs-d3
    "org.singlespaced" %%% "scalajs-d3" % "0.3.4"
  ))

  // JavaScript libraries dependencies
  // Those will be added into frontend-deps.js
  val frontendJSDeps = Def.setting(Seq(
    // "jquery.js" is provided by "udash-jquery" dependency
    "org.webjars" % "bootstrap" % bootstrapVersion /
      "bootstrap.js" minified "bootstrap.min.js" dependsOn "jquery.js",

    // Highcharts JS files
    "org.webjars" % "highcharts" % highchartsVersion /
      s"$highchartsVersion/highcharts.src.js" minified s"$highchartsVersion/highcharts.js" dependsOn "jquery.js",
    "org.webjars" % "highcharts" % highchartsVersion /
      s"$highchartsVersion/highcharts-3d.src.js" minified s"$highchartsVersion/highcharts-3d.js" dependsOn s"$highchartsVersion/highcharts.src.js",
    "org.webjars" % "highcharts" % highchartsVersion /
      s"$highchartsVersion/highcharts-more.src.js" minified s"$highchartsVersion/highcharts-more.js" dependsOn s"$highchartsVersion/highcharts.src.js",
    "org.webjars" % "highcharts" % highchartsVersion /
      s"$highchartsVersion/modules/exporting.src.js" minified s"$highchartsVersion/modules/exporting.js" dependsOn s"$highchartsVersion/highcharts.src.js",
    "org.webjars" % "highcharts" % highchartsVersion /
      s"$highchartsVersion/modules/drilldown.src.js" minified s"$highchartsVersion/modules/drilldown.js" dependsOn s"$highchartsVersion/highcharts.src.js",
    "org.webjars" % "highcharts" % highchartsVersion /
      s"$highchartsVersion/modules/heatmap.src.js" minified s"$highchartsVersion/modules/heatmap.js" dependsOn s"$highchartsVersion/highcharts.src.js",


  ))

  // Dependencies for JVM part of code
  val backendDeps = Def.setting(Seq(
    "io.udash" %% "udash-rpc-backend" % udashVersion,
    "io.udash" %% "udash-rest-backend" % udashVersion,
    "io.udash" %% "udash-i18n-backend" % udashVersion,
    "io.udash" %% "udash-css-backend" % udashVersion,

    "org.eclipse.jetty" % "jetty-server" % jettyVersion,
    "org.eclipse.jetty.websocket" % "websocket-server" % jettyVersion,

    "org.springframework" % "spring-core" % springVersion,
    "org.springframework" % "spring-beans" % springVersion,
    "org.springframework" % "spring-context-support" % springVersion,

    //Twitterstreamingclient  
    "com.danielasfregola" %% "twitter4s" % "5.3",
    // support for HOCON beans configuration
    "com.avsystem.commons" %% "commons-spring" % avsystemCommonsVersion,

    // server logging backend
    "ch.qos.logback" % "logback-classic" % logbackVersion,
  ))

  // Test dependencies
  val crossTestDeps = Def.setting(Seq(
    "org.scalatest" %%% "scalatest" % scalatestVersion,
    "org.scalamock" %%% "scalamock-scalatest-support" % scalamockVersion
  ).map(_ % Test))
}
