package lambdaHandler

/*
  引数で渡ってきたJSONObjectを解析して、routeMapから生成するオブジェクトを返却する
  適当なオブジェクトを返却できない場合、強制的に落とす
 */

abstract class AbstractFactory {
	abstract fun createProduct(): AbstractHandler

	companion object {
		fun createFactory(): AbstractFactory {

			val inputBody = RequestParameter.getParameter("body")
			val tag = inputBody["TAG"]
			val id = inputBody["Id"]

			System.out.println("inputBody:$inputBody")
			System.out.println("TAG:$tag")
			System.out.println("Id:$id")

			val targetRoutingMap = HandlerMap[tag] ?: throw Exception("targetRoutingMap was not found!!!")

			return targetRoutingMap[id] ?: throw Exception("factoryId was not found!!!")

		}
	}
}