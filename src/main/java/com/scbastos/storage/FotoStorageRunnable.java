package com.scbastos.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.scbastos.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;
	
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado) {
		this.files = files;
		this.resultado = resultado;
	}

	@Override
	public void run() {
		System.out.println(">>> files: " + files[0].getSize());
		// TODO: Salvar a foto no sistema de arquivos...
		String nomeFoto = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		resultado.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
