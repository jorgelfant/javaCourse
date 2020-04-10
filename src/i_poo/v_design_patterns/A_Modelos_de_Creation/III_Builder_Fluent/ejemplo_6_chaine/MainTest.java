package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_6_chaine;

import java.util.Date;

public class MainTest {
  public static void main(String[] args) {
    /*The builder pattern

    The builder pattern provides a build object which is used to construct a complex object called the product.
    It encapsulates the logic of constructing the different pieces of the product.

    Typically the builder pattern is implemented by an class which has several methods to configure the product.
    These methods typically return the builder object. This allows to use the builder via a fluent API, e.g, by calling
    methods directly after each other. Once the product is completely configured a build() method is called to construct
    the object.

    Assume you have a data model like the following.

    The builder pattern simplifies the creation of objects. It also simplifies the code as your do not have to call
    a complex constructor or call several setter methods on the created object.

    The builder pattern can be used to create an immutable class.                                                     */

    //        se crea un objeto luego aplicandole el metodo se crea otro objeto iniciandole otro parametro
    //luego el objeto con su parametro ya iniciado ejecuta otro metodo que retorna otro objeto con su parametro iniciado
    //hasta que el objeto ejecuta el metodo build que crea un objeto de tipo Taskt

    // asi se van iniciando en una sola linea los argumento que utilizara al final el metodo build que retorna un
    // return new Task(id, summary, description, done, dueDate);
    Task task = new TaskBuilder(5).setDescription("Hello").setSummary("Test").build();
    System.out.println(task);//task sera el objeto de tipo Task enviado por build, con los parametros inicializados por el builder

  }
}

//**********************************************************************************************************************
//                                               TASK
//**********************************************************************************************************************
class Task {
  private final long id;
  private String summary = "";
  private String description = "";
  private boolean done = false;
  private Date dueDate;

  public Task(long id) {//constructor
    this.id = id;
  }

  public Task(long id, String summary, String description, boolean done, Date dueDate) {//constructor
    this.id = id;
    this.summary = summary;
    this.description = description;
    this.done = done;
    this.dueDate = dueDate;

  }

  //***************************************************
  public long getId() {
    return id;
  }

  //***************************************************
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  //***************************************************
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  //***************************************************
  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  //***************************************************
  public Date getDueDate() {
    return new Date(dueDate.getTime());
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = new Date(dueDate.getTime());
  }
}

//**********************************************************************************************************************
//     Your builder would looks like the following.       TaskBuilder
//**********************************************************************************************************************
//Los metodos me darian un objeto de tipo TaskBuilder cada uno daria un objeto con un parametro iniciado por ejemplo
class TaskBuilder {

  private final long id;
  private String summary = "";
  private String description = "";
  private boolean done = false;
  private Date dueDate;

  public TaskBuilder(long id) {
    this.id = id;
    this.summary = summary;
    this.description = description;
    this.done = done;
    this.dueDate = dueDate;
  }

  //METODOS , SOLO GETTERS  DE FRENTE ( que funcionan tb como setters)
  public TaskBuilder setSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public TaskBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public TaskBuilder setDone(boolean done) {
    this.done = done;
    return this;//retorna el objeto que esta usando el metodo en este caso sera un TaskBuilder (gracias a this)
  }             //por eso el metodo tiene TaskBuilder como tipo de retur

  public TaskBuilder setDueDate(Date dueDate) {
    this.dueDate = new Date(dueDate.getTime());
    return this;
  }

  public Task build() {
    return new Task(id, summary, description, done, dueDate);//retorna el constructor de task (su segundo constructor)
  }
}
