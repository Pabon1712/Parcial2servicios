package com.pabon.usuario.service;

import com.pabon.commons.service.CommonService;
import com.pabon.usuario.entity.Alumno;

public interface AlumnoService extends CommonService<Alumno>{
	
	public Alumno save(Alumno alumno);
	
	public void deleteById (Long Id);
}