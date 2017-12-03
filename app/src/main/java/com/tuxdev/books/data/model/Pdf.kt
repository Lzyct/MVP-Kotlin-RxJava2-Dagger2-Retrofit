package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class Pdf(
		val isAvailable: Boolean? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readValue(Boolean::class.java.classLoader) as Boolean?
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeValue(isAvailable)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<Pdf> = object : Parcelable.Creator<Pdf> {
			override fun createFromParcel(source: Parcel): Pdf = Pdf(source)
			override fun newArray(size: Int): Array<Pdf?> = arrayOfNulls(size)
		}
	}
}
