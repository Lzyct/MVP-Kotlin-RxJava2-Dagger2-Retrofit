package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class SearchInfo(
		val textSnippet: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(textSnippet)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<SearchInfo> = object : Parcelable.Creator<SearchInfo> {
			override fun createFromParcel(source: Parcel): SearchInfo = SearchInfo(source)
			override fun newArray(size: Int): Array<SearchInfo?> = arrayOfNulls(size)
		}
	}
}
