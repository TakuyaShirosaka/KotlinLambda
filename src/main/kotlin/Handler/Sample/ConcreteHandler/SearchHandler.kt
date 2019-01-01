package lambdaHandler

import org.json.simple.JSONObject

/*
  Handlerの具体的な実装
 */

class SearchHandler : AbstractHandler() {
	override fun execute(): JSONObject {
		System.out.println("★SearchHandler！★")
		val factory: AbstractDBFactory = AbstractDBFactory.createDBFactory(SampleDBMap, SampleDB_search)
		val executeDBHandler = factory.createDBProduct()

		try {
			responseBody["result"] = executeDBHandler.execute()
		} catch (e: Exception) {
			responseJson["statusCode"] = "400"
			responseJson["body"] = e.printStackTrace()
			return responseJson
		}

		//2.ボディ
		responseJson["body"] = responseBody.toString()

		//3.ステータスコード
		responseJson["statusCode"] = "200"

		return responseJson
	}
}