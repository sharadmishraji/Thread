package practice1

object example2 extends App{


  var msg = ""

  val t1 = new Thread(()=>{
    Thread.sleep(1000)
    msg = "scala is awesome"
  })
  msg = "scala sucks"
  t1.start()
  Thread.sleep(2000)

  println(msg)

}
