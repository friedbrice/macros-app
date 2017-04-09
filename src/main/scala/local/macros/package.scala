package local

package object macros {

  import monocle.macros.Lenses
  import play.api.libs.json.{Json, Format}

  @Lenses case class Particle(position: Point, velocity: Point, mass: Double)
  implicit def particleFormat: Format[Particle] = Json.format[Particle]

  @Lenses case class Point(x: Double, y: Double, z: Double)
  implicit def pointFormat: Format[Point] = Json.format[Point]
}
