package model

import grails.test.mixin.TestFor
import spock.lang.Specification

import grails.buildtestdata.mixin.Build

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Persona)
@Build(Persona)
class PersonaSpec extends Specification {

    void "Buscar una persona por su nombre"() {
        setup:
        mockDomain(Persona)

        when:
        new Persona(nombre: nombre, apellidos: apellidos, fechaNac: fechaNac).save()

        then:
        Persona.findByNombre(nombre) != null

        where:
        nombre = "Rafael"
        apellidos = "Bermúdez Míguez"
        fechaNac = new Date().parse("dd/MM/yyyy", "09/09/2001")
    }
    
    void  "comprobar que calcula bien la edad en años"() {
       setup:
        mockDomain(Persona)
        
        expect:
        
        Persona.build(fechaNac: (new Date().parse("dd/MM/yyyy", fechaNac))).edad == years

        where:
        fechaNac        |   years
        "09/09/2014"    |   0
        "09/09/1969"    |   45
        "09/09/1983"    |   31
        "09/09/2000"    |   14
        
    }
}
