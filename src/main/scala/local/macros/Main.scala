package local.macros

import funutil._

object Main extends App {

  import play.api.libs.json.Json

  val rawJsonParticle: String =
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
    Json.parse(rawJsonParticle).as[Particle]

  val newParticle: Particle =
    Particle.position ~ Point.x modify {_ + 2} $ particle

  println(Json.prettyPrint(Json.toJson(newParticle)))
}
