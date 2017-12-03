package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class Epub(
		val isAvailable: Boolean? = null,
		val acsTokenLink: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readValue(Boolean::class.java.classLoader) as Boolean?,
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(isAvailable)
		writeString(acsTokenLink)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<Epub> = object : Parcelable.Creator<Epub> {
			override fun createFromParcel(source: Parcel): Epub = Epub(source)
			override fun newArray(size: Int): Array<Epub?> = arrayOfNulls(size)
		}
	}
}
