package br.com.ifpe.oxefood.modelo.empresa;

import jakarta.transaction.Transactional;

import java.util.List;

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

    public List<Empresa> listarTodos() {

        return repository.findAll();
    }

    public Empresa obterPorID(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Empresa empresaAlterado) {

        Empresa empresa = repository.findById(id).get();
        empresa.setSite(empresaAlterado.getSite());
        empresa.setCnpj(empresaAlterado.getCnpj());
        empresa.setInscricaoEstadual(empresaAlterado.getInscricaoEstadual());
        empresa.setNomeEmpresarial(empresaAlterado.getNomeEmpresarial());
        empresa.setNomeFantasia(empresaAlterado.getNomeFantasia());
        empresa.setFone(empresaAlterado.getFone());
        empresa.setFoneAlternativo(empresaAlterado.getFoneAlternativo());

        repository.save(empresa);
    }

    @Transactional
    public void delete(Long id) {

        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(Boolean.FALSE);

        repository.save(empresa);
    }

}
