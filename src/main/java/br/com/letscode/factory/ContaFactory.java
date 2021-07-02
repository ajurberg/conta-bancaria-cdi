package br.com.letscode.factory;

import br.com.letscode.annotationLiteral.ContaAnnotationLiteral;
import br.com.letscode.domains.ContaEnum;

import br.com.letscode.services.ContaService;
import jakarta.inject.Inject;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;

public class ContaFactory {

    @Inject
    @Any
    private Instance<ContaService> contaServiceInstance;

    public ContaService createConta(ContaEnum contaEnum) {
        final var literal = new ContaAnnotationLiteral(contaEnum);
        return contaServiceInstance.select(literal).get();
    }

}
