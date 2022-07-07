ThisBuild / scalaVersion := "2.12.10"
ThisBuild / organization := "com.example"

lazy val hello = (project in file("."))
  .settings(
    name := "Hello"
  )


import sbt._
import complete.DefaultParsers._

// without it would be "error: not found: type Parser"
import complete.Parser

// without 'literal' would be "error: value | is not a member of String"
val color: Parser[String] = literal("blue") | literal("green")

val select: Parser[String] = literal("fg") | literal("bg")

// error: type mismatch;
//     found   : sbt.internal.util.complete.Parser[((String, Char), String)]
//     required: sbt.complete.Parser[(String, Char, String)]
//         (which expands to)  sbt.internal.util.complete.Parser[(String, Char, String)]
val setColor: Parser[(String, Char, String)] = select ~ ' ' ~ color
