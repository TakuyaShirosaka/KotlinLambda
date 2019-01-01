package lambdaHandler

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter

/*
	全ての処理の起点となるHandler
	AbstractFactoryに実際に実行するオブジェクトの選定を移譲する
 	Lambdaの入り口と出口になる
*/

class BaseHandler : RequestStreamHandler {
	override fun handleRequest(inputStream: InputStream, outputStream: OutputStream, context: Context) {

		val logger: LambdaLogger = context.logger
		logger.log("Loading Kotlin Lambda handler of BaseHandler")

		RequestParameter.parseParameter(inputStream)

		val factory: AbstractFactory = AbstractFactory.createFactory()
		val executeHandler = factory.createProduct()

		//ヘッダー、レスポンスボディ、ステータスコードは全てFactoryから返却させるようにする
		//上記3つを含んだJSONObjectだけを受け取って、OutputStreamWriterに渡す感じ
		val responseJson = executeHandler.execute()
		val writer = OutputStreamWriter(outputStream, "UTF-8")
		writer.write(responseJson.toJSONString())
		logger.log("responseJson:" + responseJson.toJSONString())
		writer.close()

	}
}