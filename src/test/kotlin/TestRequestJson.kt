package lambdaHandler

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

fun main(args: Array<String>) {

	val input = FileInputStream(File("src/test/kotlin/input.json"))
	RequestParameter.parseParameter(input)
	System.out.println("★★★★★★★★★★")
	System.out.println(RequestParameter.getParameter("body"))
}