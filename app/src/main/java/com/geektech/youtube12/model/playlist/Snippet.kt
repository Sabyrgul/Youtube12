package com.geektech.youtube12.model.playlist

data class Snippet(
    var channelId: String? = null,
    var channelTitle: String? = null,
    var description: String? = null,
    var localized: Localized? = null,
    var publishedAt: String? = null,
    var thumbnails: Thumbnails? = null,
    var title: String? = null
)