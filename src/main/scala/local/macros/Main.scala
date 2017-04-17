package local.macros

object Main extends App {

  import funutil._
  import argonaut_wrapper._

  val raw: String =
    """{
      |  "position" : {
      |    "x" : 3,
      |    "y" : 2,
      |    "z" : 1
      |  },
      |  "velocity" : {
      |    "x" : 1,
      |    "y" : 0,
      |    "z" : 0
      |  },
      |  "mass" : 0
      |}""".stripMargin

  val particle: Particle =
    parseJson[Particle](raw)(particleCodec).get

  val newParticle: Particle =
    Particle.position ~ Point.x modify {_ + 2} $ particle

  val newRaw: String =
    prettyJson(newParticle)(particleCodec)

  println(newRaw)
}
