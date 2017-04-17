package local.macros

package object argonaut_wrapper {

  import argonaut.{CodecJson, Json, Parse}

  def printJson[A: CodecJson](a: A): String =
    toJson[A](a).nospaces

  def prettyJson[A: CodecJson](a: A): String =
    toJson[A](a).spaces2

  def parseJson[A: CodecJson](raw: String): Option[A] =
    Parse.parse(raw).fold[Option[A]](_ => None, json => fromJson[A](json))

  def toJson[A: CodecJson](a: A): Json =
    implicitly[CodecJson[A]].encode(a)

  def fromJson[A: CodecJson](json: Json): Option[A] =
    implicitly[CodecJson[A]].decodeJson(json).toOption
}
