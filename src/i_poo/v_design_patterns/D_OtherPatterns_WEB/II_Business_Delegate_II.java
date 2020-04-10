package i_poo.v_design_patterns.D_OtherPatterns_WEB;

public class II_Business_Delegate_II {
  public static void main(String[] args) {

  }
}
//======================================================================================================================
//                                  Business delegate pattern
//======================================================================================================================
/*
Business delegate is a Java EE design pattern. [1] This pattern is directing to reduce the coupling in between
business services and the connected presentation tier, and to hide the implementation details of services
(including lookup and accessibility of EJB architecture).[1][2] Business delegates acts as an adaptor to invoke
business objects from the presentation tier.[3]
*/

//======================================================================================================================
//                                            Structure
//======================================================================================================================
/*
Requests to access underlying business services are sent from clients, and lookup services are used by business
delegates to locate the business service components.[1]

Components
===========
Basic components are Business delegate, Lookup service and business service.

Business delegate
=================
Control and protection are provided through business delegate which can have two types of constructures,
without ID and with ID, where ID is a string version of the reference to a remote object such as EJBHome
or EJBObject.[1]

Lookup Service
==============
Business service is located by lookup service which is used by the business delegate. The implementation details
of business service lookup is encapsulated by lookup service.[1]

Business Service
================
This a business-tier component, such as an enterprise bean or a JMS component, which provides the required service
to the client.[1]
*/

//======================================================================================================================
//                                            Consequences
//======================================================================================================================
/*
Some consequences are as follows:
=================================

      .More flexibility and maintainability as intermediate business delegate layer decouples the business layer
       from the presentation layer.

      .Business delegate exposes a uniform API to the presentation tier to access business logic.[1][3]
*/

//======================================================================================================================
//                                            Concerns
//======================================================================================================================
/*
Following concerns can be considered:

 .Maintenance due to the extra layer that increases the number of classes in the application.
 .Business delegate should take care of the changes of the remote business object interfaces, and these types of
  changes are rare.[3]
*/

//======================================================================================================================
//                                            Sample code
//======================================================================================================================
/*
A sample code for a Professional Services Application (PSA), where a Web-tier client needs to access a session bean
that implements the session facade pattern, is provided below.

Resource Delegate:

class ResourceDelegate {

  // Remote reference for Session Facade
  private ResourceSession session;

  // Class for Session Facade's Home object
  private static final Class homeClazz =
    corepatterns.apps.psa.ejb.ResourceSessionHome.class;

  // Default Constructor. Looks up home and connects
  // to session by creating a new one
  public ResourceDelegate() throws ResourceException {
    try {
      ResourceSessionHome home = (ResourceSessionHome)
        ServiceLocator.getInstance().getHome(
          "Resource", homeClazz);
      session = home.create();
    } catch(ServiceLocatorException ex) {
      // Translate Service Locator exception into
      // application exception
      throw new ResourceException(...);
    } catch(CreateException ex) {
      // Translate the Session create exception into
      // application exception
      throw new ResourceException(...);
    } catch(RemoteException ex) {
      // Translate the Remote exception into
      // application exception
      throw new ResourceException(...);
    }
  }


  public BusinessDelegate(String id)
    throws ResourceException {
    super();
    reconnect(id);
  }


  public String getID() {
    try {
      return ServiceLocator.getId(session);
    } catch (Exception e) {
      // Throw an application exception
    }
  }

  public void reconnect(String id)
    throws ResourceException {
    try {
      session = (ResourceSession)
        ServiceLocator.getService(id);
    } catch (RemoteException ex) {
      // Translate the Remote exception into
      // application exception
      throw new ResourceException(...);
    }
  }


  public ResourceTO setCurrentResource(
    String resourceId)
    throws ResourceException {
    try {
      return session.setCurrentResource(resourceId);
    } catch (RemoteException ex) {
      // Translate the service exception into
      // application exception
      throw new ResourceException(...);
    }
  }

  public ResourceTO getResourceDetails()
    throws ResourceException {

    try {
      return session.getResourceDetails();
    } catch(RemoteException ex) {
      // Translate the service exception into
      // application exception
      throw new ResourceException(...);
    }
  }

  public void setResourceDetails(ResourceTO vo)
    throws ResourceException {
    try {
      session.setResourceDetails(vo);
    } catch(RemoteException ex) {
      throw new ResourceException(...);
    }
  }

  public void addNewResource(ResourceTO vo)
    throws ResourceException {
    try {
      session.addResource(vo);
    } catch(RemoteException ex) {
      throw new ResourceException(...);
    }
  }

  // all other proxy method to session bean
  //...
}


//=================================================

 class ResourceDelegate {

  // Remote reference for Session Facade
  private ResourceSession session;

  // Class for Session Facade's Home object
  private static final Class homeClazz = corepatterns.apps.psa.ejb.ResourceSessionHome.class;

  // Default Constructor. Looks up home and connects
  // to session by creating a new one
  public ResourceDelegate() throws ResourceException {
    try {
      ResourceSessionHome home = (ResourceSessionHome)
        ServiceLocator.getInstance().getHome(
          "Resource", homeClazz);
      session = home.create();
    } catch(ServiceLocatorException ex) {
      // Translate Service Locator exception into
      // application exception
      throw new ResourceException(...);
    } catch(CreateException ex) {
      // Translate the Session create exception into
      // application exception
      throw new ResourceException(...);
    } catch(RemoteException ex) {
      // Translate the Remote exception into
      // application exception
      throw new ResourceException(...);
    }
  }

  public BusinessDelegate(String id)
    throws ResourceException {
    super();
    reconnect(id);
  }

  public String getID() {
    try {
      return ServiceLocator.getId(session);
    } catch (Exception e) {
      // Throw an application exception
    }
  }

  public void reconnect(String id)
    throws ResourceException {
    try {
      session = (ResourceSession)
        ServiceLocator.getService(id);
    } catch (RemoteException ex) {
      // Translate the Remote exception into
      // application exception
      throw new ResourceException(...);
    }
  }


  public ResourceTO setCurrentResource(
    String resourceId)
    throws ResourceException {
    try {
      return session.setCurrentResource(resourceId);
    } catch (RemoteException ex) {
      // Translate the service exception into
      // application exception
      throw new ResourceException(...);
    }
  }

  public ResourceTO getResourceDetails()
    throws ResourceException {

    try {
      return session.getResourceDetails();
    } catch(RemoteException ex) {
      // Translate the service exception into
      // application exception
      throw new ResourceException(...);
    }
  }

  public void setResourceDetails(ResourceTO vo)
    throws ResourceException {
    try {
      session.setResourceDetails(vo);
    } catch(RemoteException ex) {
      throw new ResourceException(...);
    }
  }

  public void addNewResource(ResourceTO vo)
    throws ResourceException {
    try {
      session.addResource(vo);
    } catch(RemoteException ex) {
      throw new ResourceException(...);
    }
  }

  // all other proxy method to session bean
  //...
}

*/









