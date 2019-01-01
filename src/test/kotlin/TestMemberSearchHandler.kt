package lambdaHandler

import java.io.File
import java.io.FileInputStream

fun main(args: Array<String>) {

	val input = FileInputStream(File("src/test/kotlin/input.json"))
	RequestParameter.parseParameter(input)

	System.out.println("★★★★★★★★★★")
	val factory: AbstractDBFactory = AbstractDBFactory.createDBFactory(Kobetsu_MemberMap, Kobetsu_member_search)
	val executeHandler = factory.createDBProduct()

	System.out.println("★★★★★★★★★★")
	System.out.println("結果:" + executeHandler.execute())
}