package model

class Persona {
    
    Long id
    String nombre
    String apellidos
    Date fechaNac
    
    static transients = ["edad"]

    static constraints = {
    }
    
    def getEdad(){
        return (new Date().year-fechaNac.year)
    }
}
