package lambdaHandler

/*
 	DynamoDB用のMap、定数とDBFactoryクラスの組み合わせで保持する
 */

const val SampleDB_search = "1-1"

val SampleDBMap = mapOf<String, AbstractDBFactory>(
	SampleDB_search to SampleDBFactory(),
	"1-2" to SampleDBFactory(),
	"1-3" to SampleDBFactory()
)

