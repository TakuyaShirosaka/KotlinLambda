package lambdaHandler

import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/*
 lambdaのinputパラメータを一括で管理
 object宣言しているRequestParameterをparseParameterで初期化し、その後はstaticなデータの集まりとして扱う
 */

object RequestParameter {

	private val inputJSON: JSONObject = JSONObject()

	fun parseParameter(input: InputStream) {

		val parser = JSONParser()
		val reader = BufferedReader(InputStreamReader(input))
		val event: JSONObject = parser.parse(reader) as JSONObject
		val json: JSONObject = event

		inputJSON["body"] = json["body"]
		inputJSON["resource"] = json["resource"]
		inputJSON["path"] = json["path"]
		inputJSON["httpMethod"] = json["httpMethod"]
		inputJSON["isBase64Encoded"] = json["isBase64Encoded"]
		inputJSON["queryStringParameters"] = json["queryStringParameters"]
		inputJSON["pathParameters"] = json["pathParameters"]
		inputJSON["stageVariables"] = json["stageVariables"]
		inputJSON["headers"] = json["headers"]
		inputJSON["requestContext"] = json["requestContext"]

		show()

	}

	//中身の参照
	private fun show() {
		for (item in RequestParameter.inputJSON) {
			System.out.println("item:$item")
		}
	}

	fun getParameter(key:String):JSONObject{
		val json:JSONObject = RequestParameter.inputJSON
		return json[key] as JSONObject
	}
}
