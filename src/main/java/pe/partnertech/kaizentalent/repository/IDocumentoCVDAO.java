/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.DocumentoCV;

import java.util.Optional;

@Repository
public interface IDocumentoCVDAO extends JpaRepository<DocumentoCV, Long> {

    Optional<DocumentoCV> findByNombreDocumentoCV(String nombre_documentocv);
}
