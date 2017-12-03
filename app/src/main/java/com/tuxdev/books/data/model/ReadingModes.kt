package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class ReadingModes(
		val image: Boolean? = null,
		val text: Boolean? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readValue(Boolean::class.java.classLoader) as Boolean?,
			source.readValue(Boolean::class.java.classLoader) as Boolean?
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(image)
		writeValue(text)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<ReadingModes> = object : Parcelable.Creator<ReadingModes> {
			override fun createFromParcel(source: Parcel): ReadingModes = ReadingModes(source)
			override fun newArray(size: Int): Array<ReadingModes?> = arrayOfNulls(size)
		}
	}
}
