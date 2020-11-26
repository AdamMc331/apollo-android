// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.directives

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress

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

  object FriendsConnection_ResponseAdapter : ResponseAdapter<TestQuery.FriendsConnection> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forInt("totalCount", "totalCount", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        TestQuery.FriendsConnection {
      return reader.run {
        var totalCount: Int? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> totalCount = readInt(RESPONSE_FIELDS[0])
            else -> break
          }
        }
        TestQuery.FriendsConnection(
          totalCount = totalCount
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.FriendsConnection) {
      writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
    }
  }

  object Hero_ResponseAdapter : ResponseAdapter<TestQuery.Hero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("name", "name", null, true, listOf(
        ResponseField.Condition.booleanCondition("includeName", false)
      )),
      ResponseField.forObject("friendsConnection", "friendsConnection", null, true, listOf(
        ResponseField.Condition.booleanCondition("skipFriends", true)
      ))
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Hero {
      return reader.run {
        var name: String? = null
        var friendsConnection: TestQuery.FriendsConnection? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> name = readString(RESPONSE_FIELDS[0])
            1 -> friendsConnection = readObject<TestQuery.FriendsConnection>(RESPONSE_FIELDS[1]) { reader ->
              TestQuery_ResponseAdapter.FriendsConnection_ResponseAdapter.fromResponse(reader)
            }
            else -> break
          }
        }
        TestQuery.Hero(
          name = name,
          friendsConnection = friendsConnection
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Hero) {
      writer.writeString(RESPONSE_FIELDS[0], value.name)
      if(value.friendsConnection == null) {
        writer.writeObject(RESPONSE_FIELDS[1], null)
      } else {
        writer.writeObject(RESPONSE_FIELDS[1]) { writer ->
          TestQuery_ResponseAdapter.FriendsConnection_ResponseAdapter.toResponse(writer, value.friendsConnection)
        }
      }
    }
  }
}