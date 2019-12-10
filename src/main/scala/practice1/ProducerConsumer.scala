package practice1

import scala.collection.mutable
import scala.util.Random

object ProducerConsumer extends App {

  val queue = mutable.Queue[Int]()
  val capacity = 3
  var i = 0
  val random = new Random(250)

  val producer = new Thread(() => {
    while (true) {

      queue.synchronized {
        if (queue.size == capacity) {
          println("[Producer] queue is full..waiting ")
          queue.wait()
        }

        println("[Producer] writing value:" + i)
        queue.enqueue(i)
        i += 1
        queue.notify()
      }
      Thread.sleep(200)
    }
  })

  val consumer = new Thread(() => {
    while (true) {
      queue.synchronized {
        if (queue.isEmpty) {
          println("[consumer] queue is empty..waiting")
          queue.wait()
        }

        val result = queue.dequeue()
        println("[consumer] reading value: " + i)
        queue.notify()
      }
      Thread.sleep(250)
    }
  })

  producer.start()
  consumer.start()

}
