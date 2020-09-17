package com.example.chatmessanger.domain.media

import android.net.Uri
import com.example.chatmessanger.domain.interactor.UseCase
import com.example.chatmessanger.domain.type.None
import javax.inject.Inject

class CreateImageFile @Inject constructor(
    private val mediaRepository: MediaRepository
) : UseCase<Uri, None>() {

    override suspend fun run(params: None) = mediaRepository.createImageFile()
}