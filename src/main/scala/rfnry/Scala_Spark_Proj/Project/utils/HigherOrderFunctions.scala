package Project.utils

import Project.utils.AllFunctions.{LOG, logBuilder}
import org.apache.log4j._

/**
  * Created by shuvamoymondal on 1/14/18.
  */
object HigherOrderFunctions {

  val LOG: Logger = Logger.getLogger("App")
  LOG.setLevel(Level.INFO)
  Logger.getLogger("org").setLevel(Level.ERROR)
  val logBuilder = new StringBuilder()

  LOG.info("implementation of Higher order function")
  logBuilder.append("Review how to define function with curried parameter groups " +
    "Currying is the technique of transforming a function with multiple arguments into a function with just one argument. ")

  def totalCost(donutType: String)(quantity: Int)(discount: Double): Double = {
    println(s"Calculating total cost for $quantity $donutType with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }
    //How to define a higher order function which takes another function as parameter
  LOG.info("How to define a higher order function which takes another function as parameter")

  def totalCostWithDiscountFunctionParameter(donutType: String)(quantity: Int)(f: Double => Double): Double = {
    println(s"Calculating total cost for $quantity $donutType")
    val totalcost = 2.50 * quantity
    f(totalcost)
  }

  def test(a: Double): Double ={
    val p = a + 1
    p
  }


  //How to define a function to loop through each Tuple3 elements of the List and calculate total cost

  def placeOrder(order: List[(String,Int,Double)])(Rate: Double) : Double ={
    var totalCost: Double = 0.0
    order.foreach(Cost =>
    {
      val total =Cost._2 * Cost._3 * Rate
      totalCost+=total
    })
    totalCost
  }

  //In this tutorial, we will learn how to create
  // Higher Order Function which is a function that takes another function as its parameter.
 //How to define a function with an Option callback

  def finalReport(printReport :Option[() => Unit]= None) {
    println("Looking for data")
    println("Done")
    printReport.map(callback => callback())

  }


}
