package i_poo.q_collections.collections_III_IV_equals_hashCode;

import java.util.Objects;

public class Libro {

    private String titulo;
    private String autor;
    private int ISBN;

    public Libro(String titulo, String autor, int ISBN) {//Constructor
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    //SETTERS AND GETTERS
    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setAutor(String numeroCuenta) {

        this.autor = numeroCuenta;
    }

    public String getAutor() {

        return autor;
    }

    public void setISBN(int ISBN) {

        this.ISBN = ISBN;
    }

    public int getISBN() {

        return ISBN;
    }

    //METODO
    public String getDatos() {
        String datos;
        datos = "Libro: " + this.titulo + ", Autor: " + this.autor + ", ISBN: " + this.ISBN;
        return datos;
    }
    //******************************************************************************************************************
    //                                       equals()
    //                             OTRA MANERA MENOS COMPLEJA  Con eclipse o intellij idea (generador)
    ////           java.util.Objects; trae una manera mas facil de reescribir el codigo equals y hashcode
    //******************************************************************************************************************

    /*COMO SE TRATA DE OPERACIONES MUY FRECUENTES eclipse o intellij idea ya tienen una opcion para generar esto de manera
    automatica o mejor dicho reescribirlo:
    */
                           @Override
                           public boolean equals(Object o) {
                               if (this == o) return true;
                               if (!(o instanceof Libro)) return false;
                               Libro libro = (Libro) o;
                               return getISBN() == libro.getISBN() &&
                                       getTitulo().equals(libro.getTitulo()) &&
                                       getAutor().equals(libro.getAutor());
                           }

     //Esto nos ahorra el trabajo, aunque SIEMPRE CONVIENE SABER DE DONDE VIENE
     //A la antigua esto hubiera sido asi manualmente:
    /*
              public boolean equals(Object objeto) {

                  if (objeto instanceof Libro) {
                      Libro otro = (Libro) objeto;//asi hacemos el casting ya sabiendo que es un objeto de tipo Libro
                      //String titulo             //necesitamos el objeto para poder comparar atributos
                      if (this.titulo == null) {
                          if (otro.getTitulo() != null)
                              return false;//da false en los 2 casos
                      } else if (!this.titulo.equals(otro.getTitulo())) {
                          return false;
                      }
                      //String autor
                      if (this.autor == null) {
                          if (otro.getAutor() != null)
                              return false;//da false en los 2 casos
                      } else if (!this.autor.equals(otro.getAutor())) {
                          return false;
                      }
                      //parametros int 3ro ISBN...en mi ejemplo solo esta comparacion bastaria pa saber si son iguales o no
                      if (this.ISBN != otro.getISBN()) {//ya que podemos tener 2 libros con el mismo autor y titulo pero no ISBN
                          return false;   //podria ser tb otro.ISBN ya que ahora despues del cast es un objeto Libro
                      }
                      return true;//si ninguna de las anteriores se cumple el codigo llegara aqui y dara TRUE, sino se quedara en FALSE
                  } else {//esto querria decir que el objeto con el que queremos comparar no es de la misma clase asi que false
                      return false;
                  }//este else es como decir que sus clases != no son iguales
              }
    */
    //******************************************************************************************************************
    //                                         hashCode()
    //******************************************************************************************************************
    //Podemos tambien utilizar el codigo hash
    //Normalmente
    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getAutor(), getISBN());
    }//o en vez de los getters las variables

    /*A la antigua esto hubiera sido asi manualmente:

         public int hashCode() {
            //On définit un multiplication impair, de préférence un nombre premier(primo), Ceci afin de garantir l'unicité du résultat final
               final int prime = 31;//primo divisible por 1 y 31

            //On définit un résultat qui sera renvoyé au final
               int result = 1;

            //On ajoute en eux la multiplication des attributs et du multiplicateur
               result = result * prime + ISBN;

            //Lorsque vous devez gérer des hashcodes avec des objets dans le mode de calcul
            //Vous devez vérifier si l'objet n'est pas null, sinon vous aurez une erreur
               result = result * prime + ((titulo == null) ? 0 : titulo.hashCode());
               result = result * prime + ((autor == null) ? 0 : autor.hashCode());
               return result;                              //para dar algo en el else en caso el objeto no es nulo
    */

    //PORQUE ECLIPSE NOS PERMITE REESCRIBIR equals, y hashCode()
    //Si modificamos el metodo equals() de la clase Object , tambien deberiamos modificar el metodo hashCode()
    //ya que estos solo sirven para diferenciar objetos de clases predefinidas, pero no de nuestras propias clases
    //los 2 van acompaniados y se deben modificar juntos
}
