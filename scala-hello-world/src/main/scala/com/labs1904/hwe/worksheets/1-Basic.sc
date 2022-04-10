/*
   * Val vs Var
   */
val immutableInt = 5

var mutableInt = 5
mutableInt += 1

/*
 * Types
 */

var x = 5
var y: Int = 5

def helloTo(name: String): Unit = println("hello " + name)
helloTo("World")

var i = 40272.toString
//var reversed_i = i.toString.reverse

for (ch <- 1 until i.length){
  println(i.substring(0, i.length - (ch+1)) + i.charAt(i.length-ch) + i.charAt(i.length-(ch+1)))
}
