package com.pabon.curso.service;

import org.springframework.stereotype.Service;

import com.pabon.common.usuario.models.entity.Curso;
import com.pabon.commons.service.CommonService;
import com.pabon.commons.service.CommonServiceImpl;
import com.pabon.curso.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso,CursoRepository> implements CommonService<Curso>{

}
