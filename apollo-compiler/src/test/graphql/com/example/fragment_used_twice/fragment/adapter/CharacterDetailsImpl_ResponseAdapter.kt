// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.fragment_used_twice.fragment.CharacterDetailsImpl
import com.example.fragment_used_twice.type.CustomScalarType
import kotlin.Any
import kotlin.Array
import kotlin.String

object CharacterDetailsImpl_ResponseAdapter : ResponseAdapter<CharacterDetailsImpl> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forString("name", "name", null, false, null),
    ResponseField.forCustomScalar("birthDate", "birthDate", null, false, CustomScalarType.Date, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): CharacterDetailsImpl {
    return reader.run {
      var __typename: String? = __typename
      var name: String? = null
      var birthDate: Any? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> __typename = readString(RESPONSE_FIELDS[0])
          1 -> name = readString(RESPONSE_FIELDS[1])
          2 -> birthDate = readCustomType<Any>(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField)
          else -> break
        }
      }
      CharacterDetailsImpl(
        __typename = __typename!!,
        name = name!!,
        birthDate = birthDate!!
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: CharacterDetailsImpl) {
    writer.writeString(RESPONSE_FIELDS[0], value.__typename)
    writer.writeString(RESPONSE_FIELDS[1], value.name)
    writer.writeCustom(RESPONSE_FIELDS[2] as ResponseField.CustomTypeField, value.birthDate)
  }
}
