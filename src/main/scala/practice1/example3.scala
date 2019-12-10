package practice1

object example3 extends App{

  for (_ <- 1 to 10) {
    var x = 0
    val threads = (1 to 100).map(i => new Thread(() => x += 1))
    threads.foreach { t =>
      t.start
      t.join
    }
   // threads.foreach{_.join}

    println(x)
  }


}
