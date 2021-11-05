/*
 * Copyright (c) 2021. Developed by Diego Campos Sandoval.
 */

package pe.partnertech.kaizentalent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.partnertech.kaizentalent.model.ExperienciaLaboral;

import java.util.Set;

@Repository
public interface IExperienciaLaboralDAO extends JpaRepository<ExperienciaLaboral, Long> {

    @Query("SELECT el FROM ExperienciaLaboral el JOIN Usuario u ON el.usuarioExperienciaLaboral.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1 AND " +
            "el.nombreExperienciaLaboral LIKE ?2 AND " +
            "el.empresaExperienciaLaboral LIKE ?3 AND " +
            "el.mesinicioExperienciaLaboral LIKE ?4 AND " +
            "el.anioinicioExperienciaLaboral LIKE ?5 AND " +
            "el.mesfinExperienciaLaboral LIKE ?6 AND " +
            "el.aniofinExperienciaLaboral LIKE ?7 AND " +
            "el.descripcionExperienciaLaboral LIKE ?8 AND " +
            "el.referenteReferenciaLaboral LIKE ?9 AND " +
            "el.emailreferenteReferenciaLaboral LIKE ?10 AND " +
            "el.telefonoreferenteReferenciaLaboral LIKE ?11")
    Set<ExperienciaLaboral> findExperienciasLaboralesToValidate(Long id_postulante, String nombre_experiencialaboral,
                                                                String empresa_experiencialaboral,
                                                                String mesinicio_experiencialaboral,
                                                                String anioinicio_experiencialaboral,
                                                                String mesfin_experiencialaboral,
                                                                String aniofin_experiencialaboral,
                                                                String descripcion_experiencialaboral,
                                                                String referente_referencialaboral,
                                                                String emailreferente_referencialaboral,
                                                                String telefonoreferente_referencialaboral);

    @Query("SELECT el FROM ExperienciaLaboral el JOIN Usuario u ON el.usuarioExperienciaLaboral.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = ?1")
    Set<ExperienciaLaboral> findExperienciasLaboralesByIdPostulante(Long id_postulante);

    Set<ExperienciaLaboral> findByEmpresaExperienciaLaboral(String empresa_experiencialaboral);
}
