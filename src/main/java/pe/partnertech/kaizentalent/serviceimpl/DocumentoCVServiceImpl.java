/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.DocumentoCV;
import pe.partnertech.kaizentalent.repository.IDocumentoCVDAO;
import pe.partnertech.kaizentalent.service.IDocumentoCVService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DocumentoCVServiceImpl implements IDocumentoCVService {

    final
    IDocumentoCVDAO data;

    public DocumentoCVServiceImpl(IDocumentoCVDAO data) {
        this.data = data;
    }


    @Override
    public Optional<DocumentoCV> BuscarDocumentoCV_By_ID(Long id_documentocv) {
        return data.findById(id_documentocv);
    }

    @Override
    public Optional<DocumentoCV> BuscarDocumentoCV_By_Nombre(String nombre_documentocv) {
        return data.findByNombreDocumentoCV(nombre_documentocv);
    }

    @Override
    public void GuardarDocumentoCV(DocumentoCV documentocv) {
        data.save(documentocv);
    }
}
