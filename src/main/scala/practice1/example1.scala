package practice1

object example1 extends App{

  makethread(1)
 def makethread(i:Int):Unit={
   val t = new Thread(()=> println("Hello from thread:"+i))
   if(i==50){

   }
   else
     {

       makethread(i+1)
       t.start
       t.join
     }
 }
}
