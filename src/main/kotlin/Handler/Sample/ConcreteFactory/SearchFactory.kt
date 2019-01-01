package lambdaHandler

/*
  共通インターフェースの実装
 */

class SearchFactory : AbstractFactory() {
	override fun createProduct(): AbstractHandler {
		return SearchHandler()
	}
}