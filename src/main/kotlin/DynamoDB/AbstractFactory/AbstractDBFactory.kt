package lambdaHandler

/*
  引数で渡ってきたJSONObjectを解析して、routeMapから生成するオブジェクトを返却する
  適当なオブジェクトを返却できない場合、強制的に落とす
 */

abstract class AbstractDBFactory {

	abstract fun createDBProduct(): AbstractDBHandler

	companion object {
		fun createDBFactory(targetDB:Map<String, AbstractDBFactory>,id: String): AbstractDBFactory {
			System.out.println("targetDB:$targetDB")
			System.out.println("Id:$id")
			return targetDB[id] ?: throw Exception("factoryId was not found!!!")
		}
	}
}