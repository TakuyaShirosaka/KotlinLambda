package lambdaHandler

import com.amazonaws.services.dynamodbv2.document.*
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap
import org.json.simple.JSONArray
import org.json.simple.JSONObject

/*
  Handlerの具体的な実装
 */

class SampleDBHandler : AbstractDBHandler() {

	//inputの要素の指定
	private val inputParam: JSONObject =
		RequestParameter.getParameter("body")["SampleDB"] as JSONObject

	//指定するテーブル
	override var table: Table = dynamoDBClient.getTable("SampleDB")

	//使用するインデックス、使用しない場合はNullでオーバーライドだけしておく
	override var index: Index = table.getIndex("member_seach")

	//インデックス使用時などの検索条件、インデックスを使用しない場合はNullでオーバーライドしておく
	override var querySpec: QuerySpec =
		QuerySpec().withProjectionExpression("member_id,member_pass,member_name,member_age")
			.withKeyConditionExpression(
				"member_name = :v_member_name and member_age between :v_member_age_st and :v_member_age_ed"
			)
			.withValueMap(
				ValueMap().withString(
					":v_member_name",
					inputParam["member_name"] as String
				).withNumber(":v_member_age_st", inputParam["member_age_st"] as Long)
					.withNumber(":v_member_age_ed", inputParam["member_age_ed"] as Long)
			)

	override fun execute(): JSONObject {
		//クエリの実行
		val items = index.query(querySpec)

		//返却用のJSONArray
		val jArray = JSONArray()

		//返却値の加工
		for (item in items.iterator()) jArray.add(item.toJSONPretty())

		//値の返却
		val result = JSONObject()
		result["SampleDBHandler:"] = jArray
		System.out.println("result:$result")

		return result
	}
}