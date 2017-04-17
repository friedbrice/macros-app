package local

package object macros {

  import argonaut.CodecJson
  import monocle.macros.Lenses

  @Lenses
  case class Particle(position: Point, velocity: Point, mass: Double)
  implicit lazy val particleCodec: CodecJson[Particle] = CodecJson.derive[Particle]

  @Lenses
  case class Point(x: Double, y: Double, z: Double)
  implicit lazy val pointCodec: CodecJson[Point] = CodecJson.derive[Point]
}
