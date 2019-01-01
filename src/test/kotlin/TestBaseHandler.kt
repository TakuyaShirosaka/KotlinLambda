package lambdaHandler

import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext
import com.amazonaws.services.lambda.runtime.Context
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

fun main(args: Array<String>) {

	//起動用の情報を作成
	val testHandler = BaseHandler()
	val input: InputStream = FileInputStream(File("src/test/kotlin/input.json"))
	val output: OutputStream = FileOutputStream(File("src/test/kotlin/output.json"))
	val context: Context = MockLambdaContext()

	//Handlerを起動
	testHandler.handleRequest(input, output, context)

}


