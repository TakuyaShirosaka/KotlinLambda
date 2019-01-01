package lambdaHandler

/*
	DB接続のための共通的な情報を保持するクラス
	例：接続先のリージョン設定
*/

// import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.document.DynamoDB

class DynamoDBClient {

	//本番モード
	private val client: AmazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
		.withRegion(Regions.AP_NORTHEAST_1)
		.build()

	//開発環境モード
	//private val client: AmazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
	//.withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ap-northeast-1")).build()

	private val dynamoDB: DynamoDB = DynamoDB(client)

/*
	 Setter,Getter
*/

	fun getClient(): DynamoDB {
		return this.dynamoDB
	}
}

