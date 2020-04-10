package i_poo.v_design_patterns.B_Modelos_de_Structuration.VI_Proxy;

public class Exemple_3 {
  public static void main(String[] args) {
    File proxyFile = new ProxyFile("text.html");

    proxyFile.open();
    proxyFile.write();
    proxyFile.save();
    proxyFile.write();
    proxyFile.save();
    /*
       CARGANDO: text.html
       OPENING: text.html
       WRITING: text.html
       SAVING: text.html
       WRITING: text.html
       SAVING: text.html
    */
  }
}

interface File {
  public void open();
  public void save();
  public void write();
}

//*******************************************************
class RealFile implements File {

  private String fileName;

  public RealFile(String fileName) {
    this.fileName = fileName;
    cargar();
  }
  public void cargar() {
    System.out.println("CARGANDO: " + fileName);
  }

  @Override
  public void save() {
    System.out.println("SAVING: " + fileName);
  }

  @Override
  public void open() {
    System.out.println("OPENING: " + fileName);
  }

  @Override
  public void write() {
    System.out.println("WRITING: " + fileName);
  }
}

//********************************************************
class ProxyFile implements File {

  private RealFile realFile;
  private String fileName;

  public ProxyFile(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void save() {
    if (realFile == null) {
      realFile = new RealFile(fileName);
    }
    realFile.save();
  }

  @Override
  public void open() {
    if (realFile == null) {
      realFile = new RealFile(fileName);
    }
    realFile.open();
  }

  @Override
  public void write() {
    if (realFile == null) {
      realFile = new RealFile(fileName);
    }
    realFile.write();
  }
}
