package local.macros

import funutil._

object Main extends App {

  import com.cj.serialization.json._

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
    parseJson[Particle](raw).getOrThrow

  val newParticle: Particle =
    Particle.position ~ Point.x modify {_ + 2} $ particle

  val newRaw: String =
    prettyJson(newParticle)

  println(newRaw)
}
