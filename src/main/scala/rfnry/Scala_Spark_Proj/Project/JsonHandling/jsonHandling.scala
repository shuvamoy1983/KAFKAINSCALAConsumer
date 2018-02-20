package Project.JsonHandling
import com.google.gson.{Gson, GsonBuilder, JsonParser}

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer
/**
  * Created by shuvamoymondal on 2/19/18.
  */
object jsonHandling {

  case class Dude(firstName: String, lastName: String, age: Int)
  case class TestRecord(val a: String, val b: String, val c: String, val d: List[String])

  def main(args: Array[String]): Unit = {

    //val testRecordAsJson = """{"a":"x","b":"y","c":"z","d":["1","2","3"]}"""
    val gson = new Gson()
    val json_string = scala.io.Source.fromFile("/Users/shuvamoymondal/ScalaTutorial/src/main/scala/rfnry/Scala_Spark_Proj/config/config1.json").getLines.mkString
    val jsonStringAsObject = new JsonParser().parse(json_string).getAsJsonObject
    print(jsonStringAsObject)
    val myObj = gson.fromJson(jsonStringAsObject, classOf[Dude])
    println(myObj.age)

    val json_string1 = scala.io.Source.fromFile("/Users/shuvamoymondal/ScalaTutorial/src/main/scala/rfnry/Scala_Spark_Proj/config/config2.json").getLines.mkString
    val jsonStringAsObject1= new JsonParser().parse(json_string1).getAsJsonObject
    //val ob=gson.fromJson(jsonStringAsObject1, classOf[TestRecord])
    //val myObj1 = gson.fromJson(jsonStringAsObject1.getAsJsonObject(), classOf[TestRecord])
    val a1=jsonStringAsObject1.get("a")
    val b1=jsonStringAsObject1.get("b")
    val c1=jsonStringAsObject1.get("c")
    var d1 = new ListBuffer[String]()
    val p = jsonStringAsObject1.get("d").toString.replace("[\"","").replace("]","").replace("\"","").replace(",","")

    for (i <- p) {
      d1+=i.toString
    }

    val t:TestRecord= TestRecord(a1.toString,b1.toString,c1.toString,d1.toList)
    print(t)

  }

}
