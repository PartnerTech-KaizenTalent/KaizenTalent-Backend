/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.service;

import pe.partnertech.kaizentalent.model.DocumentoCV;

import java.util.Optional;

public interface IDocumentoCVService {

    Optional<DocumentoCV> BuscarDocumentoCV_By_ID(Long id_documentocv);

    Optional<DocumentoCV> BuscarDocumentoCV_By_Nombre(String nombre_documentocv);

    void GuardarDocumentoCV(DocumentoCV documentocv);
}
