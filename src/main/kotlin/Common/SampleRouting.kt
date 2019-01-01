package lambdaHandler

/*
 	Sample業務用のルーティングMAP、IdとConcreteFactoryクラスの組み合わせで保持する
 */


//定数
const val Sample_SearchFactory = "1-1"

//Map
val SampleHandlerMap = mapOf<String, AbstractFactory>(
	Sample_SearchFactory to SearchFactory()
)

