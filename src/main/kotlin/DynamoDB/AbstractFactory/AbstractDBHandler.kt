package lambdaHandler

import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.Index
import com.amazonaws.services.dynamodbv2.document.Table
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec
import org.json.simple.JSONObject

/*
  Handlerの共通インターフェース
 */

abstract class AbstractDBHandler() {

	val dynamoDB: DynamoDBClient = DynamoDBClient()
	val dynamoDBClient: DynamoDB = dynamoDB.getClient()

	abstract var table: Table
	abstract var index: Index
	abstract var querySpec: QuerySpec

	abstract fun execute(): JSONObject
}