package swinds

import cats.effect._
import org.http4s.HttpRoutes
import org.http4s.dsl.impl.Root
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder

object Main extends Greeting with App {
  import scala.concurrent.ExecutionContext.global
  implicit val cs: ContextShift[IO] = IO.contextShift(global)
  implicit val timer: Timer[IO] = IO.timer(global)
  val server = BlazeServerBuilder[IO](global).bindHttp(8080, "localhost").withHttpApp(app).resource

  val app = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name.")
  }.orNotFound

  // sttp client
  //  AsyncHttpClientCatsBackend[IO]().flatMap { backend =>
  //    backend
  //  }
  // We’ll start the server in the background. The IO.never keeps it running until we cancel the fiber.
  val fiber = server.use(_ => IO.never).start.unsafeRunSync()
}

trait Greeting {
  lazy val greeting: String = "hello"
}
