object HOfunc {

  def incr(x:Int) = x + 1
  def add(x:Int, y:Int) = x + y
  val addc = currying(add)
  val add3 = addc(3)
  val add4 = compose(incr,add3)
  
  // ... need code ...
  // def currying(f:((Int, Int) => Int)): (Int => Int => Int) = (a:Int) (b:Int) => f(a,b)
  def currying(f:((Int, Int) => Int)): (Int => Int => Int) = (a:Int) => (b:Int) => f(a,b)

  def compose(a:(Int => Int), b:(Int => Int))

  def curry_add(x:Int) = (y:Int) => x + y

  val add2 = curry_add (2)


  def main(args: Array[String]) = {
    println("We got something going on here...")
    // this one is just a playing around testing...
    // println("add2(1) = " + add2(1) + "   (should be 3)")
    println("add(1,2) = " + add(1,2) + "   (should be 3)")
    println("addc(1)(2) = " + addc(1)(2) + " (should be 3)")
    println("add3(2) = " + add3(2) + "    (should be 5)")
    // println("add4(2) = " + add4(2) + "    (should be 6)")
    // println("twice(incr)(2) = " + twice(incr)(2) + "   (should be 4)")
    // println("power(incr,0)(2) = " + power(incr,0)(2) + " (should be 2)")
    // println("power(incr,1)(2) = " + power(incr,1)(2) + " (should be 3)")
    // println("power(incr,5)(2) = " + power(incr,5)(2) + " (should be 7)")
  }

}
