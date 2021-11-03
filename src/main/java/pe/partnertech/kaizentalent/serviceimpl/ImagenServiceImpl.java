/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.serviceimpl;

import org.springframework.stereotype.Service;
import pe.partnertech.kaizentalent.model.Imagen;
import pe.partnertech.kaizentalent.repository.IImagenDAO;
import pe.partnertech.kaizentalent.service.IImagenService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ImagenServiceImpl implements IImagenService {

    final
    IImagenDAO data;

    public ImagenServiceImpl(IImagenDAO data) {
        this.data = data;
    }

    @Override
    public Optional<Imagen> BuscarImagen_By_ID(Long id_imagen) {
        return data.findById(id_imagen);
    }

    @Override
    public Optional<Imagen> BuscarImagen_By_Nombre(String nombre_imagen) {
        return data.findByNombreImagen(nombre_imagen);
    }

    @Override
    public void GuardarImagen(Imagen imagen) {
        data.save(imagen);
    }
}
