package swinds.processor.services

import sttp.client3._
import cats.effect.IO
import sttp.model.Uri

// use webservice of the corresponding model
trait WebService[A] {
 def pull(url: Uri)(implicit backend: SttpBackend[_, _]): IO[A] ={
   basicRequest.get(url)
     .response(asJson[A])
     .send(backend)

 }
}
