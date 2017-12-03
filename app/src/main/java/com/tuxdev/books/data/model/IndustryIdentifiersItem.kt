package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class IndustryIdentifiersItem(
		val identifier: String? = null,
		val type: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readString(),
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(identifier)
		writeString(type)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<IndustryIdentifiersItem> = object : Parcelable.Creator<IndustryIdentifiersItem> {
			override fun createFromParcel(source: Parcel): IndustryIdentifiersItem = IndustryIdentifiersItem(source)
			override fun newArray(size: Int): Array<IndustryIdentifiersItem?> = arrayOfNulls(size)
		}
	}
}
