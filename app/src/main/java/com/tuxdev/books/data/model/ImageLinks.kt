package com.tuxdev.books.data.model

import android.os.Parcel
import android.os.Parcelable

data class ImageLinks(
		val thumbnail: String? = null,
		val smallThumbnail: String? = null
) : Parcelable {
	constructor(source: Parcel) : this(
			source.readString(),
			source.readString()
	)

	override fun describeContents() = 0

	override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
		writeString(thumbnail)
		writeString(smallThumbnail)
	}

	companion object {
		@JvmField
		val CREATOR: Parcelable.Creator<ImageLinks> = object : Parcelable.Creator<ImageLinks> {
			override fun createFromParcel(source: Parcel): ImageLinks = ImageLinks(source)
			override fun newArray(size: Int): Array<ImageLinks?> = arrayOfNulls(size)
		}
	}
}
