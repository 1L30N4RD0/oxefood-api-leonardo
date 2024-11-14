package br.com.ifpe.oxefood.modelo.empresa;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

   @Autowired
   private EmpresaRepository repository;

   @Transactional
   public Empresa save(Empresa empresa) {

       empresa.setHabilitado(Boolean.TRUE);
       return repository.save(empresa);
   }

}
