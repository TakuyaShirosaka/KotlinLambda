package lambdaHandler

import org.json.simple.JSONObject

/*
  Handlerの共通インターフェース
 */

abstract class AbstractHandler {

	val responseHeader: JSONObject = JSONObject()
	val responseBody: JSONObject = JSONObject()
	val responseJson: JSONObject = JSONObject()

	init {
		//ヘッダー
		responseHeader["Content-Type"] = "application/json"
		responseHeader["Access-Control-Allow-Origin"] = "*"
		responseHeader["Access-Control-Allow-Headers"] =
				"Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token"
		responseHeader["Access-Control-Allow-Credentials"] = "true"
		responseJson["headers"] = responseHeader
	}

	abstract fun execute():JSONObject
}