package lambdaHandler

/*
  共通インターフェースの実装
 */

class SampleDBFactory : AbstractDBFactory() {
	override fun createDBProduct(): AbstractDBHandler {
		return SampleDBHandler()
	}
}