// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragments_with_friends

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.inline_fragments_with_friends.type.CustomType
import com.example.inline_fragments_with_friends.type.Episode
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("hero", "hero", null, true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var hero: TestQuery.Hero? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> hero = readObject<TestQuery.Hero>(RESPONSE_FIELDS[0]) { reader ->
            TestQuery_ResponseAdapter.Hero_ResponseAdapter.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        hero = hero
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        TestQuery_ResponseAdapter.Hero_ResponseAdapter.toResponse(writer, value.hero)
      }
    }
  }

  object Friend_ResponseAdapter : ResponseAdapter<TestQuery.Friend> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forList("appearsIn", "appearsIn", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Friend {
      return reader.run {
        var appearsIn: List<Episode?>? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> appearsIn = readList<Episode>(RESPONSE_FIELDS[0]) { reader ->
              Episode.safeValueOf(reader.readString())
            }
            else -> break
          }
        }
        TestQuery.Friend(
          appearsIn = appearsIn!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Friend) {
      writer.writeList(RESPONSE_FIELDS[0], value.appearsIn) { values, listItemWriter ->
        values?.forEach { value ->
          listItemWriter.writeString(value?.rawValue)}
      }
    }
  }

  object HumanHero_ResponseAdapter : ResponseAdapter<TestQuery.HumanHero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forDouble("height", "height", null, true, null),
      ResponseField.forList("friends", "friends", null, true, null),
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.HumanHero {
      return reader.run {
        var height: Double? = null
        var friends: List<TestQuery.Friend?>? = null
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> height = readDouble(RESPONSE_FIELDS[0])
            1 -> friends = readList<TestQuery.Friend>(RESPONSE_FIELDS[1]) { reader ->
              reader.readObject<TestQuery.Friend> { reader ->
                TestQuery_ResponseAdapter.Friend_ResponseAdapter.fromResponse(reader)
              }
            }
            2 -> __typename = readString(RESPONSE_FIELDS[2])
            3 -> name = readString(RESPONSE_FIELDS[3])
            else -> break
          }
        }
        TestQuery.HumanHero(
          height = height,
          friends = friends,
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.HumanHero) {
      writer.writeDouble(RESPONSE_FIELDS[0], value.height)
      writer.writeList(RESPONSE_FIELDS[1], value.friends) { values, listItemWriter ->
        values?.forEach { value ->
          if(value == null) {
            listItemWriter.writeObject(null)
          } else {
            listItemWriter.writeObject { writer ->
              TestQuery_ResponseAdapter.Friend_ResponseAdapter.toResponse(writer, value)
            }
          }
        }
      }
      writer.writeString(RESPONSE_FIELDS[2], value.__typename)
      writer.writeString(RESPONSE_FIELDS[3], value.name)
    }
  }

  object Friend1_ResponseAdapter : ResponseAdapter<TestQuery.Friend1> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Friend1 {
      return reader.run {
        var id: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> id = readCustomType<String>(RESPONSE_FIELDS[0] as ResponseField.CustomTypeField)
            else -> break
          }
        }
        TestQuery.Friend1(
          id = id!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Friend1) {
      writer.writeCustom(RESPONSE_FIELDS[0] as ResponseField.CustomTypeField, value.id)
    }
  }

  object DroidHero_ResponseAdapter : ResponseAdapter<TestQuery.DroidHero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("primaryFunction", "primaryFunction", null, true, null),
      ResponseField.forList("friends", "friends", null, true, null),
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.DroidHero {
      return reader.run {
        var primaryFunction: String? = null
        var friends: List<TestQuery.Friend1?>? = null
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> primaryFunction = readString(RESPONSE_FIELDS[0])
            1 -> friends = readList<TestQuery.Friend1>(RESPONSE_FIELDS[1]) { reader ->
              reader.readObject<TestQuery.Friend1> { reader ->
                TestQuery_ResponseAdapter.Friend1_ResponseAdapter.fromResponse(reader)
              }
            }
            2 -> __typename = readString(RESPONSE_FIELDS[2])
            3 -> name = readString(RESPONSE_FIELDS[3])
            else -> break
          }
        }
        TestQuery.DroidHero(
          primaryFunction = primaryFunction,
          friends = friends,
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.DroidHero) {
      writer.writeString(RESPONSE_FIELDS[0], value.primaryFunction)
      writer.writeList(RESPONSE_FIELDS[1], value.friends) { values, listItemWriter ->
        values?.forEach { value ->
          if(value == null) {
            listItemWriter.writeObject(null)
          } else {
            listItemWriter.writeObject { writer ->
              TestQuery_ResponseAdapter.Friend1_ResponseAdapter.toResponse(writer, value)
            }
          }
        }
      }
      writer.writeString(RESPONSE_FIELDS[2], value.__typename)
      writer.writeString(RESPONSE_FIELDS[3], value.name)
    }
  }

  object OtherHero_ResponseAdapter : ResponseAdapter<TestQuery.OtherHero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.OtherHero {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            else -> break
          }
        }
        TestQuery.OtherHero(
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.OtherHero) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
    }
  }

  object Hero_ResponseAdapter : ResponseAdapter<TestQuery.Hero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Hero {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "Human" -> TestQuery_ResponseAdapter.HumanHero_ResponseAdapter.fromResponse(reader, typename)
        "Droid" -> TestQuery_ResponseAdapter.DroidHero_ResponseAdapter.fromResponse(reader, typename)
        else -> TestQuery_ResponseAdapter.OtherHero_ResponseAdapter.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Hero) {
      when(value) {
        is TestQuery.HumanHero -> TestQuery_ResponseAdapter.HumanHero_ResponseAdapter.toResponse(writer, value)
        is TestQuery.DroidHero -> TestQuery_ResponseAdapter.DroidHero_ResponseAdapter.toResponse(writer, value)
        is TestQuery.OtherHero -> TestQuery_ResponseAdapter.OtherHero_ResponseAdapter.toResponse(writer, value)
      }
    }
  }
}