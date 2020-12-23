// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragment_merge_fields.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.inline_fragment_merge_fields.TestQuery
import com.example.inline_fragment_merge_fields.type.CustomScalarType
import kotlin.Any
import kotlin.Array
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
    return Data.fromResponse(reader, __typename)
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    Data.toResponse(writer, value)
  }

  object Data : ResponseAdapter<TestQuery.Data> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forObject("hero", "hero", null, true, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
      return reader.run {
        var hero: TestQuery.Data.Hero? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> hero = readObject<TestQuery.Data.Hero>(RESPONSE_FIELDS[0]) { reader ->
              Hero.fromResponse(reader)
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
          Hero.toResponse(writer, value.hero)
        }
      }
    }

    object Hero : ResponseAdapter<TestQuery.Data.Hero> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, false, null),
        ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null)
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Hero {
        val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
        return when(typename) {
          "Droid" -> CharacterHero.fromResponse(reader, typename)
          "Human" -> CharacterHero.fromResponse(reader, typename)
          else -> OtherHero.fromResponse(reader, typename)
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero) {
        when(value) {
          is TestQuery.Data.Hero.CharacterHero -> CharacterHero.toResponse(writer, value)
          is TestQuery.Data.Hero.OtherHero -> OtherHero.toResponse(writer, value)
        }
      }

      object CharacterHero : ResponseAdapter<TestQuery.Data.Hero.CharacterHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null),
          ResponseField.forCustomScalar("profileLink", "profileLink", null, false, CustomScalarType.URL, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.CharacterHero {
          return reader.run {
            var __typename: String? = __typename
            var name: String? = null
            var friendsConnection: TestQuery.Data.Hero.CharacterHero.FriendsConnection? = null
            var profileLink: Any? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> name = readString(RESPONSE_FIELDS[1])
                2 -> friendsConnection = readObject<TestQuery.Data.Hero.CharacterHero.FriendsConnection>(RESPONSE_FIELDS[2]) { reader ->
                  FriendsConnection.fromResponse(reader)
                }
                3 -> profileLink = readCustomType<Any>(RESPONSE_FIELDS[3] as ResponseField.CustomTypeField)
                else -> break
              }
            }
            TestQuery.Data.Hero.CharacterHero(
              __typename = __typename!!,
              name = name!!,
              friendsConnection = friendsConnection!!,
              profileLink = profileLink!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.CharacterHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeString(RESPONSE_FIELDS[1], value.name)
          writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
            FriendsConnection.toResponse(writer, value.friendsConnection)
          }
          writer.writeCustom(RESPONSE_FIELDS[3] as ResponseField.CustomTypeField, value.profileLink)
        }

        object FriendsConnection :
            ResponseAdapter<TestQuery.Data.Hero.CharacterHero.FriendsConnection> {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forList("edges", "edges", null, true, null)
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.Hero.CharacterHero.FriendsConnection {
            return reader.run {
              var edges: List<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge?>? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> edges = readList<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge>(RESPONSE_FIELDS[0]) { reader ->
                    reader.readObject<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge> { reader ->
                      Edge.fromResponse(reader)
                    }
                  }
                  else -> break
                }
              }
              TestQuery.Data.Hero.CharacterHero.FriendsConnection(
                edges = edges
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.CharacterHero.FriendsConnection) {
            writer.writeList(RESPONSE_FIELDS[0], value.edges) { values, listItemWriter ->
              values?.forEach { value ->
                if(value == null) {
                  listItemWriter.writeObject(null)
                } else {
                  listItemWriter.writeObject { writer ->
                    Edge.toResponse(writer, value)
                  }
                }
              }
            }
          }

          object Edge : ResponseAdapter<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge> {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField.forObject("node", "node", null, true, null)
            )

            override fun fromResponse(reader: ResponseReader, __typename: String?):
                TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge {
              return reader.run {
                var node: TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node? = null
                while(true) {
                  when (selectField(RESPONSE_FIELDS)) {
                    0 -> node = readObject<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                      Node.fromResponse(reader)
                    }
                    else -> break
                  }
                }
                TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge(
                  node = node
                )
              }
            }

            override fun toResponse(writer: ResponseWriter,
                value: TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge) {
              if(value.node == null) {
                writer.writeObject(RESPONSE_FIELDS[0], null)
              } else {
                writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
                  Node.toResponse(writer, value.node)
                }
              }
            }

            object Node :
                ResponseAdapter<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node> {
              private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                ResponseField.forString("name", "name", null, false, null)
              )

              override fun fromResponse(reader: ResponseReader, __typename: String?):
                  TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node {
                return reader.run {
                  var name: String? = null
                  while(true) {
                    when (selectField(RESPONSE_FIELDS)) {
                      0 -> name = readString(RESPONSE_FIELDS[0])
                      else -> break
                    }
                  }
                  TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node(
                    name = name!!
                  )
                }
              }

              override fun toResponse(writer: ResponseWriter,
                  value: TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node) {
                writer.writeString(RESPONSE_FIELDS[0], value.name)
              }
            }
          }
        }
      }

      object OtherHero : ResponseAdapter<TestQuery.Data.Hero.OtherHero> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null)
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.OtherHero {
          return reader.run {
            var __typename: String? = __typename
            var name: String? = null
            var friendsConnection: TestQuery.Data.Hero.OtherHero.FriendsConnection? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> __typename = readString(RESPONSE_FIELDS[0])
                1 -> name = readString(RESPONSE_FIELDS[1])
                2 -> friendsConnection = readObject<TestQuery.Data.Hero.OtherHero.FriendsConnection>(RESPONSE_FIELDS[2]) { reader ->
                  FriendsConnection.fromResponse(reader)
                }
                else -> break
              }
            }
            TestQuery.Data.Hero.OtherHero(
              __typename = __typename!!,
              name = name!!,
              friendsConnection = friendsConnection!!
            )
          }
        }

        override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.OtherHero) {
          writer.writeString(RESPONSE_FIELDS[0], value.__typename)
          writer.writeString(RESPONSE_FIELDS[1], value.name)
          writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
            FriendsConnection.toResponse(writer, value.friendsConnection)
          }
        }

        object FriendsConnection : ResponseAdapter<TestQuery.Data.Hero.OtherHero.FriendsConnection>
            {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forList("edges", "edges", null, true, null)
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.Hero.OtherHero.FriendsConnection {
            return reader.run {
              var edges: List<TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge?>? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> edges = readList<TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge>(RESPONSE_FIELDS[0]) { reader ->
                    reader.readObject<TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge> { reader ->
                      Edge.fromResponse(reader)
                    }
                  }
                  else -> break
                }
              }
              TestQuery.Data.Hero.OtherHero.FriendsConnection(
                edges = edges
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.OtherHero.FriendsConnection) {
            writer.writeList(RESPONSE_FIELDS[0], value.edges) { values, listItemWriter ->
              values?.forEach { value ->
                if(value == null) {
                  listItemWriter.writeObject(null)
                } else {
                  listItemWriter.writeObject { writer ->
                    Edge.toResponse(writer, value)
                  }
                }
              }
            }
          }

          object Edge : ResponseAdapter<TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge> {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField.forObject("node", "node", null, true, null)
            )

            override fun fromResponse(reader: ResponseReader, __typename: String?):
                TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge {
              return reader.run {
                var node: TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge.Node? = null
                while(true) {
                  when (selectField(RESPONSE_FIELDS)) {
                    0 -> node = readObject<TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                      Node.fromResponse(reader)
                    }
                    else -> break
                  }
                }
                TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge(
                  node = node
                )
              }
            }

            override fun toResponse(writer: ResponseWriter,
                value: TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge) {
              if(value.node == null) {
                writer.writeObject(RESPONSE_FIELDS[0], null)
              } else {
                writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
                  Node.toResponse(writer, value.node)
                }
              }
            }

            object Node : ResponseAdapter<TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge.Node>
                {
              private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
                ResponseField.forString("name", "name", null, false, null)
              )

              override fun fromResponse(reader: ResponseReader, __typename: String?):
                  TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge.Node {
                return reader.run {
                  var name: String? = null
                  while(true) {
                    when (selectField(RESPONSE_FIELDS)) {
                      0 -> name = readString(RESPONSE_FIELDS[0])
                      else -> break
                    }
                  }
                  TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge.Node(
                    name = name!!
                  )
                }
              }

              override fun toResponse(writer: ResponseWriter,
                  value: TestQuery.Data.Hero.OtherHero.FriendsConnection.Edge.Node) {
                writer.writeString(RESPONSE_FIELDS[0], value.name)
              }
            }
          }
        }
      }
    }
  }
}
