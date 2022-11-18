// CS558 Prof Jingke Li
// Camilo Schaser-Hughes
// November 17, 2022
// some currying functions and playing around with
// functional programming.
object HOfunc {

  def incr(x:Int) = x + 1
  def add(x:Int, y:Int) = x + y
  val addc = currying(add)
  val add3 = addc(3)
  val add4 = compose(incr,add3)
  
  // ... need code ...
  // def currying(f:((Int, Int) => Int)): (Int => Int => Int) = (a:Int) (b:Int) => f(a,b)
  // took a while.  mostly looking up how to curry a function
  // the type definitions helped a lot with this stuff...
  def currying(f:((Int, Int) => Int)): (Int => Int => Int) = (a:Int) => (b:Int) => f(a,b)

  // takes in an f and g and returns a function that will give a f(g(x))
  def compose(f:(Int => Int), g:(Int => Int)): (Int => Int) = (x:Int) => f(g(x))

  // just takes in f and returns a function that does it twice
  def twice(f:(Int => Int)): (Int => Int) = (x:Int) => f(f(x))

  // after struggling with this for a minute, I got some help from 
  // https://stackoverflow.com/questions/51294506/
  // repeat-a-function-n-times-in-scala
  // I tried a recursive function a few times to no avail.
  def power(f:(Int => Int), n:Int): (Int => Int) = { (x:Int) =>
    var res:Int = x
    for (i <- 1 to n) {
      res = f(res)
    }
    res
  }

  // was something added in to figure out currying func.
  // def curry_add(x:Int) = (y:Int) => x + y
  // val add2 = curry_add (2)


  def main(args: Array[String]) = {
    println("We got something going on here...")
    // this one is just a playing around testing...
    // println("add2(1) = " + add2(1) + "   (should be 3)")
    println("add(1,2) = " + add(1,2) + "   (should be 3)")
    println("addc(1)(2) = " + addc(1)(2) + " (should be 3)")
    println("add3(2) = " + add3(2) + "    (should be 5)")
    println("add4(2) = " + add4(2) + "    (should be 6)")
    println("twice(incr)(2) = " + twice(incr)(2) + "   (should be 4)")
    println("power(incr,0)(2) = " + power(incr,0)(2) + " (should be 2)")
    println("power(incr,1)(2) = " + power(incr,1)(2) + " (should be 3)")
    println("power(incr,5)(2) = " + power(incr,5)(2) + " (should be 7)")
  }

}
